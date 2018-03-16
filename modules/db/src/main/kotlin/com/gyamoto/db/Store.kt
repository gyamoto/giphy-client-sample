package com.gyamoto.db

/**
 * 値を保持するStoreのインターフェース
 */
interface Store<T> {

    /**
     * 保持した値の取得、もしくは保持する値を設定
     */
    var item: T?

    /**
     * 保持した値を破棄する
     */
    fun clear() {
        item = null
    }
}
