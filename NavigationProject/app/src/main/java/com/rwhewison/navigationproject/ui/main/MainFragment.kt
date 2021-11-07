package com.rwhewison.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.rwhewison.navigationproject.R
import com.rwhewison.navigationproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
        //return inflater.inflate(R.layout.main_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button.setOnClickListener() {

            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond(R.drawable.android_image_1)
            action.message = "Image 1"
            action.imagePass = R.drawable.android_image_1
            Navigation.findNavController(it).navigate(action)
        }

        binding.button2.setOnClickListener() {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond(R.drawable.android_image_2)
            action.message = "Image 2"
            action.imagePass = R.drawable.android_image_2
            Navigation.findNavController(it).navigate(action)
        }

        binding.button3.setOnClickListener() {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond(R.drawable.android_image_3)
            action.message = "Image 3"
            action.imagePass = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action)
        }

        // TODO: Use the ViewModel
    }

}