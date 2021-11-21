package com.rwhewison.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import com.rwhewison.recycleview.databinding.ActivityMain2Bindinggi

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //val extras = intent.extras ?: return
        //val qString = extras.getString("qString")
        //binding.textView.text = qString

        val extras = intent.extras ?: return

        val myTitle = extras.getString("myTitle")
        val myDetail = extras.getString("myDetail")
        val myImage = extras.getInt("myImage")

        binding.textView.text = myTitle
        binding.textView2.text = myDetail
        binding.imageView.setImageResource(myImage)

    }
}