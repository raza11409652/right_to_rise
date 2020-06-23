package com.droidtech.ridetorise.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.droidtech.ridetorise.R;
import com.droidtech.ridetorise.utils.CustomAlert;

public class ContactUs extends AppCompatActivity {

    CustomAlert alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        /**
         * Header will be Added after
         */
        alert = new CustomAlert(this);
        alert.show("HELLO Form Submitted", "HEADING");


    }
}
