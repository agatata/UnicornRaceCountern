package com.example.android.unicornracecountern;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.unicornracecountern.R;

public class MainActivity extends Activity {

    static final String STATE_SCOREA = "scoreA";
    static final String STATE_SCOREB = "scoreB";
    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the FLUFFY OBSTACLE button is clicked.
     */
    public void addOneForA(View view) {
        scoreA = scoreA + 1;
        displayForA(scoreA);
    }

    /**
     * This method is called when the RAINBOW SLIDE button is clicked.
     */
    public void addFiveForA(View view) {
        scoreA = scoreA + 5;
        displayForA(scoreA);
    }

    /**
     * This method is called when the STYLE BONUS button is clicked.
     */
    public void addTenForA(View view) {
        scoreA = scoreA + 10;
        displayForA(scoreA);
        if (view.getId() == R.id.TenForA) {
            Button btnA = (Button) findViewById(R.id.TenForA);
            btnA.setEnabled(false);
            Toast.makeText(this, "You can score the style only once", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method is called when the FLUFFY OBSTACLE button is clicked.
     */
    public void addOneForB(View view) {
        scoreB = scoreB + 1;
        displayForB(scoreB);
    }

    /**
     * This method is called when the RAINBOW SLIDE button is clicked.
     */
    public void addFiveForB(View view) {
        scoreB = scoreB + 5;
        displayForB(scoreB);
    }


    /**
     * This method is called when the STYLE BONUS button is clicked.
     */
    public void addTenForB(View view) {
        scoreB = scoreB + 10;
        displayForB(scoreB);
        if (view.getId() == R.id.TenForB) {
            Button btnB = (Button) findViewById(R.id.TenForB);
            btnB.setEnabled(false);
            Toast.makeText(this, "You can score the style only once", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method prevents the setting up zero points (restarting app) by rotating the screen.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //Save the user's current score state
        savedInstanceState.putInt(STATE_SCOREA, scoreA);
        savedInstanceState.putInt(STATE_SCOREB, scoreB);

        // Call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        //Restore state members from saved instance
        scoreA = savedInstanceState.getInt(STATE_SCOREA);
        scoreB = savedInstanceState.getInt(STATE_SCOREB);

        displayForA(scoreA);
        displayForB(scoreB);
    }

    /**
     * Display the given score for Team A
     */
    public void displayForA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.unicorn_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display the given score for Team B
     */
    public void displayForB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.unicorn_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method is called when the RESET button is clicked.
     */
    public void Reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayForA(0);
        displayForB(0);
        Button btnA = (Button) findViewById(R.id.TenForA);
        btnA.setEnabled(true);
        Button btnB = (Button) findViewById(R.id.TenForB);
        btnB.setEnabled(true);
    }
}