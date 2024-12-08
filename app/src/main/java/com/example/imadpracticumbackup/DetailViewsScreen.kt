package com.example.imadpracticumbackup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailViewsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_views_screen)

        val textViewScreenTimeDetails = findViewById<TextView>(R.id.textViewScreenTimeDetails)
        val buttonMainActivity = findViewById<Button>(R.id.buttonMainActivity)

        val screenTimes = intent.getIntArrayExtra("screenTimes")

        // Display screen time details for each day
        val displayText = StringBuilder()
        screenTimes?.let {
            for (i in it.indices) {
                displayText.append("${getDayName(i)}: ${it[i]} minutes\n")
            }
        }

        textViewScreenTimeDetails.text = displayText


        buttonMainActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }

    private fun getDayName(index: Int): String {
        return when (index) {
            0 -> "Monday"
            1 -> "Tuesday"
            2 -> "Wednesday"
            3 -> "Thursday"
            4 -> "Friday"
            5 -> "Saturday"
            6 -> "Sunday"
            else -> "Unknown"
        }
    }
}