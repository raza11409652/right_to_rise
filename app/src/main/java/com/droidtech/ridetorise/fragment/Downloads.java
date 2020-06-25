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
public class Downloads extends Fragment {
    RelativeLayout govermentHeader ;
    TextView govermentDesc ;
    ImageView govermentImage ;



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
        govermentHeader  =view.findViewById(R.id.header_goverment_download);
        govermentDesc  = view.findViewById(R.id.goverment_desc);
        govermentImage  = view.findViewById(R.id.arrow_image_goverment) ;
        govermentHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                collapseExpandTextView(govermentDesc ,govermentImage);
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

        if (textView.getVisibility()==View.GONE){
            textView.setVisibility(View.VISIBLE);
        }else{
            textView.setVisibility(View.GONE);

        }
        ObjectAnimator animation = ObjectAnimator.ofInt(textView, "maxLines", textView.getMaxLines());
        animation.setDuration(200).start();

    }
}
