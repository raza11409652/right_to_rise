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
    RelativeLayout header, headerAnnual, headerAdditionalDownload;
    LinearLayout descLayout, descAnnual, descAdditionalDownload;
    TextView descText;
    ImageView arrowUp, arrowAnnual, arrowAdditionalDownload;

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

        /**
         *
         */
        headerAnnual = view.findViewById(R.id.header_annual_consultancy);
        arrowAnnual = view.findViewById(R.id.arrow_annual_consultancy);
        descAnnual = view.findViewById(R.id.desc_annual_consultancy);


        headerAdditionalDownload = view.findViewById(R.id.additional_download_header);
        descAdditionalDownload = view.findViewById(R.id.additional_download_desc);
        arrowAdditionalDownload = view.findViewById(R.id.additional_download_arrow);


        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandeOrCollapse(descLayout, descText, arrowUp);
            }
        });

        headerAnnual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandeOrCollapse(descAnnual, descText, arrowAnnual);
            }
        });
        headerAdditionalDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandeOrCollapse(descAdditionalDownload, descText, arrowAdditionalDownload);
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
