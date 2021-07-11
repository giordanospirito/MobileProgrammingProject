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
    var acceptButtonColor = R.color.giallino
    var scoreButtonColor = R.color.grey
    var combo = ""
    var playerscore :Int = 0
    var ActualScore:Int= 0
    var arrayDices = mutableListOf<Int>()



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
}











//TODO back button 1st press only dialog, then close app
//TODO back button default dialog (alert)
//TODO main "custom" dialog (cancel, submit, etc ...)
//TODO passing events to dialog's host
//TODO main xml graphic
//TODO hide sysUI
//TODO fullscreen
//TODO antialias edges of dialogs and buttons
//TODO create landscape variant
//TODO delete and modify gradle files
//TODO translating the app in "italian" and "english"
//TODO scroll view
//TODO check the version
//TODO daynight theme
//TODO check manifest for important lines (like app icon, app name, etc ...)
//TODO use a good theme and set a nice color pallet
//TODO create a splash screen
//TODO action bar color
//TODO animations (also in splash screen)
//TODO change app icon background color
//todo apertura scattosa (risolto dalle prestazioni del telefono)
//todo fare le cose di gradle che dice il prof, tipo cancellare alcuni file, e aggiungere i pacchetti necessari
//todo rimuovere i warning dai file gradle
//todo icona rotonda e quadrata
//todo pensare a rifinire i bottoni, cambiare i colori, pensare se usare un custom layout, fare una bozza delle schermate
//todo scoreboard
//todo sql lite
//todo aggiungere suoni di roll e soundtrack dell'app
//todo schermata regole ad immagine
//todo selezionare numero di giocatori, username
//todo schermata play/history/scoreboard
//todo fare le animazioni belle con il navigation.xml
//todo da ripulire i file xml, alcuni hanno troppi layout uno dentro l'altro
//todo da capire bene se ha senso mettere le freccie all'indietro di transizione nel navigation graph, tanto basta fare back button in teoria..
//todo i dadi escono dallo schermo
//todo modifa colore button quando cliccato
//todo tieni premuto per lancio truccato
//todo vibrazione alla pressione
//todo lo spostamento tra activity le killa
//todo animazione roll singoli accavallati
//todo check che si ricordano tutto
//todo roll diventa grigio e accept non cliccabile e grigio
//todo girare il cel resetta la muisica
//todo fai un roll , non accetti, vai a results frag, torni e il roll è andato perso e vai avanti anche di un roll
//todo fare lo yahtzee piu di una volta e altri punteggi simili
//todo riguarda le regole


/* cosa è stato fatto fin'ora
*****UPDATE***** creato un tasto "RULES" che apre un dialog per mostrare sinteticamente le regole del gioco
* modificata l'icona dell'app
* aggiunto un folder icon con tutte le dimensioni all'interno
* creato un drawable splash_screen
* creato un tema dedicato alla splashscreen
* modificato il manifest aggiungendo una nuova activity e mettendola come launchactivity e settando il suo theme
* modificato il nuovo file activity.kt della splash screen usando un'intent
*
* workflow
* splash screen--> main menu--> ...
*
* */