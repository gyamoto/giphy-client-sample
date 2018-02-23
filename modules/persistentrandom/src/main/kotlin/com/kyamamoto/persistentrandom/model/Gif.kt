package com.kyamamoto.persistentrandom.model

import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Setter
import com.github.gfx.android.orma.annotation.Table
import com.kyamamoto.giphy.model.RandomGif

/**
 * Created by kyamamoto on 2018/02/16.
 */
@Table
data class Gif(

        @Column
        @Setter("type")
        val type: String,

        @PrimaryKey(auto = false)
        @Setter("id")
        val id: String,

        @Column
        @Setter("url")
        val url: String,

        @Column
        @Setter("image_original_url")
        val image_original_url: String,

        @Column
        @Setter("image_url")
        val image_url: String,

        @Column
        @Setter("image_mp4_url")
        val image_mp4_url: String,

        @Column
        @Setter("image_frames")
        val image_frames: String,

        @Column
        @Setter("image_width")
        val image_width: String,

        @Column
        @Setter("image_height")
        val image_height: String,

        @Column
        @Setter("fixed_height_downsampled_url")
        val fixed_height_downsampled_url: String,

        @Column
        @Setter("fixed_height_downsampled_width")
        val fixed_height_downsampled_width: String,

        @Column
        @Setter("fixed_height_downsampled_height")
        val fixed_height_downsampled_height: String,

        @Column
        @Setter("fixed_width_downsampled_url")
        val fixed_width_downsampled_url: String,

        @Column
        @Setter("fixed_width_downsampled_width")
        val fixed_width_downsampled_width: String,

        @Column
        @Setter("fixed_width_downsampled_height")
        val fixed_width_downsampled_height: String,

        @Column
        @Setter("fixed_height_small_url")
        val fixed_height_small_url: String,

        @Column
        @Setter("fixed_height_small_still_url")
        val fixed_height_small_still_url: String,

        @Column
        @Setter("fixed_height_small_width")
        val fixed_height_small_width: String,

        @Column
        @Setter("fixed_height_small_height")
        val fixed_height_small_height: String,

        @Column
        @Setter("fixed_width_small_url")
        val fixed_width_small_url: String,

        @Column
        @Setter("fixed_width_small_still_url")
        val fixed_width_small_still_url: String,

        @Column
        @Setter("fixed_width_small_width")
        val fixed_width_small_width: String,

        @Column
        @Setter("fixed_width_small_height")
        val fixed_width_small_height: String,

        @Column
        @Setter("username")
        val username: String,

        @Column
        @Setter("caption")
        val caption: String
) {
    constructor(gif: RandomGif) : this(
            type = gif.type,
            id = gif.id,
            url = gif.url,
            image_original_url = gif.image_original_url,
            image_url = gif.image_url,
            image_mp4_url = gif.image_mp4_url,
            image_frames = gif.image_frames,
            image_width = gif.image_width,
            image_height = gif.image_height,
            fixed_height_downsampled_url = gif.fixed_height_downsampled_url,
            fixed_height_downsampled_width = gif.fixed_height_downsampled_width,
            fixed_height_downsampled_height = gif.fixed_height_downsampled_height,
            fixed_width_downsampled_url = gif.fixed_width_downsampled_url,
            fixed_width_downsampled_width = gif.fixed_width_downsampled_width,
            fixed_width_downsampled_height = gif.fixed_width_downsampled_height,
            fixed_height_small_url = gif.fixed_height_small_url,
            fixed_height_small_still_url = gif.fixed_height_small_still_url,
            fixed_height_small_width = gif.fixed_height_small_width,
            fixed_height_small_height = gif.fixed_height_small_height,
            fixed_width_small_url = gif.fixed_width_small_url,
            fixed_width_small_still_url = gif.fixed_width_small_still_url,
            fixed_width_small_width = gif.fixed_width_small_width,
            fixed_width_small_height = gif.fixed_width_small_height,
            username = gif.username,
            caption = gif.caption
    )

    fun toRandomGif() = RandomGif(
            type = type,
            id = id,
            url = url,
            image_original_url = image_original_url,
            image_url = image_url,
            image_mp4_url = image_mp4_url,
            image_frames = image_frames,
            image_width = image_width,
            image_height = image_height,
            fixed_height_downsampled_url = fixed_height_downsampled_url,
            fixed_height_downsampled_width = fixed_height_downsampled_width,
            fixed_height_downsampled_height = fixed_height_downsampled_height,
            fixed_width_downsampled_url = fixed_width_downsampled_url,
            fixed_width_downsampled_width = fixed_width_downsampled_width,
            fixed_width_downsampled_height = fixed_width_downsampled_height,
            fixed_height_small_url = fixed_height_small_url,
            fixed_height_small_still_url = fixed_height_small_still_url,
            fixed_height_small_width = fixed_height_small_width,
            fixed_height_small_height = fixed_height_small_height,
            fixed_width_small_url = fixed_width_small_url,
            fixed_width_small_still_url = fixed_width_small_still_url,
            fixed_width_small_width = fixed_width_small_width,
            fixed_width_small_height = fixed_width_small_height,
            username = username,
            caption = caption
    )
}
