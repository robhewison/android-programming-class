package com.ebookfrenzy.contactsproject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null
    var phoneNumber: Int = 0

    constructor() {}

    constructor(id: Int, contactName: String, phoneNumber: Int) {
        this.contactName = contactName
        this.phoneNumber = phoneNumber
    }
    constructor(contactName: String, phoneNumber: Int) {
        this.contactName = contactName
        this.phoneNumber = phoneNumber
    }
}