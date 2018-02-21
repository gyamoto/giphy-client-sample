package com.kyamamoto.giphy.model.mock

import com.kyamamoto.giphy.model.Still

object Still {

    val mock = Still(
            /**
             * The publicly-accessible direct URL for this GIF.
             * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy-downsized_s.gif"
             */
            url = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy-downsized_s.gif",

            /**
             * The width of this GIF in pixels.
             * sample: "320"
             */
            width = "320",

            /**
             * The height of this GIF in pixels.
             * sample: "200"
             */
            height = "200"
    )

}
