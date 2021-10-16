package com.rwhewison.addnamesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rwhewison.addnamesavedata.databinding.MainActivityBinding
import com.rwhewison.addnamesavedata.ui.main.MainFragment

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