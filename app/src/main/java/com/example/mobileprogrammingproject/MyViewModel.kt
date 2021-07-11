package com.example.mobileprogrammingproject

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var userName : String = "Guest"
    var gameMode : Int = 0
    fun editUserName(u : String){
        userName=u
    }
    fun editGameMode(g : Int){
        gameMode=g
    }
}