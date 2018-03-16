package com.gyamoto.db

import android.content.Context
import com.gyamoto.db.model.OrmaDatabase
import com.gyamoto.db.model.Random
import com.gyamoto.api.model.RandomResponse

class RamdomResponseStore(context: Context) : Store<RandomResponse> {

    private val orma = OrmaDatabase.builder(context)
            .name("persistent.random.db")
            .build()

    override var item: RandomResponse?
        get() {
            return orma.selectFromRandom().getOrNull(0)?.toRandomResponse()
        }
        set(value) {
            value?.let {
                orma.deleteAll()

                val random = Random(it)
                orma.insertIntoGif(random.data)
                orma.insertIntoMeta(random.meta)
                orma.insertIntoRandom(random)
            }
        }

}
