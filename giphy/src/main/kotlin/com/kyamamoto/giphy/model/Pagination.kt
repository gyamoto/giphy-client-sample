package com.kyamamoto.giphy.model

/**
 * The Pagination Object
 *
 * The Pagination Object contains information relating to the number of total results available as well as the number of results fetched and their relative positions.
 */
data class Pagination(

        /**
         * Position in pagination.
         * sample: 2591
         */
        val offset: Int,

        /**
         * Total number of items available.
         * sample: 250
         */
        val total_count: Int,

        /**
         * Total number of items returned.
         * sample: 25
         */
        val count: Int
)
