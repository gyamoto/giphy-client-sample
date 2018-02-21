package com.kyamamoto.giphy.model

/**
 * Successful Response(200 OK)
 */
data class RandomResponse(
        /**
         * GIF Object
         */
        val data: RandomGif,
        /**
         * Pagination Object
         */
        val meta: Meta
)
