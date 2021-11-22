package com.example.numberguessinggame

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


import android.widget.EditText




// This program allows the user to enter a name for the game
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    // Allows the user to go to the second activity
    fun sendMessage(view: View?) {
        val Intent = Intent(this, SecondaryActivity::class.java)
        // Allows the second activity to display user's name
        Intent.putExtra("name", editName.text.toString())
        startActivity(Intent)
    }
}