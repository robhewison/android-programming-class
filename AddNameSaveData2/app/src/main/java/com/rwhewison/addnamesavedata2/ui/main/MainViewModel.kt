package com.rwhewison.addnamesavedata2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    //var names = "No names to display"
    var names: MutableLiveData<String> = MutableLiveData()

    /*
    fun addNames(name: String) {
        names = names + "\n" + name
    }

    fun addName(name: String) {
        if(names == "No names to display") {
            names = ""
        }
        names = names + "\n" + name
        //add functionality if there are no names included
    }
     */

    fun addName(name: String) {
        var currentNames = names.value
        names.value = currentNames + "\n" + name
    }

    fun getNameList(): MutableLiveData<String> {
        return names
    }
}