package com.gyamoto.giphy.ui.common

import android.support.v7.util.DiffUtil
import com.gyamoto.giphy.domain.giphy.Giphy

object GiphyDiffCalculator : DiffUtil.ItemCallback<Giphy>() {

    override fun areItemsTheSame(oldItem: Giphy?, newItem: Giphy?): Boolean {
        return oldItem?.gif?.id == newItem?.gif?.id
    }

    override fun areContentsTheSame(oldItem: Giphy?, newItem: Giphy?): Boolean {
        return oldItem == newItem
    }

}
