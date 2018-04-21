package com.gyamoto.giphy.ui.random

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.gyamoto.api.ApiBuilder
import com.gyamoto.api.model.RandomResponse
import com.gyamoto.db.RamdomResponseStore
import com.gyamoto.giphy.architecturecomponent.Resource

class RandomViewModel(context: Application) : AndroidViewModel(context) {

    private val liveData: RandomLiveData by lazy {
        RandomLiveData(ApiBuilder.build(), RamdomResponseStore(context))
    }

    val random: LiveData<Resource<RandomResponse>> = liveData

    val imageUrl: LiveData<String> = Transformations.map(random) {
        it?.response?.data?.fixed_width_downsampled_url
    }

    val isProgress: LiveData<Boolean> = Transformations.map(random) {
        it?.status == Resource.Companion.Status.Progress
    }

    fun updateGif() {
        liveData.request()
    }

}
