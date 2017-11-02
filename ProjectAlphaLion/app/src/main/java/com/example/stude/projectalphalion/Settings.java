package com.example.stude.projectalphalion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;



public class Settings extends Activity implements CompoundButton.OnCheckedChangeListener{
    Switch n, m; //(n)otification switch and (m)usic switch
    //TextView textView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.settings);
        //set title off
        setTitle("Settings");
        //full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        n = (Switch) findViewById(R.id.snotification);
        m = (Switch) findViewById(R.id.smusic);
        //textView = (TextView)findViewById(R.id.textView);
        n.setOnCheckedChangeListener(this);

    }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    //method for Notification switch
    public void onNotificationClick(View v)
    {
        if(n.isChecked())
            Toast.makeText(getApplicationContext(),"Notifications: On",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Notifications: Off",Toast.LENGTH_SHORT).show();
    }
    //method for Music switch
    public void onMusicClick(View v)
    {
        if(m.isChecked())
            Toast.makeText(getApplicationContext(),"Music: On",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Music: Off",Toast.LENGTH_SHORT).show();
    }
    //method for About button
    public void onAboutClick(View v) {
        if (v.getId() == R.id.about) {
            Intent i = new Intent(Settings.this, Settings.class);
            startActivity(i);
        }
    }

    //method to avoid the crash after going back to main menu
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(Settings.this, MainActivity.class);
        startActivity(intent);

    }
}
