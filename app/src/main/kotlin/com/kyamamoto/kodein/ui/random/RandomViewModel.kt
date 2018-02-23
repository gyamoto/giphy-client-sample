package com.kyamamoto.kodein.ui.random

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.kyamamoto.giphy.ApiBuilder
import com.kyamamoto.giphy.model.RandomResponse
import com.kyamamoto.kodein.architecturecomponent.Resource
import com.kyamamoto.persistentrandom.RamdomResponseStore

/**
 * Created by kyamamoto on 2018/02/05.
 */
class RandomViewModel(context: Application) : AndroidViewModel(context) {

    private val liveData: RandomLiveData by lazy {
        RandomLiveData(ApiBuilder.build(), RamdomResponseStore(context))
    }

    val random: LiveData<Resource<RandomResponse>> = Transformations.map(liveData, { it })

    fun updateGif() {
        liveData.request()
    }

}
