package com.example.tictactoeshelhaelion;

import android.os.SystemClock;
import android.util.Log;


public class ThreadExample extends Thread {
    private boolean gameOver = false;
    int counter = 0;
    @Override
    public void run() {
        super.run();

        while(!gameOver) {
            SystemClock.sleep(1000); // sleep for 1 second
            Log.d("TIMER", "run: i = " + counter++);
        }
        Log.d("TIMER", "gameOver" );
    }
    public void endGame()
    {
        gameOver = true;
    }

}
