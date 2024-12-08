package com.example.imadpracticumbackup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //Parallel array to store data and corresponding data
    private val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private var screenTimes = IntArray(7) { 0 } //This stores the screen time for each day in minutes
    private var currentDayIndex = 0 // To make sure the current day is accounted for

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextData = findViewById<EditText>(R.id.editTextData)
        val buttonEnterData = findViewById<Button>(R.id.buttonEnterData)
        val buttonClearData = findViewById<Button>(R.id.buttonClearData)
        val buttonDetailViews = findViewById<Button>(R.id.buttonDetailViews)

        // setOnClickListeners
        buttonEnterData.setOnClickListener {
            try {
                // get input data and store it in an array
                val screenTimeInput = editTextData.text.toString()

                //error handling
                if (screenTimeInput.isNotEmpty()) {
                    val screenTime = screenTimeInput.toInt()
                    if (screenTime < 0) {
                        throw IllegalArgumentException("Screen time cannot be negative.")
                    }
                    screenTimes[currentDayIndex] = screenTime
                    currentDayIndex = (currentDayIndex + 1) % 7 // Go through days of the week
                }
            } catch (e:Exception) {
                //Handle input errors
                editTextData.error = "Invalid input, please try again."
                }
            }

        // Clear input data
        buttonClearData.setOnClickListener {
            screenTimes.fill(0)  // Reset the screen time array to zero
            currentDayIndex = 0  // Reset the day input tracker
        }


        buttonDetailViews.setOnClickListener {
            val intent = Intent(this, DetailViewsScreen::class.java)
            intent.putExtra("screenTimes", screenTimes) // pass array to DetailViewsActivity
            startActivity(intent)

            }
        }
    }
