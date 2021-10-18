package com.rwhewison.addnamesavedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rwhewison.addnamesavedata.R
import com.rwhewison.addnamesavedata.databinding.MainFragmentBinding

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

        var name: String? = null

        binding.button.setOnClickListener() {
            if(binding.nameEnterField.text.isBlank()) {
                binding.displayNames.text = "No names to display"
            } else {
                name = binding.nameEnterField.text.toString()
                viewModel.addName(name!!)
            }
            binding.displayNames.text = viewModel.names.toString()
        }
        return binding.root

        //return inflater.inflate(R.layout.main_fragment, container, false) //default value
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.displayNames.text = viewModel.names.toString()
    }

}