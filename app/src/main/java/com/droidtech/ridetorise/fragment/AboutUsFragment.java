package com.droidtech.ridetorise.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.droidtech.ridetorise.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {
    Toolbar toolbar;

    RelativeLayout headerOurCompany, headerOurTeam;
    LinearLayout descOurCompany, descOurTeam;
    ImageView arrowOurCompany, arrowOurTeam;

    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headerOurCompany = view.findViewById(R.id.header_our_company);
        descOurCompany = view.findViewById(R.id.desc_our_company);
        arrowOurCompany = view.findViewById(R.id.arrow_our_company);

        /**
         * Team
         */
        headerOurTeam = view.findViewById(R.id.header);
        arrowOurTeam = view.findViewById(R.id.arrow_btn);
        descOurTeam = view.findViewById(R.id.desc_layout);


        headerOurCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand(descOurCompany, arrowOurCompany);
            }
        });
        headerOurTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expand(descOurTeam, arrowOurTeam);
            }
        });

    }

    private void expand(LinearLayout linearLayout, ImageView imageView) {
        if (linearLayout.getVisibility() == View.GONE) {

            linearLayout.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(getContext().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));

        } else {
            linearLayout.setVisibility(View.GONE);
            imageView.setImageDrawable(getContext().getDrawable(R.drawable.rkt_arrow_down_icon));
        }
    }

}
