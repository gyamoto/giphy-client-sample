package com.gyamoto.api.model

/**
 * Data surrounding a version of this GIF downsized to be under 2mb.
 */
data class Downsized(

        /**
         * The publicly-accessible direct URL for this GIF.
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy-downsized.gif"
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
         * sample: "12381"
         */
        val size: String
)
