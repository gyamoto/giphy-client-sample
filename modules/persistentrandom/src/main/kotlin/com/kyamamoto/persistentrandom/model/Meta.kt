package com.kyamamoto.persistentrandom.model

import com.kyamamoto.giphy.model.Meta

/**
 * Created by kyamamoto on 2018/02/16.
 */
data class Meta(

        val msg: String,

        val status: Int,

        val response_id: String? = null
) {
    constructor(meta: Meta) : this(
            msg = meta.msg,
            status = meta.status,
            response_id = meta.response_id
    )

    fun toMeta() = Meta(
            msg = msg,
            status = status,
            response_id = response_id
    )
}
