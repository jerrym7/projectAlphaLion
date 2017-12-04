package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.stude.projectalphalion.Play.level;


public class Level1 extends Activity {
    MediaPlayer bgroundMusic2;
    int score = 0;
    TextView scoreText;
    TextView questionText;
    TextView timeLeftText;
    Button p1_button;
    Button p2_button;
    Button p3_button;
    Button p4_button;
    int[] answers = new int[3]; //answers
    boolean[] correct = new boolean[3]; //correct or not
    public static int ASboundary = 20;
    public static int MDboundary = 12;
    public static int operation = 0;
    public static float answer = 0;
    public static int lives ;
    public static double levelNum;
    public static double timeInSeconds, origTIme;
    public static Timer timer,animateTimer0,animateTimer1,animateTimer2;
    public static TimerTask timeAn0,timeAn1,timeAn2;
    public static boolean animation2=false,correctA=false;
    public static ImageView  hearts[];
    public static Random RNG = new Random();
    static ArrayList<Float> allAnswers = new ArrayList<Float>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.question_two);

        //set title off
        hearts=new ImageView[3];
        hearts[0]=(ImageView)findViewById(R.id.imageView0);
        hearts[0].setImageResource(R.drawable.heart);
        hearts[1]=(ImageView)findViewById(R.id.imageView1);
        hearts[1].setImageResource(R.drawable.heart);
        hearts[2]=(ImageView)findViewById(R.id.imageView2);
        hearts[2].setImageResource(R.drawable.heart);
        //load level and timer
        levelNum = level;
        origTIme=levelNum * 0.2 + 10;
        timeInSeconds = origTIme;
        TimerTask timeFunc = new TimerTask(){
            @Override
            public void run(){
                if(timeInSeconds>0){
                    timeInSeconds--;
                    timeLeftText.setText(Integer.toString((int) timeInSeconds));
                }
                else {

                    timeLeftText.setText(Integer.toString((int) timeInSeconds));

                }
            }
        };
        timer=new Timer();
        timer.scheduleAtFixedRate(timeFunc,(int)(1000),(int)(1000));

        timeAn0 = new TimerTask(){
            @Override
            public void run(){
               animation0();
               animateTimer0.cancel();
            }
        };
        timeAn1 = new TimerTask(){
            @Override
            public void run(){
                animation1();
                animateTimer1.cancel();

            }
        };
        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        scoreText = findViewById(R.id.score);
        questionText = findViewById(R.id.question_text);
        timeLeftText = findViewById(R.id.timeLeft);
        timeLeftText.setText(Integer.toString((int) timeInSeconds));
        //
        p1_button = (Button) findViewById(R.id.button0);
        p3_button = (Button) findViewById(R.id.button2);
        p2_button = (Button) findViewById(R.id.button1);
        p4_button = (Button) findViewById(R.id.button3);
        //startBackgroundMusic();
        lives = 3;
        runPlay();
    }



    /**
     * public void startBackgroundMusic()
     * {
     * int[] sounds={R.raw.sellingdrugs, R.raw.deadpresidents};
     * Random r = new Random();
     * int Low = 0;
     * int High = 2;
     * int rand = r.nextInt(High-Low) + Low;
     * bgroundMusic = MediaPlayer.create(getApplicationContext(),sounds[rand]);
     * bgroundMusic.start();
     * // bgroundMusic = MediaPlayer.create(MainActivity.this,R.raw.sellingdrugs);
     * bgroundMusic.setLooping(true);
     * // bgroundMusic.start();
     * }
     */
    //method to avoid the crash after going back to main menu

    /*
        Function to stop the music after it they close the app
     */
    /*protected void onPause() {
        super.onPause();
        bgroundMusic.release();
        finish();
    }
*/
    public void onClick(View v) {

            if (v == p1_button) {
                if (p1_button.getText().equals(Double.toString(answer))) {
                    score += 1;
                    correctA=true;
                    scoreText.setBackgroundColor(this.getResources().getColor(R.color.colorCorrect));
                    scoreText.setText(Integer.toString(score));
                } else {
                    correctA=false;
                    scoreText.setBackgroundColor(Color.RED);
                    scoreText.setText(Integer.toString(score));
                    lives--;
                }
                runPlay();
            } else if (v == p2_button) {
                if (p2_button.getText().equals(Double.toString(answer))) {
                    score += 1;
                    correctA=true;
                    scoreText.setBackgroundColor(this.getResources().getColor(R.color.colorCorrect));
                    scoreText.setText(Integer.toString(score));
                } else {
                    correctA=false;
                    scoreText.setBackgroundColor(Color.RED);
                    scoreText.setText(Integer.toString(score));
                    lives--;
                }
                runPlay();
            } else if (v == p3_button) {
                if (p3_button.getText().equals(Double.toString(answer))) {
                    score += 1;
                    correctA=true;
                    scoreText.setBackgroundColor(this.getResources().getColor(R.color.colorCorrect));
                    scoreText.setText(Integer.toString(score));
                } else {
                    correctA=false;
                    scoreText.setBackgroundColor(Color.RED);
                    scoreText.setText(Integer.toString(score));
                    lives--;
                }
                runPlay();
            } else if(v == p4_button) {
                if (p4_button.getText().equals(Double.toString(answer))) {
                    score += 1;
                    correctA=true;
                    scoreText.setBackgroundColor(this.getResources().getColor(R.color.colorCorrect));
                    scoreText.setText(Integer.toString(score));
                } else {
                    correctA=false;
                    scoreText.setBackgroundColor(Color.RED);
                    scoreText.setText(Integer.toString(score));
                    lives--;
                }
                runPlay();
            }
            origTIme=levelNum * 0.2 + 10;
            timeInSeconds = origTIme;
            if(!correctA&&lives==2){
                animateTimer0=new Timer();
                animateTimer0.scheduleAtFixedRate(timeAn0,0,(int)(100000));
                animation2=true;
            }
            else if(animation2&&!correctA){
                animateTimer1=new Timer();
                animateTimer1.scheduleAtFixedRate(timeAn1,0,(int)(100000));
                animation2=false;
            }
            else{

            }
    }



    public void runPlay()
    {


        // Although levelNum is used for displaying, it also decides how big a
        // problem will be, and also how big the numbers will be.


        //Continue loop while player is winning. Starts off true, because
        // the player is already winning by choosing our amazing game.
        boolean winning = true;
        if(lives>0){
            //Display level with levelNum; increment by 0.1 each loop run.


            //Difficulty mechanic. Level multiples of 0.5 (level 1.5, 2.0, 2.5..)
            // will have larger boundaries, which means larger numbers potentially
            Equation eq = new Equation();
            eq.start(level);
            String qString = eq.questionString;
            //display question
            questionText.setText("What is "+qString +"?");
            // Rusty answer generator, but it does create a unique positioning
            // system for each answer. Could be improved if deviation formula is
            // used for 'wrong' answers added to the list.
            answer = eq.correctAnswer;
            allAnswers.add(eq.correctAnswer);
            allAnswers.add((float)(eq.correctAnswer + 1.00));
            allAnswers.add((float)(eq.correctAnswer - 1.00));
            allAnswers.add((float)(eq.correctAnswer +10.0));

            int pick = 0;
            while (!allAnswers.isEmpty()){
                pick = RNG.nextInt(allAnswers.size());
                p1_button.setText(Float.toString(allAnswers.remove(pick)));
                pick = RNG.nextInt(allAnswers.size());
                p2_button.setText(Float.toString(allAnswers.remove(pick)));
                pick = RNG.nextInt(allAnswers.size());
                p3_button.setText(Float.toString(allAnswers.remove(pick)));
                pick = RNG.nextInt(allAnswers.size());
                p4_button.setText(Float.toString(allAnswers.remove(pick)));

            }


            level = level+0.1;
        }
        else
        {

            goLevelWorld();// end -while loop for game. If winning = false, exits.
        }

    }
    //go back to level world after you got 0 lives
    private void goLevelWorld() {
        if(timer != null) {
            timer.cancel();
            timer.purge();
            timer = null;
        }
        Intent i = new Intent(Level1.this, Play.class);
        startActivity(i);

    }
    public void onBackPressed(){
        if(timer != null) {
            timer.cancel();
            timer.purge();
            timer = null;
        }
        super.onBackPressed();
        Intent intent = new Intent(Level1.this, Play.class);
        startActivity(intent);

    }
    public void animation0(){
        int life =2;
        hearts[life].setImageResource(R.drawable.heartgrey);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartwhite);
        try{
            Thread.sleep(200);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heart);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartgrey);
        try{
            Thread.sleep(200);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartwhite);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heart);
        try{
            Thread.sleep(200);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartgrey);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartblack);
    }
    public void animation1(){
        int life =1;
        hearts[life].setImageResource(R.drawable.heartgrey);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartwhite);
        try{
            Thread.sleep(200);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heart);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartgrey);
        try{
            Thread.sleep(200);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartwhite);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heart);
        try{
            Thread.sleep(200);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartgrey);
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException e){}
        hearts[life].setImageResource(R.drawable.heartblack);
    }
}
