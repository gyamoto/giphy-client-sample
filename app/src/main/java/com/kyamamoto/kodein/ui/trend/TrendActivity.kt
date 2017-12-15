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
import com.giphy.model.Gif
import com.kyamamoto.kodein.R
import com.kyamamoto.kodein.redux.asBehaviorSubject
import com.kyamamoto.kodein.ui.common.AbstractViewHolder
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_trend.*
import kotlinx.android.synthetic.main.item_giphy.view.*

/**
 * Created by kyamamoto on 2017/12/11.
 */
class TrendActivity : AppCompatActivity() {

    companion object {

        fun start(activity: AppCompatActivity) {
            activity.startActivity(
                    Intent(activity, TrendActivity::class.java)
            )
        }
    }

    private lateinit var disposable: Disposable
    private lateinit var adapter: RecyclerView.Adapter<GiphyViewHolder>
    private var items = emptyList<Gif>()

    override fun onCreate(savedInstanceState: Bundle?) {
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

        val store = createTrendStore()

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

    inner class GiphyViewHolder(parent: ViewGroup)
        : AbstractViewHolder(parent, R.layout.item_giphy) {

        fun bind(gif: Gif) {
            val a = itemView.image.layoutParams as? ConstraintLayout.LayoutParams
            a?.let {
                it.dimensionRatio = "${gif.images.preview_gif.width}:${gif.images.preview_gif.height}"
            }

            Glide.with(itemView.context)
                    .load(gif.images.preview_gif.url)
                    .into(itemView.image)
        }

    }
}