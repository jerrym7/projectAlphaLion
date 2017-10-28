package com.example.stude.projectalphalion;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

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
}
