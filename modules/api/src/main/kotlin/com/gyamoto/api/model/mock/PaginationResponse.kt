package com.gyamoto.api.model.mock

import com.gyamoto.api.model.PaginationResponse

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
