package com.rwhewison.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rwhewison.myapplication.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var amount: String? = null
            amount = getCurrentTime()
            binding.textView.text = amount

        }
    }

    private fun getCurrentTime(): String? {
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")

        return current.format(formatter)
    }


}