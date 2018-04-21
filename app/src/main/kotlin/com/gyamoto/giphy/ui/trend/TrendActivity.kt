package com.gyamoto.giphy.ui.trend

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.ActivityInjector
import com.github.salomonbrys.kodein.instance
import com.gyamoto.giphy.R
import com.gyamoto.giphy.databinding.ActivityTrendBinding
import com.gyamoto.giphy.redux.asBehaviorSubject
import io.reactivex.disposables.Disposable
import redux.api.Store

class TrendActivity : AppCompatActivity(), ActivityInjector {

    companion object {

        fun start(activity: AppCompatActivity) {
            activity.startActivity(
                    Intent(activity, TrendActivity::class.java)
            )
        }
    }

    override val injector: KodeinInjector = KodeinInjector()

    override fun provideOverridingModule() = Kodein.Module {
        import(trendModule)
    }

    private val store: Store<TrendState> by instance()

    private lateinit var binding: ActivityTrendBinding
    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trend)
    }

    override fun onStart() {
        super.onStart()

        store.dispatch(TrendAction.Refresh())

        disposable = store.asBehaviorSubject().subscribe {
            binding.state = it

            if (it.items.isNotEmpty()) {
                val message = getString(R.string.trend_success, it.items.size)
                Snackbar.make(binding.recycler, message, Snackbar.LENGTH_SHORT)
                        .show()
            }

            it.error?.let {
                val message = getString(R.string.common_error, it.message)
                Snackbar.make(binding.recycler, message, Snackbar.LENGTH_SHORT)
                        .setAction(R.string.common_retry, {
                            store.dispatch(TrendAction.Refresh())
                        })
                        .show()
            }
        }
    }

    override fun onStop() {
        disposable.dispose()
        super.onStop()
    }

    override fun onDestroy() {
        destroyInjector()
        super.onDestroy()
    }
}
