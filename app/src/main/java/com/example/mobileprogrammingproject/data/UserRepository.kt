package com.example.mobileprogrammingproject.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao){

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
    suspend fun setScore(user:User){
        userDao.setScore(user)
    }
    suspend fun setFlag(user:User){
        userDao.setFlag(user)
    }
    suspend fun addCombo(user: User){
        userDao.AddCombo(user)
    }
}