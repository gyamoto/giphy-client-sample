package com.kyamamoto.giphy.model.mock

import com.kyamamoto.giphy.model.Response

object Response {

    val mock = Response(

            /**
             * GIF Object
             */
            data = Gif.mock,
            /**
             * Pagination Object
             */
            meta = Meta.mock
    )
}
