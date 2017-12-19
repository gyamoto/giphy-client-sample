package com.giphy.model.mock

import com.giphy.model.Gif

object Gif {

    val mock = Gif(
            /**
             * By default, this is almost always gif
             * sample: "gif"
             */
            type = "gif",

            /**
             * This GIF's unique ID
             * sample: "YsTs5ltWtEhnq"
             */
            id = "YsTs5ltWtEhnq",

            /**
             * The unique slug used in this GIF's URL
             * sample: "confused-flying-YsTs5ltWtEhnq"
             */
            slug = "confused-flying-YsTs5ltWtEhnq",

            /**
             * The unique URL for this GIF
             * sample: "http://giphy.com/gifs/confused-flying-YsTs5ltWtEhnq"
             */
            url = "http://giphy.com/gifs/confused-flying-YsTs5ltWtEhnq",

            /**
             * The unique bit.ly URL for this GIF
             * sample: "http://gph.is/1gsWDcL"
             */
            bitly_url = "http://gph.is/1gsWDcL",

            /**
             * A URL used for embedding this GIF
             * sample: "http://giphy.com/embed/YsTs5ltWtEhnq"
             */
            embed_url = "http://giphy.com/embed/YsTs5ltWtEhnq",

            /**
             * The username this GIF is attached to, if applicable
             * sample: "JoeCool4000"
             */
            username = "JoeCool4000",

            /**
             * The page on which this GIF was found
             * sample: "http://www.reddit.com/r/reactiongifs/comments/1xpyaa/superman_goes_to_hollywood/"
             */
            source = "http://www.reddit.com/r/reactiongifs/comments/1xpyaa/superman_goes_to_hollywood/",

            /**
             * The MPAA-style rating for this content. Examples include Y, G, PG, PG-13 and R
             * sample: "g"
             */
            rating = "g",

            /**
             * Currently unused
             */
            content_url = "content_url",
            /**
             * An object containing data about the user associated with this GIF, if applicable.
             */
            user = User.mock,
            /**
             * The top level domain of the source URL.
             * sample: "cheezburger.com"
             */
            source_tld = "cheezburger.com",

            /**
             * The URL of the webpage on which this GIF was found.
             * sample: "http://cheezburger.com/5282328320"
             */
            source_post_url = "http://cheezburger.com/5282328320",

            /**
             * The date on which this GIF was last updated.
             * sample: "2013-08-01 12:41:48"
             */
            update_datetime = "2013-08-01 12:41:48",

            /**
             * The date this GIF was added to the GIPHY database.
             * sample: "2013-08-01 12:41:48"
             */
            create_datetime = "2013-08-01 12:41:48",

            /**
             * The creation or upload date from this GIF's source.
             * sample: "2013-08-01 12:41:48"
             */
            import_datetime = "2013-08-01 12:41:48",

            /**
             * The date on which this gif was marked trending, if applicable.
             * sample: "2013-08-01 12:41:48"
             */
            trending_datetime = "2013-08-01 12:41:48",

            /**
             * An object containing data for various available formats and sizes of this GIF.
             */
            images = Images.mock
    )

    val mockList = listOf(mock, mock, mock, mock, mock)
            .mapIndexed { index, gif -> gif.copy(id = index.toString()) }
}
