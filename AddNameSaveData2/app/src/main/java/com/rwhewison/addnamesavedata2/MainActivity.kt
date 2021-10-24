package com.rwhewison.addnamesavedata2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rwhewison.addnamesavedata2.databinding.MainActivityBinding
import com.rwhewison.addnamesavedata2.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}