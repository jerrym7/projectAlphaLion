package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.Handler;
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
import java.util.concurrent.TimeUnit;

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
    public static Handler h=new Handler(),h2=new Handler();
    public Runnable r = new Runnable() {
        @Override
        public void run() {
            runPlay();
        }
    };
    public Runnable r0 = new Runnable() {
        @Override
        public void run() {
            hearts[1].setImageResource(R.drawable.heartwhite);
            h.postDelayed(r1,200);
        }
    };
    public Runnable r1 = new Runnable() {
        @Override
        public void run() {
            hearts[1].setImageResource(R.drawable.heart);
            h.postDelayed(r2,200);
        }
    };
    public Runnable r2 = new Runnable() {
        @Override
        public void run() {
            hearts[1].setImageResource(R.drawable.heartgrey);
            h.postDelayed(r3,100);
        }
    };
    public Runnable r3 = new Runnable() {
        @Override
        public void run() {
            hearts[1].setImageResource(R.drawable.heartblack);

        }
    };
    public Runnable ar0 = new Runnable() {
        @Override
        public void run() {
            hearts[2].setImageResource(R.drawable.heartwhite);
            h.postDelayed(ar1,200);
        }
    };
    public Runnable ar1 = new Runnable() {
        @Override
        public void run() {
            hearts[2].setImageResource(R.drawable.heart);
            h.postDelayed(ar2,200);
        }
    };
    public Runnable ar2 = new Runnable() {
        @Override
        public void run() {
            hearts[2].setImageResource(R.drawable.heartgrey);
            h.postDelayed(ar3,100);
        }
    };
    public Runnable ar3 = new Runnable() {
        @Override
        public void run() {
            hearts[2].setImageResource(R.drawable.heartblack);

        }
    };
    public static Timer timer;
    public static Random RNG = new Random();
    static ArrayList<Float> allAnswers = new ArrayList<Float>();

    public static boolean animation2=false,correctA=false;
    public static ImageView  hearts[];

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
        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Level1.this.runOnUiThread(new Runnable() {
                    public void run() {
                        // update UI here
                        if(timeInSeconds>0){
                            timeInSeconds--;
                            timeLeftText.setText(Integer.toString((int) timeInSeconds));
                        }
                        else {
                            timeInSeconds=origTIme;
                            timeLeftText.setText(Integer.toString((int) timeInSeconds));
                            lives--;
                            correctA=false;
                            loseheart();
                            h2.postDelayed(r,0);
                        }
                    }
                });
            }
        },0, 1000);

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
            timeLeftText.setText(Integer.toString((int)timeInSeconds));
            loseheart();

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
    public void loseheart(){
        if(!correctA&&lives==2){
            h.postDelayed(ar0,0);
            animation2=true;
        }
        else if(animation2&&!correctA){
            h.postDelayed(r0,0);
            animation2=false;
        }
        else{

        }
    }
}
