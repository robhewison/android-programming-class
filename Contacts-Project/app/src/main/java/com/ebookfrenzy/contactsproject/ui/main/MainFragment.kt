package com.ebookfrenzy.contactsproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.contactsproject.R

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.viewModels
import com.ebookfrenzy.contactsproject.Contact

import java.util.*

import com.ebookfrenzy.contactsproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun listenerSetup() {

        //ADD BUTTON FUNCTIONALITY
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val quantity = binding.personPhoneNum.text.toString()

            if (name != "" && quantity != "") {
                val contact = Contact(name, Integer.parseInt(quantity))
                viewModel.insertContact(contact)
                clearFields()
            } else {
                binding.productID.text = "Incomplete information"
            }
        }

        //FIND BUTTON FUNCTIONALITY
        binding.findButton.setOnClickListener { viewModel.findContact(binding.contactName.text.toString()) }

        //ASC BUTTON FUNCTIONALITY
        binding.ascButton.setOnClickListener {

        }

        //DESC BUTTON FUNCTIONALITY
        binding.descButton.setOnClickListener {

        }

        //TODO: DELETE BUTTON FUNCTIONALITY (TRASH CAN)
        /*
            binding.deleteButton.setOnClickListener {
            viewModel.deleteContact(binding.contactName.text.toString())
            clearFields()
            }
         */

    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(this, Observer { contacts ->
            contacts?.let  {
                adapter?.setProductList(it)
            }
        })

        viewModel.getSearchResults().observe(this, Observer { contacts ->

            contacts?.let {
                if (it.isNotEmpty()) {
                    binding.productID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.contactName.setText(it[0].contactName)
                    binding.personPhoneNum.setText(String.format(Locale.US, "%d",
                        it[0].quantity))
                } else {
                    binding.productID.text = "No Match"
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.product_list_item)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter
    }

    private fun clearFields() {
        binding.productID.text = ""
        binding.contactName.setText("")
        binding.personPhoneNum.setText("")
    }
}