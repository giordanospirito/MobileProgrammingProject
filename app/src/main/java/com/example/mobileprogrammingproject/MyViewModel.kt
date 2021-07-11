package com.example.mobileprogrammingproject

import android.provider.Settings.Global.getString
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var userName : String = "Guest"
    var gameMode : Int = 0
    var ScoreP2 : Int = 0
    var ScoreP3:Int = 0
    var ScoreP4:Int = 0
    var isPlayButtonActivated:Boolean=true
    var isAcceptButtonActivated:Boolean=false
    var isScoreButtonActivated:Boolean=true
    var playButtonColor = R.color.giallino
    var acceptButtonColor = R.color.grey
    var scoreButtonColor = R.color.grey


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
    fun editPlayButton(){
        isPlayButtonActivated = !isPlayButtonActivated
    }
    fun editAcceptButton(){
        isAcceptButtonActivated = !isAcceptButtonActivated
    }
    fun editScoreButton(){
        isScoreButtonActivated = !isScoreButtonActivated
    }
    fun editPlayButtonColor(){
        if(playButtonColor==R.color.giallino){
            playButtonColor=R.color.grey
        }
        else{
            playButtonColor=R.color.giallino
        }
    }
    fun editAcceptButtonColor(){
        if(acceptButtonColor==R.color.giallino){
            acceptButtonColor=R.color.grey
        }
        else{
            acceptButtonColor=R.color.giallino
        }
    }
    fun editScoreButtonColor(){
        if(scoreButtonColor==R.color.giallino){
            scoreButtonColor=R.color.grey
        }
        else{
            scoreButtonColor=R.color.giallino
        }
    }


}
/// TODO: Salvare isActivated dei pulsanti
/// TODO: Salvare ScoreView, ComboView (values)
/// TODO: Salvare rollresults(anche al click dei dati)
/// TODO: Salvare DicesRow
/// TODO: Salvare scritte dei pulsanti e loro funzionamenti tramite variabile
