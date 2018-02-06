package com.kyamamoto.kodein.domain.giphy

import com.kyamamoto.giphy.model.mock.Gif

object GiphyMock {

    val mock = Giphy(Gif.mock, false)

    val mockList = Gif.mockList.map { Giphy(it, false) }

}
