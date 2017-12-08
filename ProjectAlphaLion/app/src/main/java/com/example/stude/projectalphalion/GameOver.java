package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOver extends Activity {
    protected int score;
    protected int highestScore =0;//get from the file
    public static final String PREFS_NAME = "SAVEHIGHEST";
    public static final String HIGH_SCORE = "HighScore";
    Button retryButton;
    Button mainMenuButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.gameover);
        Bundle getScore = getIntent().getExtras();
        score = getScore.getInt("score");

        TextView highestScoreText = new TextView(this);
        TextView yourScoreText = new TextView(this);
        highestScoreText = (TextView) findViewById(R.id.highestscoret);
        yourScoreText = (TextView) findViewById(R.id.yourscoret);
        saveHighest();
        highestScoreText.setText(String.valueOf(highestScore));
        yourScoreText.setText(String.valueOf(score));



        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void saveHighest() {


//Retrieving high score
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        highestScore = settings.getInt(HIGH_SCORE, 0);

//Saving current score as high score
        SharedPreferences setting = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = setting.edit();
        if(highestScore<=score)
        {
            editor.putInt(HIGH_SCORE, score);
        }
        else
        {
            editor.putInt(HIGH_SCORE, highestScore);
        }

// Commit the edits!
        editor.commit();
    }



    public void onClick(View v)
    {
        retryButton = (Button) findViewById(R.id.retryB);
        mainMenuButton = (Button) findViewById(R.id.mainmenu);
        if(v == retryButton)
        {
            Intent i = new Intent(this,Play.class);
            startActivity(i);
        }
        else if(v==mainMenuButton)
        {
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }
}
