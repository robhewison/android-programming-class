package com.rwhewison.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var names = "No names to display"

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
}