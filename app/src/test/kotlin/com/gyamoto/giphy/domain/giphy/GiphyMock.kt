package com.gyamoto.giphy.domain.giphy

import com.gyamoto.api.model.mock.Gif

object GiphyMock {

    val mock = Giphy(Gif.mock, false)

    val mockList = Gif.mockList.map { Giphy(it, false) }

}
