package com.droidtech.ridetorise;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.droidtech.ridetorise.activity.Home;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * This will work as router for app
         */
        Intent home = new Intent(getApplicationContext(), Home.class);
        updateUi(home);
//        startActivity(intent);
    }

    private void updateUi(Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
