package com.gyamoto.giphy.ui.common

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * コンストラクタに渡した[ViewGroup]と[LayoutRes]からitemViewを生成する[RecyclerView.ViewHolder]
 */
abstract class AbstractViewHolder(parent: ViewGroup, @LayoutRes layout: Int)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))

abstract class AbstractDataBindingViewHolder<out T : ViewDataBinding>(val binding: T)
    : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup, @LayoutRes layout: Int)
            : this(DataBindingUtil.inflate<T>(LayoutInflater.from(parent.context), layout, parent, false))
}
