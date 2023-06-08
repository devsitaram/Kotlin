package com.sitaram.bookshare.features.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity {

    // initialize the variable
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var id: Int

    @ColumnInfo(name = "user_email")
    var userEmail: String

    @ColumnInfo(name = "user_name")
    var nameName: String

    @ColumnInfo(name = "user_password")
    var userPassword: String

    // create the secondary constructor
    constructor(id: Int, userEmail: String, nameName: String, userPassword: String) {
        this.id = id
        this.userEmail = userEmail
        this.nameName = nameName
        this.userPassword = userPassword
    }
}