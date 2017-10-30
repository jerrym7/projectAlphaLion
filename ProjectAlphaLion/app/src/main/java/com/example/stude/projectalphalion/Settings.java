package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by stude on 10/26/2017.
 */


public class Settings extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.settings);
        //set title off
        setTitle("Settings");
        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void onNotificationClick(View v)
    {
        Toast.makeText(getApplicationContext(),"Notifications: On",Toast.LENGTH_SHORT).show();
    }
    public void onMusicClick(View v)
    {
        Toast.makeText(getApplicationContext(),"Music: On",Toast.LENGTH_SHORT).show();
    }
    public void onAboutClick(View v) {
        if (v.getId() == R.id.about) {
            Intent i = new Intent(Settings.this, Level1.class);
            startActivity(i);
        }
    }
}
