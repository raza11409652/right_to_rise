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
import androidx.fragment.app.Fragment;

import com.droidtech.ridetorise.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Training extends Fragment {

    RelativeLayout posh100Header, posh101Header, posh102Header, posh103Header;
    LinearLayout posh100Desc, posh101Desc, posh102Desc, posh103Desc;
    ImageView posh100Arrow, posh101Arrow, posh102Arrow, posh103Arrow;

    public Training() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_training, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        posh100Header = view.findViewById(R.id.header_posh_100);
        posh100Arrow = view.findViewById(R.id.arrow_posh_100);
        posh100Desc = view.findViewById(R.id.posh_100_desc);

        /**
         * 101
         */
        posh101Header = view.findViewById(R.id.posh_101_header);
        posh101Desc = view.findViewById(R.id.posh_101_desc);
        posh101Arrow = view.findViewById(R.id.posh_101_arrow);
        /**
         * 102
         */
        posh102Header = view.findViewById(R.id.posh_102_header);
        posh102Arrow = view.findViewById(R.id.posh_102_arrow);
        posh102Desc = view.findViewById(R.id.posh_102_desc);

        /**
         * 103
         */
        posh103Header = view.findViewById(R.id.posh_103_header);
        posh103Desc = view.findViewById(R.id.posh_103_desc);
        posh103Arrow = view.findViewById(R.id.posh_103_arrow);

        posh100Header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expend(posh100Arrow, posh100Desc);
            }
        });

        posh101Header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expend(posh101Arrow, posh101Desc);
            }
        });
        posh102Header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expend(posh102Arrow, posh102Desc);
            }
        });
        posh103Header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expend(posh103Arrow, posh103Desc);
            }
        });
    }

    private void expend(ImageView image, LinearLayout layout) {
        if (layout.getVisibility() == View.GONE) {
            layout.setVisibility(View.VISIBLE);
            image.setImageDrawable(getContext().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        } else {
            layout.setVisibility(View.GONE);
            image.setImageDrawable(getContext().getDrawable(R.drawable.rkt_arrow_down_icon));
        }
    }


}
