package com.example.tictactoeshelhaelion;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicInteger;

public class GameActivity extends AppCompatActivity {

    private ThreadExample threadExample;
    private TextView timer;
    private int gameStarted = 0;
    private void checkWin(int[][] board, String p1name, String p2name)
    {
        if(gameStarted == 0)
        {
            gameStarted = 1;
            startTimer();
        }

        if(board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1 ||
                board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1||
                board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1||
                board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1||
                board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1||
                board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1 ||
                board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1 ||
                board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1 )
        {
            //player 1 win
            Intent intent = new Intent(GameActivity.this, EndActivity.class);
            intent.putExtra("winner", p1name);
            startActivity(intent);
            finish();
        }
        else if(board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2 ||
                board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2||
                board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2||
                board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2||
                board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2||
                board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2 ||
                board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2 ||
                board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2 )
        {
            //player 2 win
            Intent intent = new Intent(GameActivity.this, EndActivity.class);
            intent.putExtra("winner", p2name);
            startActivity(intent);
            finish();
        }
        else if(board[0][0] != 0 && board[0][1] != 0 && board[0][2] != 0 &&
                board[1][0] != 0 && board[1][1] != 0 && board[1][2] != 0 &&
                board[2][0] != 0 && board[2][1] != 0 && board[2][2] != 0)
        {
            Intent intent = new Intent(GameActivity.this, EndActivity.class);
            intent.putExtra("winner", "No One!");
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String player1name = getIntent().getStringExtra("player1name");
        String player2name = getIntent().getStringExtra("player2name");
        AtomicInteger curPlayer = new AtomicInteger(1); // (player 1 / player 2)
        int board[][] = {{0,0,0},
                         {0,0,0},
                         {0,0,0}};
        timer = findViewById(R.id.timer);

        ImageView cell1 = findViewById(R.id.cell1);
        cell1.setAlpha(0);
        ImageView cell2 = findViewById(R.id.cell2);
        cell2.setAlpha(0);
        ImageView cell3 = findViewById(R.id.cell3);
        cell3.setAlpha(0);

        cell1.setOnClickListener(v -> {
            if(board[0][0] == 0)
            {
                if(curPlayer.get() == 1)
                {
                    cell1.setImageResource(R.drawable.vecna);
                    board[0][0] = 1;
                }
                else
                {
                    cell1.setImageResource(R.drawable.eleven);
                    board[0][0] = 2;
                }

                if(curPlayer.get() == 1)
                    curPlayer.set(2);
                else
                    curPlayer.set(1);
                cell1.setAlpha(200);
                checkWin(board, player1name, player2name);
            }
        });

        cell2.setOnClickListener(v -> {
            if(board[0][1] == 0)
            {
                if(curPlayer.get() == 1)
                {
                    cell2.setImageResource(R.drawable.vecna);
                    board[0][1] = 1;
                }
                else
                {
                    cell2.setImageResource(R.drawable.eleven);
                    board[0][1] = 2;
                }

                if(curPlayer.get() == 1)
                    curPlayer.set(2);
                else
                    curPlayer.set(1);
                cell2.setAlpha(200);
                checkWin(board, player1name, player2name);
            }
        });

        cell3.setOnClickListener(v -> {
            if(board[0][2] == 0)
            {
                if(curPlayer.get() == 1)
                {
                    cell3.setImageResource(R.drawable.vecna);
                    board[0][2] = 1;
                }
                else
                {
                    cell3.setImageResource(R.drawable.eleven);
                    board[0][2] = 2;
                }

                if(curPlayer.get() == 1)
                    curPlayer.set(2);
                else
                    curPlayer.set(1);
                cell3.setAlpha(200);
                checkWin(board, player1name, player2name);
            }
        });

        ImageView cell4 = findViewById(R.id.cell4);
        cell4.setAlpha(0);
        ImageView cell5 = findViewById(R.id.cell5);
        cell5.setAlpha(0);
        ImageView cell6 = findViewById(R.id.cell6);
        cell6.setAlpha(0);

        cell4.setOnClickListener(v -> {
            if(board[1][0] == 0)
            {
                if(curPlayer.get() == 1)
                {
                    cell4.setImageResource(R.drawable.vecna);
                    board[1][0] = 1;
                }
                else
                {
                    cell4.setImageResource(R.drawable.eleven);
                    board[1][0] = 2;
                }

                if(curPlayer.get() == 1)
                    curPlayer.set(2);
                else
                    curPlayer.set(1);
                cell4.setAlpha(200);
                checkWin(board, player1name, player2name);
            }
        });

        cell5.setOnClickListener(v -> {
            if(board[1][1] == 0)
            {
                if(curPlayer.get() == 1)
                {
                    cell5.setImageResource(R.drawable.vecna);
                    board[1][1] = 1;
                }
                else
                {
                    cell5.setImageResource(R.drawable.eleven);
                    board[1][1] = 2;
                }

                if(curPlayer.get() == 1)
                    curPlayer.set(2);
                else
                    curPlayer.set(1);
                cell5.setAlpha(200);
                checkWin(board, player1name, player2name);
            }
        });

        cell6.setOnClickListener(v -> {
            if(board[1][2] == 0)
            {
                if(curPlayer.get() == 1)
                {
                    cell6.setImageResource(R.drawable.vecna);
                    board[1][2] = 1;
                }
                else
                {
                    cell6.setImageResource(R.drawable.eleven);
                    board[1][2] = 2;
                }

                if(curPlayer.get() == 1)
                    curPlayer.set(2);
                else
                    curPlayer.set(1);
                cell6.setAlpha(200);
                checkWin(board, player1name, player2name);
            }
        });

        ImageView cell7 = findViewById(R.id.cell7);
        cell7.setAlpha(0);
        ImageView cell8 = findViewById(R.id.cell8);
        cell8.setAlpha(0);
        ImageView cell9 = findViewById(R.id.cell9);
        cell9.setAlpha(0);

        cell7.setOnClickListener(v -> {
            if(board[2][0] == 0)
            {
                if(curPlayer.get() == 1)
                {
                    cell7.setImageResource(R.drawable.vecna);
                    board[2][0] = 1;
                }
                else
                {
                    cell7.setImageResource(R.drawable.eleven);
                    board[2][0] = 2;
                }

                if(curPlayer.get() == 1)
                    curPlayer.set(2);
                else
                    curPlayer.set(1);
                cell7.setAlpha(200);
                checkWin(board, player1name, player2name);
            }
        });

        cell8.setOnClickListener(v -> {
            if(board[2][1] == 0)
            {
                if(curPlayer.get() == 1)
                {
                    cell8.setImageResource(R.drawable.vecna);
                    board[2][1] = 1;
                }
                else
                {
                    cell8.setImageResource(R.drawable.eleven);
                    board[2][1] = 2;
                }

                if(curPlayer.get() == 1)
                    curPlayer.set(2);
                else
                    curPlayer.set(1);
                cell8.setAlpha(200);
                checkWin(board, player1name, player2name);
            }
        });

        cell9.setOnClickListener(v -> {
            if(board[2][2] == 0)
            {
                if(curPlayer.get() == 1)
                {
                    cell9.setImageResource(R.drawable.vecna);
                    board[2][2] = 1;
                }
                else
                {
                    cell9.setImageResource(R.drawable.eleven);
                    board[2][2] = 2;
                }

                if(curPlayer.get() == 1)
                    curPlayer.set(2);
                else
                    curPlayer.set(1);
                cell9.setAlpha(200);
                checkWin(board, player1name, player2name);
            }
        });


    }
    private void startTimer() {
        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run() {
                Log.d("start timer", "Anonymous timer thread started.");

                for (int i = 60; i >= 0; i--) {
                    Log.d("", "Timer tick: " + i + "s");
                    final int display = i;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            timer.setText(String.valueOf(display));
                            if(display == 0)
                            {
                                Intent intent = new Intent(GameActivity.this, EndActivity.class);
                                intent.putExtra("winner", "No One!");
                                startActivity(intent);
                            }
                        }
                    });
                    SystemClock.sleep(1000);
                }

                Log.d("", "Anonymous timer thread finished.");
            }
        }); // התחלת ה‑Thread האנונימי
        t.start();

    }
}