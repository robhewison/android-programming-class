package com.rwhewison.lifecycleawarenessapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var lifecycleList: MutableLiveData<String> = MutableLiveData()

    fun addCycleName(name: String) {
        var currentNames = lifecycleList.value
        var currentTime = getCurrentTime()
        lifecycleList.value = currentNames + "\n" + name + "was fired on" + currentTime
    }

    private fun getCurrentTime(): String? {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        return current.format(formatter)
    }

    fun getLifeCycleList(): MutableLiveData<String> {
        return lifecycleList
    }


}