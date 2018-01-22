package com.giphy.model

/**
 * Data surrounding versions of this GIF with a fixed height of 200 pixels. Good for mobile use.
 */
data class Size(

        /**
         * The publicly-accessible direct URL for this GIF.
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200.gif"
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
         * The URL for this GIF in .MP4 format.
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200.mp4"
         */
        val mp4: String,

        /**
         * The size in bytes of the .MP4 file corresponding to this GIF.
         * sample: "25123"
         */
        val mp4_size: String,

        /**
         * The URL for this GIF in .webp format.
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200.webp"
         */
        val webp: String,

        /**
         * The size in bytes of the .webp file corresponding to this GIF.
         * sample: "12321"
         */
        val webp_size: String
)
