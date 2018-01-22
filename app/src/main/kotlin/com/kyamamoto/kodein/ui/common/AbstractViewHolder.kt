package com.kyamamoto.kodein.ui.common

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * コンストラクタに渡した[ViewGroup]と[LayoutRes]からitemViewを生成する[RecyclerView.ViewHolder]
 */
abstract class AbstractViewHolder(parent: ViewGroup, @LayoutRes layout: Int)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
