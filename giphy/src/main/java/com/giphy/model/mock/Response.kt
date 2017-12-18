package com.giphy.model.mock

import com.giphy.model.Response

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
