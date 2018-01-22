package com.giphy.model.mock

import com.giphy.model.Preview

object Preview {

    val mock = Preview(
            /**
             * The URL for this GIF in .MP4 format.
             * sample: "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy-downsized_s.gif"
             */
            mp4 = "https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy-downsized_s.gif",

            /**
             * The size of this file in bytes.
             * sample: "20241"
             */
            mp4_size = "20241",

            /**
             * The width of this file in pixels.
             * sample: "320"
             */
            width = "320",

            /**
             * The height of this file in pixels.
             * sample: "200"
             */
            height = "200"
    )
}
