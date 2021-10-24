package com.rwhewison.addnamesavedata2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.databinding.DataBindingUtil
import com.rwhewison.addnamesavedata2.R
import com.rwhewison.addnamesavedata2.databinding.MainFragmentBinding
import com.rwhewison.addnamesavedata2.BR.myViewModel
import com.rwhewison.addnamesavedata2.databinding.MainActivityBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this)


        var name: String? = null

        binding.button.setOnClickListener() {
            if(binding.nameEnterField.text.isBlank()) {
                binding.displayNames.text = "No names to display"
            } else {
                name = binding.nameEnterField.text.toString()
                viewModel.addName(name!!)
            }
        }
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.setVariable(myViewModel, viewModel)

        val resultObserver = Observer<String> {
            names -> binding.displayNames.text = names.toString()
        }

        viewModel.getNameList().observe(viewLifecycleOwner, resultObserver)
    }

}