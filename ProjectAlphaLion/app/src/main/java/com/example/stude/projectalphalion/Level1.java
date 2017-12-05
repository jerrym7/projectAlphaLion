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
    public static int answer = 0;
    public static int lives ;
    public static double levelNum;
    public static double timeInSeconds, origTIme;
    public static Timer timer,animateTimer0,animateTimer1,animateTimer2;
    public static TimerTask timeAn0,timeAn1,timeAn2;
    public static boolean animation2=false,correctA=false;
    public static ImageView  hearts[];
    public static Random RNG = new Random();
    static ArrayList<Integer> allAnswers = new ArrayList<Integer>();


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

    private void generateQ() {

        questionText.setText(foo(answers, correct));//call the function

        p1_button.setText(Integer.toString(answers[0]));
        p2_button.setText(Integer.toString(answers[1]));
        p3_button.setText(Integer.toString(answers[2]));
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
                if (p1_button.getText().equals(Integer.toString(answer))) {
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
                if (p2_button.getText().equals(Integer.toString(answer))) {
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
                if (p3_button.getText().equals(Integer.toString(answer))) {
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
                if (p4_button.getText().equals(Integer.toString(answer))) {
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
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        animateTimer0=new Timer();
                        animateTimer0.scheduleAtFixedRate(timeAn0,0,(int)(100000));
                        animation2=true;
                        try{
                            Thread.sleep(10000);
                        }
                        catch (InterruptedException e){}

                    }
                });
            }
            else if(animation2&&!correctA){
                animateTimer1=new Timer();
                animateTimer1.scheduleAtFixedRate(timeAn1,0,(int)(100000));
                animation2=false;
            }
            else{

            }
    }

    //generator
    public static String foo(int[] x, boolean[] y) {
        Random rand = new Random();
        int num1 = rand.nextInt(11);
        int num2 = rand.nextInt(11);
        int cAnswer = rand.nextInt(3);
        for (int i = 0; i < 3; i++) {
            if (cAnswer == i) {
                x[i] = num1 + num2;
                y[i] = true;
            } else {
                x[i] = rand.nextInt(11) + rand.nextInt(11);
                y[i] = false;
            }
        }
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] == x[j]) {
                    return foo(x, y);
                }

            }
        }
        return num1 + " + " + num2;
    }

    public static int[] generate(double levelNum) {
        //As the level increases, the likelihood of a 3 number, 4 number, or 5 number
        // problem increases. At level 1.1, the likelihood of a 3 number problem is
        // '10%'.
        Random rng = new Random();
        int temp = (int) levelNum * 10;
        int equationSize = rng.nextInt(temp) + 1;
        equationSize = equationSize / 10 + 1;
        int x[] = new int[equationSize + 1];


        //1 = add, 2 = subtract. 3 = mult, 4 = divide
        operation = rng.nextInt(4) + 1;

        //generate question components. If 1 or 2, ASBoundary used. If 3 or 4, MDBoundary
        for (int i = 0; i < x.length; i++) {
            if (operation == 1 || operation == 2) {
                x[i] = rng.nextInt(ASboundary) + 1;
            } else {
                x[i] = rng.nextInt(MDboundary) + 1;
            }
        }


        return x;
    }
    public void runPlay()
    {


        // Although levelNum is used for displaying, it also decides how big a
        // problem will be, and also how big the numbers will be.
        //levelNum = level;


        //Continue loop while player is winning. Starts off true, because
        // the player is already winning by choosing our amazing game.
        boolean winning = true;
        if(lives>0){
            //Display level with levelNum; increment by 0.1 each loop run.


            //Difficulty mechanic. Level multiples of 0.5 (level 1.5, 2.0, 2.5..)
            // will have larger boundaries, which means larger numbers potentially
            if (levelNum%0.5==0){
                ASboundary = ASboundary + 15;
                MDboundary = MDboundary + 2;
            }

            // Call generate, which creates an array of unique, random numbers
            // to be used in a question.
            int question[]= generate(levelNum);

            answer = question[0];

            //toString will be the output, modified based on operation (+, -, *, /)
            String qString = "" + question[0];

            //Adding
            if(operation == 1){
                //Note: each for-loop starts at value 1, because the first value MUST be added
                // to the 'answer'. Otherwise, you end up subtracting answer (which is 0)
                // by all the values in the question.
                for (int i = 1; i < question.length; i++){
                    answer = answer + question[i];
                    qString += " + " + question[i];
                }
            }
            //Subtracting
            else if(operation == 2){
                for (int i = 1; i < question.length; i++){
                    answer = answer - question[i];
                    qString += " - " + question[i];
                }
            }

            else if(operation == 3){
                for (int i = 1; i < question.length; i++){
                    answer = answer * question[i];
                    qString += " * " +question[i];
                }
            }
            else if(operation == 4){
                for (int i = 1; i < question.length; i++){
                    answer = answer / question[i];
                    qString += " / " + question[i];
                }
            }
            else{
                //fail-case. wont occur though
            }
            //display question
            questionText.setText("What is "+qString +"?");
            // Rusty answer generator, but it does create a unique positioning
            // system for each answer. Could be improved if deviation formula is
            // used for 'wrong' answers added to the list.

            allAnswers.add(answer);
            allAnswers.add(answer + 1);
            allAnswers.add(answer - 1);
            allAnswers.add(answer +10);

            int pick = 0;
            while (!allAnswers.isEmpty()){
                pick = RNG.nextInt(allAnswers.size());
                p1_button.setText(Integer.toString(allAnswers.remove(pick)));
                pick = RNG.nextInt(allAnswers.size());
                p2_button.setText(Integer.toString(allAnswers.remove(pick)));
                pick = RNG.nextInt(allAnswers.size());
                p3_button.setText(Integer.toString(allAnswers.remove(pick)));
                pick = RNG.nextInt(allAnswers.size());
                p4_button.setText(Integer.toString(allAnswers.remove(pick)));

            }


            levelNum = levelNum+0.1;
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
