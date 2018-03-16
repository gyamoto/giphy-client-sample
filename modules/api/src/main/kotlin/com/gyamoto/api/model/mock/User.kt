package com.gyamoto.api.model.mock

import com.gyamoto.api.model.User

object User {

    val mock = User(
            /**
             * The URL for this user's avatar image.
             * sample: "https://media1.giphy.com/avatars/election2016/XwYrZi5H87o6.gif"
             */
            avatar_url = "https://media1.giphy.com/avatars/election2016/XwYrZi5H87o6.gif",

            /**
             * The URL for the banner image that appears atop this user's profile page.
             * sample: "https://media4.giphy.com/avatars/cheezburger/XkuejOhoGLE6.jpg"
             */
            banner_url = "https://media4.giphy.com/avatars/cheezburger/XkuejOhoGLE6.jpg",

            /**
             * The URL for this user's profile.
             * sample: "https://giphy.com/cheezburger/"
             */
            profile_url = "https://giphy.com/cheezburger/",

            /**
             * The username associated with this user.
             * sample: "joecool4000"
             */
            username = "joecool4000",

            /**
             * The display name associated with this user (contains formatting the base username might not).
             * sample: "JoeCool4000"
             */
            display_name = "joecool4000",

            /**
             * The Twitter username associated with this user, if applicable.
             * sample: "@joecool4000"
             */
            twitter = "@joecool4000"
    )
}
