package com.ebookfrenzy.contactsproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact)

    //Gets contact of a specific name
    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%'")
    fun findContact(name: String): LiveData<List<Contact>>

    //Deletes contact of a specific Id value
    @Query("DELETE FROM contacts WHERE contactId = :id")
    fun deleteContact(id: Int)

    //Gets all contacts
    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>

    //Gets contacts and orders in ascending over
    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun getAscContacts(): LiveData<List<Contact>>

    //Gets contacts and orders in descending over
    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun getDescContacts(): LiveData<List<Contact>>
}