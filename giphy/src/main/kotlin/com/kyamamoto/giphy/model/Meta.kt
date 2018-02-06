package com.kyamamoto.giphy.model

/**
 * The Meta Object
 *
 * The Meta Object contains basic information regarding the request, whether it was successful, and the response given by the API.
 */
data class Meta(

        /**
         * HTTP Response Message
         * sample: "OK"
         */
        val msg: String,

        /**
         * HTTP Response Code
         * sample: 200
         */
        val status: Int,

        /**
         * A unique ID paired with this response from the API.
         * sample: "57eea03c72381f86e05c35d2"
         */
        val response_id: String? = null
)
