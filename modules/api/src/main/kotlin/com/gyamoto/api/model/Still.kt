package com.gyamoto.api.model

/**
 * Data surrounding a static preview image of the downsized version of this GIF.
 */
data class Still(

        /**
         * The publicly-accessible direct URL for this GIF.
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy-downsized_s.gif"
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
        val height: String
)
