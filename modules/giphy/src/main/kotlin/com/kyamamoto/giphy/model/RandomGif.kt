package com.kyamamoto.giphy.model

/**
 * The Random GIF Object (model document not found)
 */
data class RandomGif(

        /**
         * sample: "gif"
         */
        val type: String,

        /**
         * sample: "Fksw5PGSNOF6E"
         */
        val id: String,

        /**
         * sample: "http://giphy.com/gifs/adventure-time-gif-Fksw5PGSNOF6E"
         */
        val url: String,

        /**
         * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/giphy.gif"
         */
        val image_original_url: String,

        /**
         * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/giphy.gif"
         */
        val image_url: String,

        /**
         * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/giphy.mp4"
         */
        val image_mp4_url: String,

        /**
         * sample: "119"
         */
        val image_frames: String,

        /**
         * sample: "360"
         */
        val image_width: String,

        /**
         * sample: "360"
         */
        val image_height: String,

        /**
         * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/200_d.gif"
         */
        val fixed_height_downsampled_url: String,

        /**
         * sample: "200"
         */
        val fixed_height_downsampled_width: String,

        /**
         * sample: "200"
         */
        val fixed_height_downsampled_height: String,

        /**
         * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/200w_d.gif"
         */
        val fixed_width_downsampled_url: String,

        /**
         * sample: "200"
         */
        val fixed_width_downsampled_width: String,

        /**
         * sample: "200"
         */
        val fixed_width_downsampled_height: String,

        /**
         * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/100.gif"
         */
        val fixed_height_small_url: String,

        /**
         * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/100_s.gif"
         */
        val fixed_height_small_still_url: String,

        /**
         * sample: "100"
         */
        val fixed_height_small_width: String,

        /**
         * sample: "100"
         */
        val fixed_height_small_height: String,

        /**
         * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/100w.gif"
         */
        val fixed_width_small_url: String,

        /**
         * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/100w_s.gif"
         */
        val fixed_width_small_still_url: String,

        /**
         * sample: "100"
         */
        val fixed_width_small_width: String,

        /**
         * sample: "100"
         */
        val fixed_width_small_height: String,

        /**
         * sample: "username"
         */
        val username: String,

        /**
         * sample: "caption"
         */
        val caption: String
)
