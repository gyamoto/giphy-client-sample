package com.kyamamoto.persistentrandom.model

import com.kyamamoto.giphy.model.RandomGif

/**
 * Created by kyamamoto on 2018/02/16.
 */
data class Gif(

        val type: String,

        val id: String,

        val url: String,

        val image_original_url: String,

        val image_url: String,

        val image_mp4_url: String,

        val image_frames: String,

        val image_width: String,

        val image_height: String,

        val fixed_height_downsampled_url: String,

        val fixed_height_downsampled_width: String,

        val fixed_height_downsampled_height: String,

        val fixed_width_downsampled_url: String,

        val fixed_width_downsampled_width: String,

        val fixed_width_downsampled_height: String,

        val fixed_height_small_url: String,

        val fixed_height_small_still_url: String,

        val fixed_height_small_width: String,

        val fixed_height_small_height: String,

        val fixed_width_small_url: String,

        val fixed_width_small_still_url: String,

        val fixed_width_small_width: String,

        val fixed_width_small_height: String,

        val username: String,

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
