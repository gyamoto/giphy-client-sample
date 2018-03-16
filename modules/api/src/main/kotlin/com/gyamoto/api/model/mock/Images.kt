package com.gyamoto.api.model.mock

import com.gyamoto.api.model.Images

object Images {

    val mock = Images(
            /**
             * Data surrounding versions of this GIF with a fixed height of 200 pixels. Good for mobile use.
             */
            fixed_height = Size.mock,
            /**
             * Data surrounding a static image of this GIF with a fixed height of 200 pixels.
             */
            fixed_height_still = Still.mock,
            /**
             * Data surrounding versions of this GIF with a fixed height of 200 pixels and the number of frames reduced to 6.
             */
            fixed_height_downsampled = Downsampled.mock,
            /**
             * Data surrounding versions of this GIF with a fixed width of 200 pixels. Good for mobile use.
             */
            fixed_width = Size.mock,
            /**
             * Data surrounding a static image of this GIF with a fixed width of 200 pixels.
             */
            fixed_width_still = Still.mock,
            /**
             * Data surrounding versions of this GIF with a fixed width of 200 pixels and the number of frames reduced to 6.
             */
            fixed_width_downsampled = Downsampled.mock,
            /**
             * Data surrounding versions of this GIF with a fixed height of 100 pixels. Good for mobile keyboards.
             */
            fixed_height_small = Size.mock,
            /**
             * Data surrounding a static image of this GIF with a fixed height of 100 pixels.
             */
            fixed_height_small_still = Still.mock,
            /**
             * Data surrounding versions of this GIF with a fixed width of 100 pixels. Good for mobile keyboards.
             */
            fixed_width_small = Size.mock,
            /**
             * Data surrounding a static image of this GIF with a fixed width of 100 pixels.
             */
            fixed_width_small_still = Still.mock,
            /**
             * Data surrounding a version of this GIF downsized to be under 2mb.
             */
            downsized = Downsized.mock,
            /**
             * Data surrounding a static preview image of the downsized version of this GIF.
             */
            downsized_still = Still.mock,
            /**
             * Data surrounding a version of this GIF downsized to be under 8mb.
             */
            downsized_large = Downsized.mock,
            /**
             * Data surrounding a version of this GIF downsized to be under 5mb.
             */
            downsized_medium = Downsized.mock,
            /**
             * Data surrounding a version of this GIF downsized to be under 200kb.
             */
            downsized_small = Downsized.mock,
            /**
             * Data surrounding the original version of this GIF. Good for desktop use.
             */
            original = Original.mock,
            /**
             * Data surrounding a static preview image of the original GIF.
             */
            original_still = Still.mock,
            /**
             * Data surrounding a version of this GIF set to loop for 15 seconds.
             */
            looping = Looping.mock,
            /**
             * Data surrounding a version of this GIF in .MP4 format limited to 50kb that displays the first 1-2 seconds of the GIF.
             */
            preview = Preview.mock,
            /**
             * Data surrounding a version of this GIF limited to 50kb that displays the first 1-2 seconds of the GIF.
             */
            preview_gif = Downsized.mock
    )
}
