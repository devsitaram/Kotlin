package com.sitaram.bookshare.features.database

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], exportSchema = false, version = 1)
abstract class DatabaseHelper: RoomDatabase() {

    // initialize the final variable
    private var DB_NAME: String? = "BookDatabase"
    private var instance: DatabaseHelper? = null
    @Synchronized
    fun getInstance(context: Context): DatabaseHelper {
        if (instance == null) {
            // call the get Instance from room database
            instance = Room.databaseBuilder(context, DatabaseHelper::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
        // return the instance
        return instance!!
    }

    // create the abstract methods
    abstract fun userDao(): UserDao
}