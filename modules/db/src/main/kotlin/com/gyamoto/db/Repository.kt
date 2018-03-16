package com.gyamoto.db

import android.arch.lifecycle.LiveData

class Repository<T>(private val store: Store<T>) : LiveData<T>() {

    fun update(item: T) {
        store.item = item
        value = store.item
    }

    fun clear() {
        store.clear()
        value = store.item
    }

    override fun onActive() {
        value = store.item
    }

}
