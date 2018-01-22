package com.giphy.model.mock

import com.giphy.model.Original

object Original {

    val mock = Original(

            /**
             * The publicly-accessible direct URL for this GIF.\
             * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.gif"
             */
            url = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.gif",

            /**
             * The width of this GIF in pixels.\
             * sample: "320"
             */
            width = "320",

            /**
             * The height of this GIF in pixels.\
             * sample: "200"
             */
            height = "200",

            /**
             * The size of this GIF in bytes.\
             * sample: "32381"
             */
            size = "32381",

            /**
             * The number of frames in this GIF.\
             * sample: "15"
             */
            frames = "15",

            /**
             * The URL for this GIF in .MP4 format.\
             * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.mp4"
             */
            mp4 = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.mp4",

            /**
             * The size in bytes of the .MP4 file corresponding to this GIF.\
             * sample: "25123"
             */
            mp4_size = "25123",

            /**
             * The URL for this GIF in .webp format.\
             * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.webp"
             */
            webp = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.webp",

            /**
             * The size in bytes of the .webp file corresponding to this GIF.\
             * sample: "12321"
             */
            webp_size = "12321"
    )
}
