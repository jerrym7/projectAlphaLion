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
        //startBackgroundMusic();

    }

    /* not yet done//prototype 11/7/17
     public void question2(View v) {
        //update text of question and buttons
        int x[] = new int[3];
        boolean[] y = new boolean[3];
        questionText.setText("What is "+foo(x,y) +"?");
        p1_button = (Button)findViewById(R.id.wronganswer_2_1);
        p1_button.setText(x[0]);
        p2_button = (Button)findViewById(R.id.theanswertotwo);
        p2_button.setText(x[1]);
        p3_button = (Button)findViewById(R.id.wronganswer_2_2);
        p3_button.setText(x[2]);


    }
     */
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
        int[] answers = new int[3]; //answers
        boolean[] correct = new boolean[3]; //correct or not
        questionText.setText(foo(answers,correct));//call the function
        p1_button = (Button)findViewById(R.id.button0);
        p1_button.setText(answers[0]);
        p2_button = (Button)findViewById(R.id.button1);
        p2_button.setText(answers[1]);
        p3_button = (Button)findViewById(R.id.button2);
        p3_button.setText(answers[2]);
        if(v.getId() == R.id.button0 )
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
        }
        else if(v.getId() == R.id.button1 )
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
        return num1+" + " +num2;
    }
}
