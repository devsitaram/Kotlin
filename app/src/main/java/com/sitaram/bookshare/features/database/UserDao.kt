package com.sitaram.bookshare.features.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable

@SuppressWarnings("AndroidUnresolvedRoomSqlReference")
@Dao
interface UserDao {
    // insert the user data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userList: List<UserEntity?>?): Completable?

    // this method can get the username and password
    @Query("SELECT EXISTS(SELECT * FROM user WHERE user_name =:username AND user_password =:userPassword)")
    fun loginDetails(username: String?, userPassword: String?): Boolean
}