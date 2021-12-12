package com.ebookfrenzy.contactsproject.ui.main

import android.app.AlertDialog
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.widget.Toast


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

        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val phoneNumString = binding.personPhoneNum.text.toString()

            if (name != "" && phoneNumString != "") {
                val phoneNum = phoneNumString.toLong()
                val contact = Contact(name, phoneNum) //Integer.parseInt(phoneNum)
                viewModel.insertContact(contact)
                clearFields()
            } else {
               Toast.makeText(this.context, "ENTER NAME AND PHONE NUMBER", Toast.LENGTH_SHORT).show()
            }
        }

        //TODO: FIND BUTTON FUNCTIONALITY
        binding.findButton.setOnClickListener {
            viewModel.findContact(binding.contactName.text.toString())

        }

        //TODO: ASC BUTTON FUNCTIONALITY
        binding.ascButton.setOnClickListener {
            //TODO: display contacts in ascending order
            viewModel.getAscContacts()
        }

        //TODO: DESC BUTTON FUNCTIONALITY
        binding.descButton.setOnClickListener {
            //TODO: display contacts in descending order
            viewModel.getDescContacts()
        }

        //TODO: DELETE BUTTON FUNCTIONALITY (TRASH CAN... DO THIS LAST)
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
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(this, Observer { contacts ->

            contacts?.let {
                if (it.isNotEmpty()) {

                } else {

                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter
    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.personPhoneNum.setText("")
    }
}