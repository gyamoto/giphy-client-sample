package com.giphy.model.mock

import com.giphy.model.RandomResponse

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
