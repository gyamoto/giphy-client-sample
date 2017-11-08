package com.giphy.model

/**
 * Successful Response(200 OK)
 */
data class PaginationResponse(
        /**
         * GIF Object
         */
        val data: Gif,
        /**
         * Pagination Object
         */
        val meta: Meta,
        /**
         * Meta Object
         */
        val pagination: Pagination
)