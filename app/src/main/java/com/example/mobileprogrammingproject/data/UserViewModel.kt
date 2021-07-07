package com.example.mobileprogrammingproject.data

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
            }
    }
    fun setScore(user:User){
        viewModelScope.launch(Dispatchers.IO){
            repository.setScore(user)
            }
    }
    fun setFlag(user:User){
        viewModelScope.launch(Dispatchers.IO){
            repository.setFlag(user)
        }
    }
    fun AddCombo(user: User,s:String){
        viewModelScope.launch(Dispatchers.IO){
            repository.addCombo(user,s)
        }
    }

}//un bel problemone