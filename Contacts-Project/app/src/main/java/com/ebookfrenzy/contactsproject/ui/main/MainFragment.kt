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

        //TODO: ADD BUTTON FUNCTIONALITY
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val phoneNumString = binding.personPhoneNum.text.toString()
            val phoneNum = Integer.parseInt(phoneNumString)

            if (name != "" && phoneNumString != "") {
                val contact = Contact(name, phoneNum) //Integer.parseInt(phoneNum)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                //TODO: Notify user somehow that the name or phone number were empty
            }
        }

        //TODO: FIND BUTTON FUNCTIONALITY
        binding.findButton.setOnClickListener {
            viewModel.findContact(binding.contactName.text.toString())


            //TODO: find contactName and phoneNumber to put in cardView recyclerview
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