package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.content.Intent

// This program allows the user to guess a number
class SecondaryActivity : AppCompatActivity(), View.OnClickListener {
    private var message: TextView? = null
    private var numberGuess: EditText? = null
    private var guess: Button? = null
    private var correctNumber = 0
    private var numberOfTries = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        message = findViewById<View>(R.id.message) as TextView
        numberGuess = findViewById<View>(R.id.numberGuess) as EditText
        guess = findViewById<View>(R.id.guess) as Button
        guess!!.setOnClickListener(this)
        newGame()
    }

    // On click go to guess class
    override fun onClick(view: View) {
        if (view === guess) {
            guess()
        }
    }

    // This class checks if the number is right or wrong
    private fun guess() {
        val n = numberGuess!!.text.toString().toInt()
        // count the number of tries
        numberOfTries++
        // Allows the second activity to display user's name
        var name = intent.getStringExtra("name")
        // Displays text if the guess was correct
        if (n == correctNumber) {
            Toast.makeText(
                this, "Congratulations " + name + ", you guessed the number " + correctNumber +
                        " in " + numberOfTries + " tries!", Toast.LENGTH_SHORT
            ).show()
            newGame()
        }
        // If the guess is wrong it displays that number is too high
        else if (n > correctNumber) {
            message!!.setText("The number is too high")
        }
        // If the guess is wrong it displays that number is too low
        else if (n < correctNumber) {
            message!!.setText("The number is too low")
        }
    }

    // Create a new game
    private fun newGame() {
        correctNumber = RANDOM.nextInt(MAX_NUMBER) + 1
        // Erase text after new game
        numberGuess!!.setText("")
        numberOfTries = 0
    }

    // Set the max number to 25
    companion object {
        const val MAX_NUMBER = 25
        val RANDOM = Random()
    }

    fun goToGame(view: View?) {
        val Intent = Intent(this, SecondaryActivity::class.java)
        startActivity(Intent)
    }

    fun goToPreferences(view: View?) {
        val Intent = Intent(this, PreferencesActivity::class.java)
        startActivity(Intent)
    }

    fun goToHelp(view: View?) {
        val Intent = Intent(this, HelpActivity::class.java)
        startActivity(Intent)
    }
}
