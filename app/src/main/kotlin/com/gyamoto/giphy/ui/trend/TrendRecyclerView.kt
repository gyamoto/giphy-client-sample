package com.gyamoto.giphy.ui.trend

import android.content.Context
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.ViewGroup
import com.gyamoto.giphy.R
import com.gyamoto.giphy.databinding.ItemGiphyBinding
import com.gyamoto.giphy.domain.giphy.Giphy
import com.gyamoto.giphy.ui.common.AbstractDataBindingViewHolder
import com.gyamoto.giphy.ui.common.GiphyDiffCalculator

class TrendRecyclerView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : RecyclerView(context, attrs, defStyle) {

    private val giphyAdapter = GiphyAdapter()

    init {
        adapter = giphyAdapter
        layoutManager = GridLayoutManager(context, 2, VERTICAL, false)
    }

    var items: List<Giphy> = emptyList()
        set(value) {
            field = value
            giphyAdapter.submitList(items)
        }

    inner class GiphyAdapter : ListAdapter<Giphy, GiphyViewHolder>(GiphyDiffCalculator) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiphyViewHolder {
            return GiphyViewHolder(parent)
        }

        override fun onBindViewHolder(holder: GiphyViewHolder, position: Int) {
            holder.bind(getItem(position))
        }
    }

    inner class GiphyViewHolder(parent: ViewGroup)
        : AbstractDataBindingViewHolder<ItemGiphyBinding>(parent, R.layout.item_giphy) {

        fun bind(giphy: Giphy) {
            binding.model = giphy
        }

    }
}
