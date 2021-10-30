package com.rwhewison.lifecycleawarenessapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var lifecycleList: MutableLiveData<String> = MutableLiveData()

    fun addCycleName(name: String) {
        var currentNames = lifecycleList.value
        lifecycleList.value = currentNames + "\n" + name
    }

    fun getLifeCycleList(): MutableLiveData<String> {
        return lifecycleList
    }


}