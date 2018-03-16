package com.gyamoto.giphy.domain.giphy

import com.gyamoto.api.model.Gif

/**
 * @param gif [Gif]
 * @param favorite お気に入り追加されたか否か
 */
data class Giphy(
        val gif: Gif,
        val favorite: Boolean
)
