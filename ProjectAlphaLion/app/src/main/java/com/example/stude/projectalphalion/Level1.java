package com.example.stude.projectalphalion;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by stude on 10/18/2017.
 */

public class Level1 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.question_two);

        //set title off

        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
