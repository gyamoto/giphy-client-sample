package com.giphy.model.mock

import com.giphy.model.Pagination

object Pagination {

    val mock = Pagination(

            /**
             * Position in pagination.
             * sample: 2591
             */
            offset = 2591,

            /**
             * Total number of items available.
             * sample: 250
             */
            total_count = 250,

            /**
             * Total number of items returned.
             * sample: 25
             */
            count = 25
    )
}
