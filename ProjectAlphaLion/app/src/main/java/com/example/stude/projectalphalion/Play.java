package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Gerardo on 10/18/2017.
 */

public class Play extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.display);


        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void onButtonClick(View v)
    {
        /*if(v.getId() == R.id.b )
        {
            Intent i = new Intent(Play.this, Level1.class);
            startActivity(i);
        }
      /*  if(v.getId() == R.id.bscores )
        {
            Intent i = new Intent(MainActivity.this, Play.class);
            startActivity(i);
        }*/
    }
}
