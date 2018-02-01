package com.kyamamoto.kodein.ui.trend

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager.VERTICAL
import android.view.ViewGroup
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.ActivityInjector
import com.github.salomonbrys.kodein.instance
import com.kyamamoto.kodein.R
import com.kyamamoto.kodein.databinding.ActivityTrendBinding
import com.kyamamoto.kodein.databinding.ItemGiphyBinding
import com.kyamamoto.kodein.domain.giphy.Giphy
import com.kyamamoto.kodein.redux.asBehaviorSubject
import com.kyamamoto.kodein.ui.common.AbstractDataBindingViewHolder
import io.reactivex.disposables.Disposable
import redux.api.Store

/**
 * Created by kyamamoto on 2017/12/11.
 */
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
    private lateinit var giphyAdapter: GiphyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trend)

        giphyAdapter = GiphyAdapter()

        binding.recycler.apply {
            adapter = giphyAdapter
            layoutManager = GridLayoutManager(context, 2, VERTICAL, false)
        }
    }

    override fun onStart() {
        super.onStart()

        store.dispatch(TrendAction.Refresh())

        disposable = store.asBehaviorSubject().subscribe({
            binding.state = it
            giphyAdapter.items = it.items

            if (it.items.isNotEmpty()) {
                Snackbar.make(binding.recycler, "success! get ${it.items.size}git", Snackbar.LENGTH_SHORT)
                        .show()
            }
        }, {
            Snackbar.make(binding.recycler, "error! ${it.message}", Snackbar.LENGTH_SHORT)
                    .setAction("action?", {
                        store.dispatch(TrendAction.Refresh())
                    })
                    .show()
        })
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

class GiphyAdapter : RecyclerView.Adapter<GiphyViewHolder>() {

    var items = emptyList<Giphy>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiphyViewHolder {
        return GiphyViewHolder(parent)
    }

    override fun onBindViewHolder(holder: GiphyViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}

class GiphyViewHolder(parent: ViewGroup)
    : AbstractDataBindingViewHolder<ItemGiphyBinding>(parent, R.layout.item_giphy) {

    fun bind(giphy: Giphy) {
        binding.model = giphy
    }

}
