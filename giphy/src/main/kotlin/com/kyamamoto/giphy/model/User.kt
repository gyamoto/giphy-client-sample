package com.kyamamoto.giphy.model

/**
 * The User Object contains information about the user associated with a GIF and URLs to assets such as that user's avatar image, profile, and more.
 */
data class User(

        /**
         * The URL for this user's avatar image.
         * sample: "https://media1.giphy.com/avatars/election2016/XwYrZi5H87o6.gif"
         */
        val avatar_url: String,

        /**
         * The URL for the banner image that appears atop this user's profile page.
         * sample: "https://media4.giphy.com/avatars/cheezburger/XkuejOhoGLE6.jpg"
         */
        val banner_url: String,

        /**
         * The URL for this user's profile.
         * sample: "https://giphy.com/cheezburger/"
         */
        val profile_url: String,

        /**
         * The username associated with this user.
         * sample: "joecool4000"
         */
        val username: String,

        /**
         * The display name associated with this user (contains formatting the base username might not).
         * sample: "JoeCool4000"
         */
        val display_name: String,

        /**
         * The Twitter username associated with this user, if applicable.
         * sample: "@joecool4000"
         */
        val twitter: String
)
