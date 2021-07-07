package com.example.mobileprogrammingproject.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Update
    suspend fun setScore(user:User)

    @Update
    suspend fun setFlag(user: User)

    @Update
    suspend fun AddCombo(user:User)

}