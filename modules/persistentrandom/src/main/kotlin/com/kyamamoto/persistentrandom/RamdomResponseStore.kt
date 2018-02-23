package com.kyamamoto.persistentrandom

import android.content.Context
import com.kyamamoto.giphy.model.RandomResponse
import com.kyamamoto.persistentrandom.model.OrmaDatabase
import com.kyamamoto.persistentrandom.model.Random

/**
 * Created by kyamamoto on 2018/02/07.
 */
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
