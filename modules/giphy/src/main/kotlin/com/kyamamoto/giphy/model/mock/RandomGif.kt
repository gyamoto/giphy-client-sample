package com.kyamamoto.giphy.model.mock

import com.kyamamoto.giphy.model.RandomGif

object RandomGif {

    val mock = RandomGif(
            /**
             * sample: "gif"
             */
            type = "gif",

            /**
             * sample: "Fksw5PGSNOF6E"
             */
            id = "Fksw5PGSNOF6E",

            /**
             * sample: "http://giphy.com/gifs/adventure-time-gif-Fksw5PGSNOF6E"
             */
            url = "http://giphy.com/gifs/adventure-time-gif-Fksw5PGSNOF6E",

            /**
             * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/giphy.gif"
             */
            image_original_url = "https://media2.giphy.com/media/Fksw5PGSNOF6E/giphy.gif",

            /**
             * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/giphy.gif"
             */
            image_url = "https://media2.giphy.com/media/Fksw5PGSNOF6E/giphy.gif",

            /**
             * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/giphy.mp4"
             */
            image_mp4_url = "https://media2.giphy.com/media/Fksw5PGSNOF6E/giphy.mp4",

            /**
             * sample: "119"
             */
            image_frames = "119",

            /**
             * sample: "360"
             */
            image_width = "360",

            /**
             * sample: "360"
             */
            image_height = "360",

            /**
             * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/200_d.gif"
             */
            fixed_height_downsampled_url = "https://media2.giphy.com/media/Fksw5PGSNOF6E/200_d.gif",

            /**
             * sample: "200"
             */
            fixed_height_downsampled_width = "200",

            /**
             * sample: "200"
             */
            fixed_height_downsampled_height = "200",

            /**
             * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/200w_d.gif"
             */
            fixed_width_downsampled_url = "https://media2.giphy.com/media/Fksw5PGSNOF6E/200w_d.gif",

            /**
             * sample: "200"
             */
            fixed_width_downsampled_width = "200",

            /**
             * sample: "200"
             */
            fixed_width_downsampled_height = "200",

            /**
             * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/100.gif"
             */
            fixed_height_small_url = "https://media2.giphy.com/media/Fksw5PGSNOF6E/100.gif",

            /**
             * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/100_s.gif"
             */
            fixed_height_small_still_url = "https://media2.giphy.com/media/Fksw5PGSNOF6E/100_s.gif",

            /**
             * sample: "100"
             */
            fixed_height_small_width = "100",

            /**
             * sample: "100"
             */
            fixed_height_small_height = "100",

            /**
             * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/100w.gif"
             */
            fixed_width_small_url = "https://media2.giphy.com/media/Fksw5PGSNOF6E/100w.gif",

            /**
             * sample: "https://media2.giphy.com/media/Fksw5PGSNOF6E/100w_s.gif"
             */
            fixed_width_small_still_url = "https://media2.giphy.com/media/Fksw5PGSNOF6E/100w_s.gif",

            /**
             * sample: "100"
             */
            fixed_width_small_width = "100",

            /**
             * sample: "100"
             */
            fixed_width_small_height = "100",

            /**
             * sample: "username"
             */
            username = "username",

            /**
             * sample: "caption"
             */
            caption = "caption")

    val mockList = listOf(mock, mock, mock, mock, mock)
            .mapIndexed { index, gif -> gif.copy(id = index.toString()) }
}
