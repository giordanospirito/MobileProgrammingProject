package com.example.mobileprogrammingproject

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var userName : String = "Guest"
    fun editUserName(u : String){
        userName=u
    }
}