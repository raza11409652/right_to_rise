package com.droidtech.ridetorise.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidtech.ridetorise.R;
import com.droidtech.ridetorise.adapter.VideosAdapter;
import com.droidtech.ridetorise.modal.Videos;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideosFragment extends Fragment {
    ArrayList<Videos> list;
    RecyclerView videosListHolder;

    public VideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_videos, container, false);
        return view ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        videosListHolder =view.findViewById(R.id.videos_list_holder);
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
        VideosAdapter adapter = new VideosAdapter(getContext(), list);
        videosListHolder.setAdapter(adapter);
        videosListHolder.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
