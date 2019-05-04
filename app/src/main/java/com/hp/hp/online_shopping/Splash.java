package com.hp.hp.online_shopping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int Userid;
       SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Splash.this);
        Userid= prefs.getInt("userid", 0);
        if(Userid>0){
            //go to home page
            Intent i = new Intent(getApplicationContext(),Login.class);
            startActivity(i);
            finish();
        }else{
            // Means  u are not logged in than go to your login pageview from here

            new Handler().postDelayed(new Runnable() {

                /*
                 * Showing splash screen with a timer. This will be useful when you
                 * want to show case your app logo / company
                 */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    //login page
                    Intent i = new Intent(getApplicationContext(),Login.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);


        }
    }
}
