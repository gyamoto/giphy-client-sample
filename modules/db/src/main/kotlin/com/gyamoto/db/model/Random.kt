package com.gyamoto.db.model

import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Setter
import com.github.gfx.android.orma.annotation.Table
import com.gyamoto.api.model.RandomResponse

@Table
data class Random(

        @PrimaryKey
        @Setter("randomId")
        val randomId: String = "",

        @Column
        @Setter("data")
        val data: Gif,

        @Column
        @Setter("meta")
        val meta: Meta
) {
    constructor(random: RandomResponse) : this(
            data = Gif(random.data),
            meta = Meta(random.meta)
    )

    fun toRandomResponse() = RandomResponse(
            data = data.toRandomGif(),
            meta = meta.toMeta()
    )
}
