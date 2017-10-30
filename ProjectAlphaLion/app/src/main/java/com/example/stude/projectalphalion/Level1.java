package com.example.stude.projectalphalion;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.util.Random;

/**
 * Created by Gerardo on 10/18/2017.
 */

public class Level1 extends Activity {
    MediaPlayer bgroundMusic;
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
    /*
        Function to stop the music after it they close the app
     */
    protected void onPause()
    {
        super.onPause();
        bgroundMusic.release();
        finish();
    }
}
