package com.kyamamoto.kodein.domain.giphy

import com.giphy.model.Gif

/**
 * @param gif [Gif]
 * @param favorite お気に入り追加されたか否か
 */
data class Giphy(
        val gif: Gif,
        val favorite: Boolean
)
