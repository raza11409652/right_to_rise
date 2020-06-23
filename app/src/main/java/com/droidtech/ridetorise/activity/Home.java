package com.droidtech.ridetorise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.droidtech.ridetorise.R;

public class Home extends AppCompatActivity {
    CardView contactUs, videosCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /**
         * Init views
         */
        contactUs = findViewById(R.id.card_contact_us);
        videosCard = findViewById(R.id.card_vidoes);

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent(getApplicationContext(), ContactUs.class);
                updateUi(contact);
            }
        });
        videosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videos = new Intent(getApplicationContext(), VideosService.class);
                updateUi(videos);
            }
        });

    }

    private void updateUi(Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
