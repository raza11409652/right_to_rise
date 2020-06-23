package com.droidtech.ridetorise.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.droidtech.ridetorise.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Downloads extends Fragment {
    RelativeLayout headerGoverment;
    LinearLayout childViewGoverment;
    TextView govermentDownloadDesc;


    public Downloads() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_downloads, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        headerGoverment = view.findViewById(R.id.header);
        childViewGoverment = view.findViewById(R.id.line);
        govermentDownloadDesc = view.findViewById(R.id.gover_downloads_text);
        headerGoverment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapseExpandTextView();
            }
        });

    }

    void collapseExpandTextView() {
        if (childViewGoverment.getVisibility() == View.GONE) {
            childViewGoverment.setVisibility(View.VISIBLE);
//            Log.d("TAG", "collapseExpandTextView: shdhjdsf");
//            mDescriptionImg.setImageResource(R.drawable.ic_expand_less_black_24dp);
        } else {
            // it's expanded - collapse it
            childViewGoverment.setVisibility(View.GONE);
//            mDescriptionImg.setImageResource(R.drawable.ic_expand_more_black_24dp);
        }

        ObjectAnimator animation = ObjectAnimator.ofInt(govermentDownloadDesc, "maxLines", govermentDownloadDesc.getMaxLines());
        animation.setDuration(200).start();
    }
}
