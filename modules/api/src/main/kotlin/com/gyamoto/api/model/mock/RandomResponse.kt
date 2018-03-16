package com.gyamoto.api.model.mock

import com.gyamoto.api.model.RandomResponse

object RandomResponse {

    val mock = RandomResponse(

            /**
             * GIF Object
             */
            data = RandomGif.mock,
            /**
             * Pagination Object
             */
            meta = Meta.mock
    )
}
