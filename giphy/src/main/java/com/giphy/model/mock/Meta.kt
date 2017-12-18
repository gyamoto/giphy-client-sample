package com.giphy.model.mock

import com.giphy.model.Meta

object Meta {

    val mock = Meta(
            /**
             * HTTP Response Message
             * sample: "OK"
             */
            msg = "OK",

            /**
             * HTTP Response Code
             * sample: 200
             */
            status = 200,

            /**
             * A unique ID paired with this response from the API.
             * sample: "57eea03c72381f86e05c35d2"
             */
            response_id = "57eea03c72381f86e05c35d2"
    )
}
