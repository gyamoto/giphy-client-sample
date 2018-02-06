package com.kyamamoto.giphy.model

/**
 * The User Object contains information about the user associated with a GIF and URLs to assets such as that user's avatar image, profile, and more.
 */
data class Images(

        /**
         * Data surrounding versions of this GIF with a fixed height of 200 pixels. Good for mobile use.
         */
        val fixed_height: Size,
        /**
         * Data surrounding a static image of this GIF with a fixed height of 200 pixels.
         */
        val fixed_height_still: Still,
        /**
         * Data surrounding versions of this GIF with a fixed height of 200 pixels and the number of frames reduced to 6.
         */
        val fixed_height_downsampled: Downsampled,
        /**
         * Data surrounding versions of this GIF with a fixed width of 200 pixels. Good for mobile use.
         */
        val fixed_width: Size,
        /**
         * Data surrounding a static image of this GIF with a fixed width of 200 pixels.
         */
        val fixed_width_still: Still,
        /**
         * Data surrounding versions of this GIF with a fixed width of 200 pixels and the number of frames reduced to 6.
         */
        val fixed_width_downsampled: Downsampled,
        /**
         * Data surrounding versions of this GIF with a fixed height of 100 pixels. Good for mobile keyboards.
         */
        val fixed_height_small: Size,
        /**
         * Data surrounding a static image of this GIF with a fixed height of 100 pixels.
         */
        val fixed_height_small_still: Still,
        /**
         * Data surrounding versions of this GIF with a fixed width of 100 pixels. Good for mobile keyboards.
         */
        val fixed_width_small: Size,
        /**
         * Data surrounding a static image of this GIF with a fixed width of 100 pixels.
         */
        val fixed_width_small_still: Still,
        /**
         * Data surrounding a version of this GIF downsized to be under 2mb.
         */
        val downsized: Downsized,
        /**
         * Data surrounding a static preview image of the downsized version of this GIF.
         */
        val downsized_still: Still,
        /**
         * Data surrounding a version of this GIF downsized to be under 8mb.
         */
        val downsized_large: Downsized,
        /**
         * Data surrounding a version of this GIF downsized to be under 5mb.
         */
        val downsized_medium: Downsized,
        /**
         * Data surrounding a version of this GIF downsized to be under 200kb.
         */
        val downsized_small: Downsized,
        /**
         * Data surrounding the original version of this GIF. Good for desktop use.
         */
        val original: Original,
        /**
         * Data surrounding a static preview image of the original GIF.
         */
        val original_still: Still,
        /**
         * Data surrounding a version of this GIF set to loop for 15 seconds.
         */
        val looping: Looping,
        /**
         * Data surrounding a version of this GIF in .MP4 format limited to 50kb that displays the first 1-2 seconds of the GIF.
         */
        val preview: Preview,
        /**
         * Data surrounding a version of this GIF limited to 50kb that displays the first 1-2 seconds of the GIF.
         */
        val preview_gif: Downsized
)
