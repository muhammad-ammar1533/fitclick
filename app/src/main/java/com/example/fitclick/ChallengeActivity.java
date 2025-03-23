package com.example.fitclick;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitclick.R;
import com.example.fitclick.challenge;

import java.util.ArrayList;

public class ChallengeActivity extends AppCompatActivity {
    TextView title;
    Button claim, toGame;
    ListView challenges;
    ArrayList<challenge> list = new ArrayList<>();
    ArrayAdapter<challenge> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        title = findViewById(R.id.title);
        claim = findViewById(R.id.claimAll);
        toGame = findViewById(R.id.toGame);
        challenges = findViewById(R.id.challenges);
        list.add(new challenge("Pushups",30, 40));
        list.add(new challenge("Situps",35, 35));

        claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.removeIf(c -> c.done == c.total);//Collection function to remove if conditions met
                adapter.notifyDataSetChanged();
            }
        });
        toGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChallengeActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        adapter = new ArrayAdapter<>(this,R.layout.list_challenge,
                R.id.challenge_text, list);
        challenges.setAdapter(adapter);
    }
}