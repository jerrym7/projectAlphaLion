package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class Play extends Activity {
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
