package com.example.challengescreen;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView title;
    Button claim;
    ListView challenges;
    ArrayList<challenge> list = new ArrayList<>();
    ArrayAdapter<challenge> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        claim = findViewById(R.id.claimAll);
        challenges = findViewById(R.id.challenges);
        list.add(new challenge("Push-ups",30, 40));
        list.add(new challenge("Squats",35, 35));

        claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.removeIf(c -> c.done == c.total);//Collection function to remove if conditions met
                adapter.notifyDataSetChanged();
            }
        });

        adapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                list);
        challenges.setAdapter(adapter);
    }
}