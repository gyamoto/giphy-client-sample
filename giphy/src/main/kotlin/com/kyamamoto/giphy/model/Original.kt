package com.kyamamoto.giphy.model

/**
 * Data surrounding the original version of this GIF. Good for desktop use.
 */
data class Original(

        /**
         * The publicly-accessible direct URL for this GIF.\
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.gif"
         */
        val url: String,

        /**
         * The width of this GIF in pixels.\
         * sample: "320"
         */
        val width: String,

        /**
         * The height of this GIF in pixels.\
         * sample: "200"
         */
        val height: String,

        /**
         * The size of this GIF in bytes.\
         * sample: "32381"
         */
        val size: String,

        /**
         * The number of frames in this GIF.\
         * sample: "15"
         */
        val frames: String,

        /**
         * The URL for this GIF in .MP4 format.\
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.mp4"
         */
        val mp4: String,

        /**
         * The size in bytes of the .MP4 file corresponding to this GIF.\
         * sample: "25123"
         */
        val mp4_size: String,

        /**
         * The URL for this GIF in .webp format.\
         * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.webp"
         */
        val webp: String,

        /**
         * The size in bytes of the .webp file corresponding to this GIF.\
         * sample: "12321"
         */
        val webp_size: String
)
