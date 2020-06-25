package com.droidtech.ridetorise.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class Consultancy extends Fragment {
    RelativeLayout header;
    LinearLayout descLayout;
    TextView descText;
    ImageView arrowUp;

    public Consultancy() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consultancy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        header = view.findViewById(R.id.header);
        descLayout = view.findViewById(R.id.desc_layout);
        descText = view.findViewById(R.id.desc_text);
        arrowUp = view.findViewById(R.id.arrow_btn);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandeOrCollapse(descLayout, descText, arrowUp);
            }
        });
    }

    private void expandeOrCollapse(LinearLayout linearLayout, TextView textView, ImageView imageView) {
        if (linearLayout.getVisibility() == View.GONE) {
            linearLayout.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(getContext().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        } else {
            linearLayout.setVisibility(View.GONE);
            imageView.setImageDrawable(getContext().getDrawable(R.drawable.rkt_arrow_down_icon));
        }
        ObjectAnimator animation = ObjectAnimator.ofInt(textView, "maxLines", textView.getMaxLines());
        animation.setDuration(200).start();
    }
}
