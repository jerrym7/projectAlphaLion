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
    int[] answers = new int[3]; //answers
    boolean[] correct = new boolean[3]; //correct or not
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.question_two);

        //set title off

        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        scoreText = findViewById(R.id.score);
        questionText = findViewById(R.id.question_text);
        generateQ();
        p1_button = (Button)findViewById(R.id.button0);
        p3_button = (Button)findViewById(R.id.button2);
        p2_button = (Button)findViewById(R.id.button1);
        //startBackgroundMusic();

    }

    private void generateQ() {

        questionText.setText(foo(answers,correct));//call the function

        p1_button.setText(Integer.toString(answers[0]));
        p2_button.setText(Integer.toString(answers[1]));
        p3_button.setText(Integer.toString(answers[2]));
    }


    /**public void startBackgroundMusic()
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
    }*/
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

        if(v == p1_button )
        {
            if(correct[0]==true) {
                score += 1;
                scoreText.setBackgroundColor(this.getResources().getColor(R.color.colorCorrect));
                scoreText.setText(Integer.toString(score));
            }
            else
            {
                scoreText.setBackgroundColor(Color.RED);
                scoreText.setText(Integer.toString(score));
            }
            generateQ();
        }
        else if(v == p2_button )
        {
            if(correct[1]==true) {
                score += 1;
                scoreText.setBackgroundColor(this.getResources().getColor(R.color.colorCorrect));
                scoreText.setText(Integer.toString(score));
            }
            else
            {
                scoreText.setBackgroundColor(Color.RED);
                scoreText.setText(Integer.toString(score));
            }
            generateQ();
        }
        else
        {
            if(correct[2]==true) {
                score += 1;
                scoreText.setBackgroundColor(this.getResources().getColor(R.color.colorCorrect));
                scoreText.setText(Integer.toString(score));
            }
            else
            {
                scoreText.setBackgroundColor(Color.RED);
                scoreText.setText(Integer.toString(score));
            }
            generateQ();
        }

    }
    public static String foo(int[] x, boolean[] y)
    {
        Random rand = new Random();
        int num1=rand.nextInt(11);
        int num2= rand.nextInt(11);
        int cAnswer = rand.nextInt(3);
        for(int i = 0;i<3;i++)
        {
            if(cAnswer==i)
            {
                x[i] = num1+num2;
                y[i]=true;
            }
            else {
                x[i] = rand.nextInt(11) + rand.nextInt(11);
                y[i] = false;
            }
        }
        for(int i=0;i<x.length-1;i++)
        {
            for(int j = i+1;j<x.length;j++)
            {
                if(x[i]==x[j])
                {
                    return foo(x,y);
                }

            }
        }
        return num1+" + " +num2;
    }
}
