package com.example.tictactoeshelhaelion;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText player1 = findViewById(R.id.player1name);
        EditText player2 = findViewById(R.id.player2name);
        ImageView startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(v -> {
            String name1 = player1.getText().toString();
            String name2 = player2.getText().toString();


            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            intent.putExtra("player1name", name1);
            intent.putExtra("player2name", name2);
            startActivity(intent);
        });
    }

}