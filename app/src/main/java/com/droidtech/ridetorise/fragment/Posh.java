package com.droidtech.ridetorise.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidtech.ridetorise.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Posh extends Fragment {

    public Posh() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posh, container, false); ;
        return view ;
    }
}
