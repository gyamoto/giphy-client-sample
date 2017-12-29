package com.kyamamoto.kodein.ui.trend

import com.kyamamoto.kodein.domain.giphy.Giphy
import com.kyamamoto.kodein.domain.giphy.GiphyMock
import com.kyamamoto.kodein.redux.createAsyncMiddleware
import com.kyamamoto.kodein.redux.createLoggingMiddleware
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.SingleSubject
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import redux.api.Store
import redux.applyMiddleware
import redux.combineReducers
import redux.createStore
import kotlin.test.assertEquals
import com.giphy.model.mock.PaginationResponse as PaginationResponseMock

@RunWith(RobolectricTestRunner::class)
class TrendReduxKtTest {

    private lateinit var trendSubject: SingleSubject<List<Giphy>>
    private lateinit var repository: TrendRepository
    private lateinit var store: Store<TrendState>

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            Schedulers.trampoline()
        }

        trendSubject = SingleSubject.create()

        repository = mock {
            on { requestTrend(any()) } doReturn trendSubject
        }

        // TODO: Inject
        store = createStore(
                combineReducers(
                        reducer,
                        asyncReducer),
                TrendState(),
                applyMiddleware(
                        TrendMiddleware(repository),
                        createLoggingMiddleware("TrendStore"),
                        createAsyncMiddleware())
        )
    }

    @Test
    fun `Refresh_0件時_成功`() {

        store.dispatch(TrendAction.Refresh())

        assertEquals(
                expected = TrendState(TrendLoading.REFRESH, emptyList(), null),
                actual = store.state)

        trendSubject.onSuccess(GiphyMock.mockList)

        assertEquals(
                expected = TrendState(TrendLoading.NONE, GiphyMock.mockList, null),
                actual = store.state)
    }

    @After
    fun teardown() {
        RxJavaPlugins.reset()
    }

}
