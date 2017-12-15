package com.kyamamoto.kodein.ui.trend

import android.support.annotation.VisibleForTesting
import com.giphy.ApiBuilder
import com.giphy.model.Gif
import com.giphy.model.PaginationResponse
import com.kyamamoto.kodein.redux.AsyncAction
import com.kyamamoto.kodein.redux.createAsyncMiddleware
import com.kyamamoto.kodein.redux.createLoggingMiddleware
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
        val items: List<Gif> = emptyList(),
        val error: Throwable? = null
)

sealed class TrendAction {
    class Refresh : TrendAction()
    data class Append(val offset: Int) : TrendAction()
}

@VisibleForTesting
val reducer = Reducer<TrendState> { state, action ->
    when (action) {
        is TrendAction.Refresh -> {
            state
        }
        is TrendAction.Append -> {
            state
        }
        else -> state
    }
}

@VisibleForTesting
val asyncReducer = Reducer<TrendState> { state, action ->
    when (action) {
        is AsyncAction<*> -> when (action.tag) {
            is TrendAction.Refresh -> action.reduce<TrendState, PaginationResponse>(
                    onStart = {
                        state.copy(
                                loading = TrendLoading.REFRESH
                        )
                    },
                    onSuccess = {
                        state.copy(
                                loading = TrendLoading.NONE,
                                items = it.data,
                                error = null
                        )
                    },
                    onError = {
                        state.copy(
                                loading = TrendLoading.NONE,
                                error = it
                        )
                    })
            is TrendAction.Append -> action.reduce<TrendState, PaginationResponse>(
                    onStart = {
                        state.copy(
                                loading = TrendLoading.LOADING
                        )
                    },
                    onSuccess = {
                        state.copy(
                                loading = TrendLoading.NONE,
                                items = state.items + it.data,
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

class TrendRepository {

    // TODO: Inject
    private val api = ApiBuilder.build()

    fun requestTrend(offset: Int = 0): Single<PaginationResponse> {
        return api.trending("HAgW7cCO48PXdJSSeoo7Dq5tttTu3M8r", offset)
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
            else -> action
        }
        return next.dispatch(nextAction)
    }
}

fun createTrendStore(): Store<TrendState> = createStore(
        combineReducers(
                reducer,
                asyncReducer),
        TrendState(),
        applyMiddleware(
                TrendMiddleware(TrendRepository()),
                createLoggingMiddleware("TrendStore"),
                createAsyncMiddleware())
)
