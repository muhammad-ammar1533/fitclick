package com.example.fitclick

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameField = findViewById<EditText>(R.id.username)
        val passwordField = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val leaderboardRecyclerView = findViewById<RecyclerView>(R.id.leaderboardRecyclerView)

        // Set up RecyclerView
        leaderboardRecyclerView.layoutManager = LinearLayoutManager(this)
        leaderboardRecyclerView.adapter = LeaderboardAdapter(getLeaderboardData())

        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Logged in as $username", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {
            Toast.makeText(this, "Registration Feature Coming Soon!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getLeaderboardData(): List<LeaderboardItem> {
        return listOf(
            LeaderboardItem("#1 ai3", "EXP: 15000000000057100", "Rank: A"),
            LeaderboardItem("#2 ammar", "EXP: 5001136169", "Rank: A"),
            LeaderboardItem("#3 ai", "EXP: 69676538", "Rank: A"),
            LeaderboardItem("#4 raheem", "EXP: 6611370", "Rank: A"),
            LeaderboardItem("#5 ali", "EXP: 6060030", "Rank: A"),
            LeaderboardItem("#6 ai2", "EXP: 2000000", "Rank: B"),
            LeaderboardItem("#7 amar", "EXP: 322703", "Rank: B"),
            LeaderboardItem("#8 ai4", "EXP: 52200", "Rank: D"),
            LeaderboardItem("#9 sam", "EXP: 51090", "Rank: D"),
            LeaderboardItem("#10 AzwadUddin", "EXP: 1608", "Rank: E")
        )
    }
}
