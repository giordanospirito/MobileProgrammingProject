package com.example.mobileprogrammingproject

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.mobileprogrammingproject.dialogs.ExitGameDialog

class MainMenuActivity : AppCompatActivity() {

    private lateinit var ViewModel : MyViewModel
    lateinit var mediaPlayer : MediaPlayer
    var wantMusic = true
    var gameMode: Int = 0
    var userName : String = ""
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
    var playerscore :Int = 0
    var ActualScore:Int= 0
    var noroll = true
    var arrayDices = mutableListOf<Int>()
    var isFirstDiceClickable = false
    var isSecondDiceClickable = false
    var isThirdDiceClickable = false
    var isFourthDiceClickable = false
    var isFifthDiceClickable = false
    var rollResult = mutableListOf<Int>(0,0,0,0,0)
    var hidden = true
    var numberRoll = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        userName = ViewModel.userName
        gameMode = ViewModel.gameMode
        ScoreP2 = ViewModel.ScoreP2
        ScoreP3 = ViewModel.ScoreP3
        ScoreP4 = ViewModel.ScoreP4
        isPlayButtonActivated = ViewModel.isPlayButtonActivated
        isAcceptButtonActivated = ViewModel.isAcceptButtonActivated
        isScoreButtonActivated = ViewModel.isScoreButtonActivated
        playButtonColor = ViewModel.playButtonColor
        acceptButtonColor = ViewModel.acceptButtonColor
        scoreButtonColor = ViewModel.scoreButtonColor
        combo = ViewModel.combo
        playerscore = ViewModel.scoreView
        ActualScore = ViewModel.actualScore
        arrayDices = ViewModel.arraydices
        noroll = ViewModel.noroll
        isFirstDiceClickable = ViewModel.isFirstDiceClickable
        isSecondDiceClickable = ViewModel.isSecondDiceClickable
        isThirdDiceClickable = ViewModel.isThirdDiceClickable
        isFourthDiceClickable = ViewModel.isFourthDiceClickable
        isFifthDiceClickable = ViewModel.isFifthDiceClickable
        rollResult = ViewModel.rollResult
        hidden = ViewModel.hidden
        numberRoll = ViewModel.numberRoll

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.main_menu)

        //music
        //Toast.makeText(this, wantMusic.toString(), Toast.LENGTH_SHORT).show()
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.isLooping = true
        //end music



    }

    override fun onResume() {
        super.onResume()
        if (wantMusic) {
            mediaPlayer.start()
        }
    }
    override fun onStop() {
        super.onStop()
        if (wantMusic) {
            mediaPlayer.pause()
        }
    }

    override fun onBackPressed() {
        if ( this.findNavController(R.id.fragmentContainerView).currentDestination?.id == R.id.settingsFragment ){
            super.onBackPressed()}
        else {
            val exit = ExitGameDialog()
            exit.show(supportFragmentManager, "exit_dialog_tag")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("savedwantMusic", wantMusic)
        //Toast.makeText(this, wantMusic.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        wantMusic=savedInstanceState.getBoolean("savedwantMusic")
        //Toast.makeText(this, wantMusic.toString(), Toast.LENGTH_SHORT).show()
    }

    fun editUserName(u : String){
        ViewModel.editUserName(u)
        userName=u
    }
    fun editGameMode(g : Int){
        ViewModel.editGameMode(g)
        gameMode=g
    }
    fun editScoreP2(value:Int){
        ViewModel.editScoreP2(value)
        ScoreP2=value
    }
    fun editScoreP3(value:Int){
        ViewModel.editScoreP3(value)
        ScoreP3=value
    }
    fun editScoreP4(value:Int){
        ViewModel.editScoreP4(value)
        ScoreP4=value
    }
    fun editPlayButton(){
        ViewModel.editPlayButton()
        isPlayButtonActivated = !isPlayButtonActivated
    }
    fun editAcceptButton(){
        ViewModel.editAcceptButton()
        isAcceptButtonActivated = !isAcceptButtonActivated
    }
    fun editScoreButton(){
        ViewModel.editScoreButton()
        isScoreButtonActivated = !isScoreButtonActivated
    }
    fun editPlayButtonColor(){
        ViewModel.editPlayButtonColor()
        if(playButtonColor==R.color.giallino){
            playButtonColor=R.color.grey
        }
        else{
            playButtonColor=R.color.giallino
        }
    }
    fun editAcceptButtonColor(){
        ViewModel.editAcceptButtonColor()
        if(acceptButtonColor==R.color.giallino){
            acceptButtonColor=R.color.grey
        }
        else{
            acceptButtonColor=R.color.giallino
        }
    }
    fun editScoreButtonColor(){
        ViewModel.editScoreButtonColor()
        if(scoreButtonColor==R.color.giallino){
            scoreButtonColor=R.color.grey
        }
        else{
            scoreButtonColor=R.color.giallino
        }
    }

    fun editCombo(c: String){
        combo = c
        ViewModel.editCombo(c)
    }
    fun editScore(value: Int){
        playerscore=value
        ViewModel.editScore(value)
    }
    fun editActualScore(valueInt: Int){
        ViewModel.editActualScore(valueInt)
        ActualScore=valueInt
    }
    fun getArrayDices(index:Int,otherIndex:Int,resource:MutableList<Int>){
        arrayDices[index]=resource[otherIndex]
        ViewModel.getArrayDices(index,otherIndex,resource)
    }
    fun ChangeFirstDiceClick(){
        ViewModel.ChangeFirstDiceClick()
    }
    fun ChangeSecondDiceClick(){
        ViewModel.ChangeSecondDiceClick()
    }
    fun ChangeThirdDiceClick(){
        ViewModel.ChangeThirdDiceClick()
    }
    fun ChangeFourthDiceClick(){
        ViewModel.ChangeFourthDiceClick()
    }
    fun ChangeFifthDiceClick(){
        ViewModel.ChangeFifthDiceClick()
    }
    fun getRollResults(otherRolls: MutableList<Int>){
        ViewModel.getRollResults(otherRolls)
    }
    fun editNoroll(b:Boolean){
        noroll = b
        ViewModel.editNoRoll(b)
    }
    fun edithidden(b:Boolean){
        hidden = b
        ViewModel.edithidden(b)
    }
    fun editNumberRoll(){
        ViewModel.editRollNumber()
    }
    fun azzeranumberroll(){
        numberRoll = 0
        ViewModel.azzerarollnumber()
    }
}











