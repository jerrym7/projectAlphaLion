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

import java.util.ArrayList;
import java.util.Random;


public class Level1 extends Activity {
    MediaPlayer bgroundMusic;
    int score = 0;
    TextView scoreText,questionText;
    Button p1_button,p2_button,p3_button;
    int[] answers = new int[3]; //answers
    public static int ASboundary = 20;
    public static int MDboundary = 12;
    public static int operation = 0;
    public static int answer = 0;
    public static int lives =3;
    public static Random RNG = new Random();
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

        p1_button = (Button)findViewById(R.id.button0);
        p3_button = (Button)findViewById(R.id.button2);
        p2_button = (Button)findViewById(R.id.button1);
        //startBackgroundMusic();
        generateQ();

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

    //generator 
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

    public int[] generate(double levelNum){
        //As the level increases, the likelihood of a 3 number, 4 number, or 5 number
        // problem increases. At level 1.1, the likelihood of a 3 number problem is
        // '10%'.
        Random rng = new Random();
        int temp = (int)levelNum*10;
        int equationSize = rng.nextInt(temp) +1;
        equationSize = equationSize/10 + 1;
        int x[] = new int[equationSize+1];


        //1 = add, 2 = subtract. 3 = mult, 4 = divide
        operation = rng.nextInt(4)+1;

        //generate question components. If 1 or 2, ASBoundary used. If 3 or 4, MDBoundary
        for(int i = 0; i < x.length; i++){
            if (operation ==1||operation == 2){
                x[i] = rng.nextInt(ASboundary)+1;
            }
            else{
                x[i] = rng.nextInt(MDboundary)+1;
            }
        }


        return x;
    }
    public void gameRun()
    {
        // Although levelNum is used for displaying, it also decides how big a
        // problem will be, and also how big the numbers will be.
        double levelNum = 1.1;


        //Continue loop while player is winning. Starts off true, because
        // the player is already winning by choosing our amazing game.
        boolean winning = true;
        while(lives>0){
            //Display level with levelNum; increment by 0.1 each loop run.
            System.out.println("Level "+ levelNum );


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
            String toString = "" + question[0];

            //Adding
            if(operation == 1){
                //Note: each for-loop starts at value 1, because the first value MUST be added
                // to the 'answer'. Otherwise, you end up subtracting answer (which is 0)
                // by all the values in the question.
                for (int i = 1; i < question.length; i++){
                    answer = answer + question[i];
                    toString += " + " + question[i];
                }
            }
            //Subtracting
            else if(operation == 2){
                for (int i = 1; i < question.length; i++){
                    answer = answer - question[i];
                    toString += " - " + question[i];
                }
            }

            else if(operation == 3){
                for (int i = 1; i < question.length; i++){
                    answer = answer * question[i];
                    toString += " * " +question[i];
                }
            }
            else if(operation == 4){
                for (int i = 1; i < question.length; i++){
                    answer = answer / question[i];
                    toString += " / " + question[i];
                }
            }
            else{
                //fail-case. wont occur though
                System.out.println("If Operation failed.");
            }
            //display question
            System.out.println(toString);
            // Rusty answer generator, but it does create a unique positioning
            // system for each answer. Could be improved if deviation formula is
            // used for 'wrong' answers added to the list.
            ArrayList<Integer> allAnswers = new ArrayList<Integer>();
            allAnswers.add(answer);
            allAnswers.add(answer + 1);
            allAnswers.add(answer - 1);
            allAnswers.add(answer +10);

            int pick = 0;
            while (!allAnswers.isEmpty()){
                pick = RNG.nextInt(allAnswers.size());
                p1_button.setText(Integer.toString(allAnswers.remove(pick)));
            }
            // code below should be replaced
           /* Scanner s = new Scanner(System.in);
            int playerchoice = s.nextInt();
            if (answer == playerchoice){
                System.out.println("Win!");
            }
            else{
                lives--;
                System.out.println("Lost a life");
            }
*/
            levelNum = levelNum+0.1;
        }// end -while loop for game. If winning = false, exits.

    }
}
