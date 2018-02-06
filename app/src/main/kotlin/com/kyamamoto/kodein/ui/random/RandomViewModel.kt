package com.kyamamoto.kodein.ui.random

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.kyamamoto.giphy.model.RandomResponse
import com.kyamamoto.kodein.architecturecomponent.Resource

/**
 * Created by kyamamoto on 2018/02/05.
 */
class RandomViewModel : ViewModel() {

    private val liveData: RandomLiveData by lazy { RandomLiveData() }

    val random: LiveData<Resource<RandomResponse>> = Transformations.map(liveData, { it })

    fun updateGif() {
        liveData.request()
    }

}
