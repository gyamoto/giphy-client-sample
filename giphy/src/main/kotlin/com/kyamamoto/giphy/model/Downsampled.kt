package com.kyamamoto.giphy.model

/**
 * Data surrounding versions of this GIF with a fixed width of 200 pixels and the number of frames reduced to 6.
 */
data class Downsampled(

        /**
         * The publicly-accessible direct URL for this GIF.
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200w_d.gif"
         */
        val url: String,

        /**
         * The width of this GIF in pixels.
         * sample: "320"
         */
        val width: String,

        /**
         * The height of this GIF in pixels.
         * sample: "200"
         */
        val height: String,

        /**
         * The size of this GIF in bytes.
         * sample: "32381"
         */
        val size: String,

        /**
         * The URL for this GIF in .webp format.
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200w_d.webp"
         */
        val webp: String,

        /**
         * The size in bytes of the .webp file corresponding to this GIF.
         * sample: "12321"
         */
        val webp_size: String
)
