package com.droidtech.ridetorise.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.droidtech.ridetorise.R;
import com.droidtech.ridetorise.adapter.VideosAdapter;
import com.droidtech.ridetorise.modal.Videos;

import java.util.ArrayList;

public class VideosService extends AppCompatActivity {
    ArrayList<Videos> list;
    RecyclerView videosListHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_service);
        /**
         * Init views
         */
        videosListHolder = findViewById(R.id.videos_list_holder);
        videosListHolder.setHasFixedSize(true);
        getVideoList();
    }

    private void getVideoList() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Videos videos = new Videos("Title" + i, "Image Url", "Video url");
            list.add(videos);
        }
        setAdapter(list);


    }

    private void setAdapter(ArrayList<Videos> list) {
        VideosAdapter adapter = new VideosAdapter(this, list);
        videosListHolder.setAdapter(adapter);
        videosListHolder.setLayoutManager(new LinearLayoutManager(this));

    }
}
