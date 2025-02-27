package com.example.imadpracticumbackup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Button

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )

        //we used the postDelayed(Runnable, time) method
        //to send a message with a delayed time

        Handler().postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) //3000 is the delayed time in milliseconds.


        val buttonNavigateMainScreen = findViewById<Button>(R.id.buttonMainScreen)

        //Button which will close the app
        val buttonExitApp = findViewById<Button>(R.id.buttonExitApp)

        buttonNavigateMainScreen?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

            buttonExitApp.setOnClickListener {
                finish()
            }
        }
    }
}

