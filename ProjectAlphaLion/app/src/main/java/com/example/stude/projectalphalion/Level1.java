package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Random;


public class Level1 extends Activity {
    MediaPlayer bgroundMusic;
    int score = 0;
    TextView scoreText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.question_two);

        //set title off

        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        startBackgroundMusic();

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
            score+=10;//keep track of the score
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
