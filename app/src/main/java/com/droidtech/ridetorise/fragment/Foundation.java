package com.droidtech.ridetorise.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.droidtech.ridetorise.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Foundation extends Fragment {
    TextView aboutUsDesc, coreValueText;
    RelativeLayout headerAboutUs, coreValueHeader;
    ImageView arrowAboutUs, coreValueImage;


    public Foundation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_foundation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headerAboutUs = view.findViewById(R.id.header_about_us);
        aboutUsDesc = view.findViewById(R.id.about_us_text);
        arrowAboutUs = view.findViewById(R.id.arrow_about_us);
        coreValueHeader = view.findViewById(R.id.core_value_header);
        coreValueImage = view.findViewById(R.id.core_value_arrow);
        coreValueText = view.findViewById(R.id.core_value_txt);

        coreValueHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapse(coreValueText, coreValueImage);
            }
        });
        headerAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapse(aboutUsDesc, arrowAboutUs);
            }
        });

    }

    private void collapse(TextView aboutUsDesc, ImageView arrowAboutUs) {
        if (aboutUsDesc.getVisibility() == View.GONE) {
            aboutUsDesc.setVisibility(View.VISIBLE);
            arrowAboutUs.setImageDrawable(getContext().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        } else {
            aboutUsDesc.setVisibility(View.GONE);
            arrowAboutUs.setImageDrawable(getContext().getDrawable(R.drawable.rkt_arrow_down_icon));
        }
        ObjectAnimator animation = ObjectAnimator.ofInt(aboutUsDesc, "maxLines", aboutUsDesc.getMaxLines());
        animation.setDuration(200).start();


    }
}
