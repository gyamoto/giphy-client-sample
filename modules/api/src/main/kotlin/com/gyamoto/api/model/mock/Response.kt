package com.gyamoto.api.model.mock

import com.gyamoto.api.model.Response

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
