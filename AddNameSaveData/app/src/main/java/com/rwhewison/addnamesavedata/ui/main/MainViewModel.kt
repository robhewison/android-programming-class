package com.rwhewison.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var names = ""

    fun addNames(name: String) {
        names = names + "\n" + name
    }

    fun addName(name: String) {
        names = names + "\n" + name
    }
}