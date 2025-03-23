package com.example.fitclickworkoutpage


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentXP = 0
    private var xpGoal = 5000
    private var rank = "D"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workoutType = findViewById<EditText>(R.id.workoutType)
        val workoutAmount = findViewById<EditText>(R.id.workoutAmount)
        val logWorkoutButton = findViewById<Button>(R.id.logWorkoutButton)
        val xpDisplay = findViewById<TextView>(R.id.xpDisplay)
        val xpProgressBar = findViewById<ProgressBar>(R.id.xpProgressBar)
        val rankDisplay = findViewById<TextView>(R.id.rankDisplay)

        logWorkoutButton.setOnClickListener {
            val workout = workoutType.text.toString()
            val amount = workoutAmount.text.toString().toIntOrNull()

            if (workout.isEmpty() || amount == null || amount <= 0) {
                Toast.makeText(this, "Enter valid workout and amount!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gainedXP = calculateXP(workout, amount)
            currentXP += gainedXP

            if (currentXP >= xpGoal) {
                levelUp()
            }

            xpDisplay.text = "EXP: $currentXP/$xpGoal"
            xpProgressBar.progress = currentXP
            rankDisplay.text = "Rank: $rank"
        }
    }

    private fun calculateXP(workout: String, amount: Int): Int {
        return when (workout.lowercase()) {
            "pushups" -> amount * 10
            "situps" -> amount * 8
            "running" -> amount * 15
            else -> amount * 5
        }
    }

    private fun levelUp() {
        val ranks = listOf("D", "C", "B", "A")
        val currentRankIndex = ranks.indexOf(rank)

        if (currentRankIndex < ranks.size - 1) {
            rank = ranks[currentRankIndex + 1]
            Toast.makeText(this, "Congratulations! You've ranked up to $rank!", Toast.LENGTH_LONG).show()
        }

        currentXP = 0
        xpGoal += 5000
    }
}
