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
public class Downloads extends Fragment {
    RelativeLayout govermentHeader, generalHeader, additionalHeader, poshHeader;
    TextView govermentDesc, generalDesc, additionalDesc, poshDesc;
    ImageView govermentImage, generalImage, additionalImage, poshArror;


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
        govermentHeader = view.findViewById(R.id.header_goverment_download);
        govermentDesc = view.findViewById(R.id.goverment_desc);
        govermentImage = view.findViewById(R.id.arrow_image_goverment);

        generalHeader = view.findViewById(R.id.generel_header_download);
        generalImage = view.findViewById(R.id.general_arrow);
        generalDesc = view.findViewById(R.id.genrel_desc);

        additionalHeader = view.findViewById(R.id.additional_header);
        additionalDesc = view.findViewById(R.id.additional_desc);
        additionalImage = view.findViewById(R.id.additional_arrow);


        poshHeader = view.findViewById(R.id.posh_header);
        poshArror = view.findViewById(R.id.posh_arrow);
        poshDesc = view.findViewById(R.id.posh_desc);


        generalHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapseExpandTextView(generalDesc, generalImage);
            }
        });


        govermentHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                collapseExpandTextView(govermentDesc, govermentImage);
            }
        });

        additionalHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapseExpandTextView(additionalDesc, additionalImage);
            }
        });
        poshHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapseExpandTextView(poshDesc, poshArror);
            }
        });


    }

    void collapseExpandTextView(TextView textView, ImageView imageView) {
//        if (childViewGoverment.getVisibility() == View.GONE) {
//            childViewGoverment.setVisibility(View.VISIBLE);
////            Log.d("TAG", "collapseExpandTextView: shdhjdsf");
////            mDescriptionImg.setImageResource(R.drawable.ic_expand_less_black_24dp);
//        } else {
//            // it's expanded - collapse it
//            childViewGoverment.setVisibility(View.GONE);
////            mDescriptionImg.setImageResource(R.drawable.ic_expand_more_black_24dp);
//        }
//

        if (textView.getVisibility() == View.GONE) {
            textView.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(getContext().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        } else {
            textView.setVisibility(View.GONE);
            imageView.setImageDrawable(getContext().getDrawable(R.drawable.rkt_arrow_down_icon));

        }
        ObjectAnimator animation = ObjectAnimator.ofInt(textView, "maxLines", textView.getMaxLines());
        animation.setDuration(200).start();

    }
}
