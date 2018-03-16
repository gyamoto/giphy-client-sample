package com.gyamoto.api.model.mock

import com.gyamoto.api.model.Downsized

object Downsized {

    val mock = Downsized(
            /**
             * The publicly-accessible direct URL for this GIF.
             * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy-downsized.gif"
             */
            url = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy-downsized.gif",

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
             * sample: "12381"
             */
            size = "12381")
}
