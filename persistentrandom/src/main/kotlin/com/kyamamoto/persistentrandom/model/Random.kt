package com.kyamamoto.persistentrandom.model

import com.kyamamoto.giphy.model.RandomResponse

/**
 * Created by kyamamoto on 2018/02/16.
 */
data class Random(
        val data: Gif,
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
