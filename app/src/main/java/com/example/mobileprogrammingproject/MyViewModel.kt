package com.example.mobileprogrammingproject

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var userName : String = "Guest"
    var gameMode : Int = 0
    var ScoreP2 : Int = 0
    var ScoreP3:Int = 0
    var ScoreP4:Int = 0
    fun editUserName(u : String){
        userName=u
    }
    fun editGameMode(g : Int){
        gameMode=g
    }
    fun editScoreP2(value:Int){
        ScoreP2=value
    }
    fun editScoreP3(value:Int){
        ScoreP3=value
    }
    fun editScoreP4(value:Int){
        ScoreP4=value
    }


}
/// TODO: Salvare isActivated dei pulsanti
/// TODO: Salvare ScoreView, ComboView (values)
/// TODO: Salvare rollresults(anche al click dei dati)
/// TODO: Salvare DicesRow
/// TODO: Salvare scritte dei pulsanti e loro funzionamenti tramite variabile
