package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class Level1 extends Activity {
    MediaPlayer bgroundMusic;
    int score = 0;
    TextView scoreText,questionText;
    Button p1_button,p2_button,p3_button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.question_two);

        //set title off

        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        scoreText = findViewById(R.id.score);
        questionText = findViewById(R.id.question_text);
        startBackgroundMusic();

    }
    public void questions(View v) {
        //update text of question and buttons
        questionText.setText("What is 3+3 ?");
        p1_button = (Button)findViewById(R.id.wronganswer_2_1);
        p1_button.setText("10");
        p2_button = (Button)findViewById(R.id.theanswertotwo);
        p2_button.setText("6");
        p3_button = (Button)findViewById(R.id.wronganswer_2_2);
        p3_button.setText("100");


    }
    public void startBackgroundMusic()
    {
        int[] sounds={R.raw.sellingdrugs, R.raw.deadpresidents};
        Random r = new Random();
        int Low = 0;
        int High = 2;
        int rand = r.nextInt(High-Low) + Low;
        bgroundMusic = MediaPlayer.create(getApplicationContext(),sounds[rand]);
        bgroundMusic.start();
        // bgroundMusic = MediaPlayer.create(MainActivity.this,R.raw.sellingdrugs);
        bgroundMusic.setLooping(true);
        // bgroundMusic.start();
    }
    //method to avoid the crash after going back to main menu
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(Level1.this, MainActivity.class);
        startActivity(intent);

    }
    /*
        Function to stop the music after it they close the app
     */
    protected void onPause()
    {
        super.onPause();
        bgroundMusic.release();
        finish();
    }
    public void onClick(View v) {
        if (v.getId() == R.id.theanswertotwo) {
            score+=1;//keep track of the score
            //set a custom color green
            scoreText.setBackgroundColor(this.getResources().getColor(R.color.colorCorrect));
            scoreText.setText(Integer.toString(score));

        }
        else if(v.getId() == R.id.wronganswer_2_1)
        {
            scoreText.setBackgroundColor(Color.RED);
            scoreText.setText(Integer.toString(score));
        }
        else if(v.getId() == R.id.wronganswer_2_2)
        {
            scoreText.setBackgroundColor(Color.RED);
            scoreText.setText(Integer.toString(score));
        }
    }
}
