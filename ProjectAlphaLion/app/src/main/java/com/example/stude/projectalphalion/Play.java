package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class Play extends Activity {
    public  static double level=1.0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set title off
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.display);


        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void onPlayClick(View v)
    {
        if(v.getId() == R.id.lvl1Button )
        {
            level=1.0;
            Intent i = new Intent(Play.this, Level1.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.lvl2Button )
        {
            level=1.0;
            Intent i = new Intent(Play.this, Level1.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.lvl3Button )
        {
            level=2.0;
            Intent i = new Intent(Play.this, Level1.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.lvl4Button )
        {
            level=3.0;
            Intent i = new Intent(Play.this, Level1.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.lvl5Button )
        {
            level=4.0;
            Intent i = new Intent(Play.this, Level1.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.lvl6Button )
        {
            level=5.0;
            Intent i = new Intent(Play.this, Level1.class);
            startActivity(i);
        }
    }
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(Play.this, MainActivity.class);
        startActivity(intent);

    }
}
