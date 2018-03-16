package com.gyamoto.db.model

import android.support.annotation.Nullable
import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Setter
import com.github.gfx.android.orma.annotation.Table
import com.gyamoto.api.model.Meta

@Table
data class Meta(

        @PrimaryKey
        @Setter("metaId")
        val metaId: String = "",

        @Column
        @Setter("msg")
        val msg: String,

        @Column
        @Setter("status")
        val status: Int,

        @Column
        @Setter("response_id")
        @Nullable
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
