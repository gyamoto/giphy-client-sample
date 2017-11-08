package com.giphy.model

/**
 * Successful Response(200 OK)
 */
data class Response(
        /**
         * GIF Object
         */
        val data: Gif,
        /**
         * Pagination Object
         */
        val meta: Meta
)
