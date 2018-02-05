package com.kyamamoto.kodein.redux

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import redux.api.Store
import redux.api.enhancer.Middleware
import timber.log.Timber

/**
 * この[Store]を[Observable]として扱う
 *
 * 状態が変更されると、変更後の値がエミットされる。
 */
fun <S> Store<S>.asObservable(emitOnSubscribe: Boolean = false): Observable<S> {
    return Observable.create { emitter ->
        if (emitter.isDisposed) return@create
        if (emitOnSubscribe) emitter.onNext(state)
        subscribe { emitter.onNext(state) }
                .let { Disposables.fromAction { it.unsubscribe() } }
                .let { emitter.setDisposable(it) }
    }
}

/**
 * この[Store]を`BehaviorSubject`のように`subscribe`した際に現在の値がエミットされるような[Observable]として扱う
 */
fun <S> Store<S>.asBehaviorSubject() = asObservable(true)

/**
 * アクションとそれによる状態の変化をログ出力するミドルウェアを作成する
 */
fun <S> createLoggingMiddleware(tag: String): Middleware<S> {
    return Middleware { store, next, action ->
        val old = store.state
        val result = next.dispatch(action)
        val new = store.state
        Timber.tag(tag).v("$action: $old => $new")
        result
    }
}

/**
 * 非同期処理を行うアクション
 */
sealed class AsyncAction<out T> {
    /**
     * アクション発行元を分けるためのタグ
     */
    abstract val tag: T

    inline fun <S, P> reduce(
            onStart: () -> S,
            onSuccess: (P) -> S,
            onError: (Throwable) -> S
    ): S {
        @Suppress("UNCHECKED_CAST")
        return when (this) {
            is Start<T, *> -> onStart()
            is Success<T, *> -> onSuccess(payload as P)
            is Error<T> -> onError(error)
        }
    }

    final override fun toString() = "${javaClass.simpleName}(tag=$tag)"

    companion object {
        fun <T, P> of(tag: T, single: Single<P>): AsyncAction<T> = Start(tag, single)
    }
}

class Start<out T, P>(override val tag: T, val single: Single<P>) : AsyncAction<T>()
class Success<out T, out P>(override val tag: T, val payload: P) : AsyncAction<T>()
class Error<out T>(override val tag: T, val error: Throwable) : AsyncAction<T>()

/**
 * [AsyncAction]をハンドリングするミドルウェアを作成する
 */
fun <S> createAsyncMiddleware(): Middleware<S> {
    return Middleware { _, next, action ->
        if (action is Start<*, *>) {
            action.single
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { next.dispatch(Success(action.tag, it)) },
                            { next.dispatch(Error(action.tag, it)) })
        }
        next.dispatch(action)
    }
}
