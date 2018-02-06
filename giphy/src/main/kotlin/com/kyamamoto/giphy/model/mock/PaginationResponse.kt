package com.kyamamoto.giphy.model.mock

import com.kyamamoto.giphy.model.PaginationResponse

object PaginationResponse {

    val mock = PaginationResponse(
            /**
             * GIF Object
             */
            data = Gif.mockList,
            /**
             * Pagination Object
             */
            meta = Meta.mock,
            /**
             * Meta Object
             */
            pagination = Pagination.mock
    )
}
