package com.gyamoto.api.model

/**
 * The GIF Object is returned from most of the GIPHY API Endpoints and contains a variety of information, including the images object, which contains URLs for GIFs in many different formats and sizes.
 */
data class Gif(

        /**
         * By default, this is almost always gif
         * sample: "gif"
         */
        val type: String,

        /**
         * This GIF's unique ID
         * sample: "YsTs5ltWtEhnq"
         */
        val id: String,

        /**
         * The unique slug used in this GIF's URL
         * sample: "confused-flying-YsTs5ltWtEhnq"
         */
        val slug: String,

        /**
         * The unique URL for this GIF
         * sample: "http://giphy.com/gifs/confused-flying-YsTs5ltWtEhnq"
         */
        val url: String,

        /**
         * The unique bit.ly URL for this GIF
         * sample: "http://gph.is/1gsWDcL"
         */
        val bitly_url: String,

        /**
         * A URL used for embedding this GIF
         * sample: "http://giphy.com/embed/YsTs5ltWtEhnq"
         */
        val embed_url: String,

        /**
         * The username this GIF is attached to, if applicable
         * sample: "JoeCool4000"
         */
        val username: String,

        /**
         * The page on which this GIF was found
         * sample: "http://www.reddit.com/r/reactiongifs/comments/1xpyaa/superman_goes_to_hollywood/"
         */
        val source: String,

        /**
         * The MPAA-style rating for this content. Examples include Y, G, PG, PG-13 and R
         * sample: "g"
         */
        val rating: String,

        /**
         * Currently unused
         */
        val content_url: String,
        /**
         * An object containing data about the user associated with this GIF, if applicable.
         */
        val user: User,
        /**
         * The top level domain of the source URL.
         * sample: "cheezburger.com"
         */
        val source_tld: String,

        /**
         * The URL of the webpage on which this GIF was found.
         * sample: "http://cheezburger.com/5282328320"
         */
        val source_post_url: String,

        /**
         * The date on which this GIF was last updated.
         * sample: "2013-08-01 12:41:48"
         */
        val update_datetime: String,

        /**
         * The date this GIF was added to the GIPHY database.
         * sample: "2013-08-01 12:41:48"
         */
        val create_datetime: String,

        /**
         * The creation or upload date from this GIF's source.
         * sample: "2013-08-01 12:41:48"
         */
        val import_datetime: String,

        /**
         * The date on which this gif was marked trending, if applicable.
         * sample: "2013-08-01 12:41:48"
         */
        val trending_datetime: String,

        /**
         * An object containing data for various available formats and sizes of this GIF.
         */
        val images: Images
)
