package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends Activity {
    protected int score;
    protected int highestScore =10;
    Button retryButton;
    Button mainMenuButton;
    TextView highestScoreText = (TextView) findViewById(R.id.yourscoret);
    TextView yourScoreText = (TextView) findViewById(R.id.highestscoret);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Bundle getScore = getIntent().getExtras();
        score = getScore.getInt("score");
        //yourScoreText.setText("1");
        //highestScoreText.setText("0");
        setContentView(R.layout.gameover);


        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
