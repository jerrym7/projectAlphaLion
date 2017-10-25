package com.example.stude.alphalion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by stude on 10/18/2017.
 */

public class Play extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.display);
        //set title off

        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.bplay )
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
