package com.giphy.model

/**
 * Data surrounding a version of this GIF in .MP4 format limited to 50kb that displays the first 1-2 seconds of the GIF.
 */
data class Preview(

        /**
         * The URL for this GIF in .MP4 format.
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy-preview.mp4"
         */
        val mp4: String,

        /**
         * The size of this file in bytes.
         * sample: "20241"
         */
        val mp4_size: String,

        /**
         * The width of this file in pixels.
         * sample: "320"
         */
        val width: String,

        /**
         * The height of this file in pixels.
         * sample: "200"
         */
        val height: String
)