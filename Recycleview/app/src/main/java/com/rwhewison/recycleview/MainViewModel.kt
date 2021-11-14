package com.rwhewison.recycleview

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //Used to save current state of app when screen is rotated
    companion object {
        var titlesArray = arrayOf<String>()
        var detailsArray = arrayOf<String>()
        var imagesArray = arrayOf<Int>()
    }

    fun addTitles(theArray: Array<String>) {
        titlesArray = theArray
    }

    fun addDetails(theArray: Array<String>) {
        detailsArray = theArray
    }

    fun addImages(theArray: Array<Int>) {
        imagesArray = theArray
    }




}