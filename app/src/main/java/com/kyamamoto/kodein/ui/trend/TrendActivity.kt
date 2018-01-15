package com.kyamamoto.kodein.ui.trend

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager.VERTICAL
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.ActivityInjector
import com.github.salomonbrys.kodein.instance
import com.kyamamoto.kodein.R
import com.kyamamoto.kodein.domain.giphy.Giphy
import com.kyamamoto.kodein.redux.asBehaviorSubject
import com.kyamamoto.kodein.ui.common.AbstractViewHolder
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_trend.*
import kotlinx.android.synthetic.main.item_giphy.view.*
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

    private lateinit var disposable: Disposable
    private lateinit var adapter: RecyclerView.Adapter<GiphyViewHolder>
    private var items = emptyList<Giphy>()

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend)

        adapter = object : RecyclerView.Adapter<GiphyViewHolder>() {

            override fun getItemCount(): Int = items.size

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiphyViewHolder {
                return GiphyViewHolder(parent)
            }

            override fun onBindViewHolder(holder: GiphyViewHolder, position: Int) {
                val item = items[position]
                holder.bind(item)
            }
        }
        recycler.adapter = adapter
        recycler.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
    }

    override fun onStart() {
        super.onStart()

        store.dispatch(TrendAction.Refresh())

        disposable = store.asBehaviorSubject().subscribe({
            Snackbar.make(recycler, "success! get ${it.items.size}git", Snackbar.LENGTH_SHORT)
                    .show()
            items = it.items
            adapter.notifyDataSetChanged()
        }, {
            Snackbar.make(recycler, "error! ${it.message}", Snackbar.LENGTH_SHORT)
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

    inner class GiphyViewHolder(parent: ViewGroup)
        : AbstractViewHolder(parent, R.layout.item_giphy) {

        fun bind(giphy: Giphy) {
            val layoutParam = itemView.image.layoutParams as? ConstraintLayout.LayoutParams
            layoutParam?.let {
                val size = giphy.gif.images.preview_gif
                it.dimensionRatio = "${size.width}:${size.height}"
            }

            Glide.with(itemView.context)
                    .load(giphy.gif.images.preview_gif.url)
                    .into(itemView.image)
        }

    }
}
