package com.example.mobileprogrammingproject

import android.provider.Settings.Global.getString
import android.widget.ImageView
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
    var scoreButtonColor = R.color.giallino
    var combo = ""
    var scoreView :Int = 0
    var actualScore:Int= 0
    var arraydices = mutableListOf<Int>(0,0,0,0,0)
    var noroll = true
    var isFirstDiceClickable = false
    var isSecondDiceClickable = false
    var isThirdDiceClickable = false
    var isFourthDiceClickable = false
    var isFifthDiceClickable = false
    var rollResult = mutableListOf<Int>(0,0,0,0,0)
    var hidden = true
    var numberRoll : Int= 0

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
    fun editScore(value: Int){
        scoreView=value
    }
    fun editActualScore(valueInt: Int){
        actualScore=valueInt
    }
    fun getArrayDices(index:Int, otherindex:Int,list : MutableList<Int>){
        arraydices[index]=list[otherindex]
    }
    fun editCombo(c: String){
        combo = c
    }
    fun editNoRoll(b:Boolean){
        noroll=b
    }
    fun ChangeFirstDiceClick(){
        isFirstDiceClickable = !isFirstDiceClickable
    }
    fun ChangeSecondDiceClick(){
        isSecondDiceClickable = !isSecondDiceClickable
    }
    fun ChangeThirdDiceClick(){
        isThirdDiceClickable = !isThirdDiceClickable
    }
    fun ChangeFourthDiceClick(){
        isFourthDiceClickable = !isFourthDiceClickable
    }
    fun ChangeFifthDiceClick(){
        isFifthDiceClickable = !isFifthDiceClickable
    }
    fun getRollResults(otherRolls: MutableList<Int>){
        rollResult = otherRolls
    }
    fun edithidden(b:Boolean){
        hidden=b
    }
    fun editRollNumber(){
        numberRoll++
    }
    fun azzerarollnumber(){
        numberRoll=0
    }

}

/// TODO: Salvare scritte dei pulsanti
