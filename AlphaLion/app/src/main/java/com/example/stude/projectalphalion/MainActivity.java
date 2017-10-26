package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.bplay )
        {
            Intent i = new Intent(MainActivity.this, Play.class);
            startActivity(i);
        }
        if(v.getId() == R.id.bsettings )
        {
            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);
        }
    }

}
