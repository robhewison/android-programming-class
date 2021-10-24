package com.rwhewison.addnamesavedata2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var counter: Int = 0
    var names: MutableLiveData<String> = MutableLiveData("No names to display")

    fun addName(name: String) {
        if (counter == 0) {
            names.value = ""
        }
        var currentNames = names.value
        names.value = currentNames + "\n" + name
        counter++
    }

    fun getNameList(): MutableLiveData<String> {
        return names
    }
}