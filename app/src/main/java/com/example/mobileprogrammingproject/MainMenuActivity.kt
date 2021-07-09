package com.example.mobileprogrammingproject

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.mobileprogrammingproject.dialogs.ExitGameDialog

class MainMenuActivity : AppCompatActivity() {

    lateinit var mediaPlayer : MediaPlayer
    var wantMusic = true
    var gameMode: Int = 0
    var userName : String = "Guest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        //music
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