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
public class Posh extends Fragment {
    RelativeLayout headerBarePoshAct, headerBareAct, headerSummaryAct, headerQna;
    TextView descBarePoshAct, descBareAct, descSummaryAct, descQna;
    ImageView arrowBarePoshAct, arrowBareAct, arrowSummaryAct, arrowQna;
    LinearLayout dataLayoutRule;

    public Posh() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posh, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        headerBarePoshAct = view.findViewById(R.id.header_bre_posh_act);
        descBarePoshAct = view.findViewById(R.id.bare_posh_act_txt);
        arrowBarePoshAct = view.findViewById(R.id.arrow_bare_posh_act);

        headerBareAct = view.findViewById(R.id.header_bare_act);
        descBareAct = view.findViewById(R.id.desc_bare_act);
        arrowBareAct = view.findViewById(R.id.arrow_bare_act);
        dataLayoutRule = view.findViewById(R.id.data_layout);


        headerSummaryAct = view.findViewById(R.id.header_summary_act);
        arrowSummaryAct = view.findViewById(R.id.arrow_summry_act);
        descSummaryAct = view.findViewById(R.id.desc_summary_act);


        headerQna = view.findViewById(R.id.header_qna);
        descQna = view.findViewById(R.id.desc_qna);
        arrowQna = view.findViewById(R.id.arrow_qna);


        headerQna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapse(descQna, arrowQna);
            }
        });


        headerBarePoshAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapse(descBarePoshAct, arrowBarePoshAct);
            }
        });

        headerBareAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapseWithLayout(descBareAct, arrowBareAct, dataLayoutRule);
            }
        });
        headerSummaryAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collapse(descSummaryAct, arrowSummaryAct);
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

    private void collapseWithLayout(TextView textView, ImageView arrowAboutUs, LinearLayout linearLayout) {
        if (linearLayout.getVisibility() == View.GONE) {
            linearLayout.setVisibility(View.VISIBLE);
            arrowAboutUs.setImageDrawable(getContext().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        } else {
            linearLayout.setVisibility(View.GONE);
            arrowAboutUs.setImageDrawable(getContext().getDrawable(R.drawable.rkt_arrow_down_icon));
        }
        ObjectAnimator animation = ObjectAnimator.ofInt(textView, "maxLines", textView.getMaxLines());
        animation.setDuration(200).start();


    }
}
