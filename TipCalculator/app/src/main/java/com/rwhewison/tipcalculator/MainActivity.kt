package com.rwhewison.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rwhewison.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipBtn.setOnClickListener {
            binding.output.text = outputString(binding.billAmount.toString().toDouble())
        }
    }

    fun tenPercentTip(bill: Double): Double {
        val tip = bill * 0.10
        return bill + tip
    }

    fun fifteenPercentTip(bill: Double): Double {
        val tip = bill * 0.15
        return bill + tip
    }

    fun twentyPercentTip(bill: Double): Double {
        val tip = bill * 0.20
        return bill + tip
    }

    fun outputString(bill: Double): String {
        if (bill != null) {
            var ten = tenPercentTip(bill)
            var fifteen = fifteenPercentTip(bill)
            var twenty = twentyPercentTip(bill)
            return "The tips are as follows:\n\n 10% = $ten\n 15% = $fifteen\n 20% = $twenty"
        } else {
            return "YOU MUST ENTER A BILL AMOUNT"
        }
    }
}