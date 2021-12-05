package com.rwhewison.recycleview

import android.util.Log

class Data {


    companion object {

        var startUp = 0

        var titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

        var details = arrayOf("Item one details", "Item two details",
            "Item three details", "Item four details",
            "Item five details", "Item six details",
            "Item seven details", "Item eight details")

        var images = arrayOf(R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3,
            R.drawable.android_image_4, R.drawable.android_image_5, R.drawable.android_image_6, R.drawable.android_image_7,
            R.drawable.android_image_8)


        fun getRandomTitle() {
            if(startUp < 3) {
                val list = mutableListOf<String>("Chapter One",
                    "Chapter Two", "Chapter Three", "Chapter Four",
                    "Chapter Five", "Chapter Six", "Chapter Seven",
                    "Chapter Eight")

                list.shuffle()

                titles = list.toTypedArray()
                Log.i("getRandomTitle()", "get random title was called")
                startUp++
            }
        }

        fun getRandomDetails() {

            if(startUp < 3) {
                val list = mutableListOf<String>("Item one details", "Item two details",
                    "Item three details", "Item four details",
                    "Item five details", "Item six details",
                    "Item seven details", "Item eight details")

                list.shuffle()

                details = list.toTypedArray()
                Log.i("getRandomDetails", "get random details was called")
                startUp++
            }

        }

        fun getRandomImages() {

            if(startUp < 3) {
                val list = mutableListOf<Int>(R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3,
                    R.drawable.android_image_4, R.drawable.android_image_5, R.drawable.android_image_6, R.drawable.android_image_7,
                    R.drawable.android_image_8)

                list.shuffle()

                images = list.toTypedArray()
                Log.i("getRandomImages", "get random images was called")
                startUp++
            }
        }
    }


}