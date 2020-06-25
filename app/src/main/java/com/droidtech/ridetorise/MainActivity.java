package com.droidtech.ridetorise;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.droidtech.ridetorise.activity.Home;
import com.droidtech.ridetorise.utils.TypeFaceUtils;

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
        try {
            TypeFaceUtils.overrideFont(getApplicationContext(), "SERIF", "fonts/font.ttf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateUi(Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
