package com.kyamamoto.kodein.ui.trend

import android.support.annotation.VisibleForTesting
import com.giphy.Api
import com.giphy.model.Gif
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.kyamamoto.kodein.domain.giphy.Giphy
import com.kyamamoto.kodein.redux.AsyncAction
import com.kyamamoto.kodein.redux.createAsyncMiddleware
import com.kyamamoto.kodein.redux.createLoggingMiddleware
import io.reactivex.Completable
import io.reactivex.Single
import redux.api.Dispatcher
import redux.api.Reducer
import redux.api.Store
import redux.api.enhancer.Middleware
import redux.applyMiddleware
import redux.combineReducers
import redux.createStore

enum class TrendLoading {
    NONE,
    REFRESH,
    LOADING
}

data class TrendState(
        val loading: TrendLoading = TrendLoading.NONE,
        val items: List<Giphy> = emptyList(),
        val error: Throwable? = null
)

sealed class TrendAction {
    class Refresh : TrendAction()
    data class Append(val offset: Int = Api.DEFAULT_LIMIT) : TrendAction()
    data class AddFavorite(val gif: Gif) : TrendAction()
    data class RemoveFavorite(val gif: Gif) : TrendAction()
}

private val reducer = Reducer<TrendState> { state, action ->
    when (action) {
        is TrendAction.AddFavorite -> {
            val newItems = state.items.map {
                if (it.gif.id == action.gif.id) it.copy(favorite = true) else it
            }
            state.copy(items = newItems)
        }
        is TrendAction.RemoveFavorite -> {
            val newItems = state.items.map {
                if (it.gif.id == action.gif.id) it.copy(favorite = false) else it
            }
            state.copy(items = newItems)
        }
        else -> state
    }
}

@VisibleForTesting
val asyncReducer = Reducer<TrendState> { state, action ->
    when (action) {
        is AsyncAction<*> -> when (action.tag) {
            is TrendAction.Refresh -> action.reduce<TrendState, List<Giphy>>(
                    onStart = {
                        state.copy(
                                loading = TrendLoading.REFRESH
                        )
                    },
                    onSuccess = {
                        state.copy(
                                loading = TrendLoading.NONE,
                                items = it,
                                error = null
                        )
                    },
                    onError = {
                        state.copy(
                                loading = TrendLoading.NONE,
                                error = it
                        )
                    })
            is TrendAction.Append -> action.reduce<TrendState, List<Giphy>>(
                    onStart = {
                        state.copy(
                                loading = TrendLoading.LOADING
                        )
                    },
                    onSuccess = {
                        state.copy(
                                loading = TrendLoading.NONE,
                                items = state.items + it,
                                error = null
                        )
                    },
                    onError = {
                        state.copy(
                                loading = TrendLoading.NONE,
                                error = it
                        )
                    })
            else -> state
        }
        else -> state
    }
}

class TrendRepository(private val api: Api) {

    fun requestTrend(offset: Int = 0): Single<List<Giphy>> {
        return api.trending(offset = offset)
                .map {
                    it.data.map { Giphy(it, false) }
                }
    }

    fun addFavorite(gif: Gif): Completable {
        // TODO
        return Completable.complete()
    }

    fun removeFavorite(gif: Gif): Completable {
        // TODO
        return Completable.complete()
    }
}

class TrendMiddleware(private val repository: TrendRepository) : Middleware<TrendState> {

    override fun dispatch(store: Store<TrendState>, next: Dispatcher, action: Any): Any {
        val nextAction = when (action) {
            is TrendAction.Refresh -> {
                AsyncAction.of(
                        action,
                        repository.requestTrend())
            }
            is TrendAction.Append -> {
                AsyncAction.of(
                        action,
                        repository.requestTrend(action.offset))
            }
            is TrendAction.AddFavorite -> {
                AsyncAction.of(
                        action,
                        repository.addFavorite(action.gif).toSingle {})
            }
            is TrendAction.RemoveFavorite -> {
                AsyncAction.of(
                        action,
                        repository.removeFavorite(action.gif).toSingle {})
            }
            else -> action
        }
        return next.dispatch(nextAction)
    }
}

fun createTrendStore(middleware: TrendMiddleware): Store<TrendState> = createStore(
        combineReducers(
                reducer,
                asyncReducer),
        TrendState(),
        applyMiddleware(
                middleware,
                createLoggingMiddleware("TrendStore"),
                createAsyncMiddleware())
)

val trendModule = Kodein.Module {

    bind<Store<TrendState>>() with singleton {
        createTrendStore(TrendMiddleware(TrendRepository(instance())))
    }
}
