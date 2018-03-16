package com.gyamoto.giphy.ui.random

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.gyamoto.api.ApiBuilder
import com.gyamoto.api.model.RandomResponse
import com.gyamoto.giphy.architecturecomponent.Resource
import com.gyamoto.db.RamdomResponseStore

class RandomViewModel(context: Application) : AndroidViewModel(context) {

    private val liveData: RandomLiveData by lazy {
        RandomLiveData(ApiBuilder.build(), RamdomResponseStore(context))
    }

    val random: LiveData<Resource<RandomResponse>> = Transformations.map(liveData, { it })

    fun updateGif() {
        liveData.request()
    }

}
