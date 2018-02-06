package com.kyamamoto.giphy.model.mock

import com.kyamamoto.giphy.model.Downsampled

object Downsampled {

    val mock = Downsampled(
            /**
             * The publicly-accessible direct URL for this GIF.
             * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200w_d.gif"
             */
            url = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200w_d.gif",

            /**
             * The width of this GIF in pixels.
             * sample: "320"
             */
            width = "320",

            /**
             * The height of this GIF in pixels.
             * sample: "200"
             */
            height = "200",

            /**
             * The size of this GIF in bytes.
             * sample: "32381"
             */
            size = "32381",

            /**
             * The URL for this GIF in .webp format.
             * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200w_d.webp"
             */
            webp = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/200w_d.webp",

            /**
             * The size in bytes of the .webp file corresponding to this GIF.
             * sample: "12321"
             */
            webp_size = "12321"
    )
}
