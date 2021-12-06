package com.ebookfrenzy.contactsproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.contactsproject.Contact
import com.ebookfrenzy.contactsproject.R

class ContactListAdapter(private val contactItemLayout: Int) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    companion object {
        private var contactList: List<Contact>? = null
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val item = holder.item
        val item2 = holder.item2
        contactList.let {
            item.text = it!![listPosition].contactName
        }
        contactList.let {
            item2.text = it!![listPosition].phoneNumber.toString()
        }
    }

    //replaced contactItemLayout with R.layout.card_layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView = itemView.findViewById(R.id.contactNameCard)
        var item2: TextView = itemView.findViewById(R.id.contactPhoneNumber)
    }
}