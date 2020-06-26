package com.droidtech.ridetorise.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.droidtech.ridetorise.R;
import com.droidtech.ridetorise.modal.Sliding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    CardView aboutUs, training, consulting, poshCard, rktFoundation, downloadCard, videosCard, contactCard;
    TextView headerText;
    LinearLayout customLayout;
    View headerBottom;
    ImageView logo_header;
    Toolbar toolbar;
    NavigationView navigationView;
    TextView slideText;
    Animation animation;
    ViewFlipper viewFlipper;
    ArrayList<Sliding> list = new ArrayList<>();
    String strSlide[] = {
            "Slide 1",
            "Slide 2",
            "Slide 3",
            "Slide 4",
            "Slide 5",

    };

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewFlipper = view.findViewById(R.id.viewFlipper);


        for (String slide : strSlide) {
            flipperText(slide);
        }
//        animation =AnimationUtils.loadAnimation(getContext(), R.anim.anim);
//        slideText.startAnimation(animation);
        headerBottom = LayoutInflater.from(getContext()).inflate(R.layout.header_layout_logo, null, false);
        customLayout = new LinearLayout(getContext());
        customLayout.setOrientation(LinearLayout.VERTICAL);
        logo_header = new ImageView(getContext());
        logo_header.setImageDrawable(getContext().getDrawable(R.drawable.text_logo));
        logo_header.setPadding(0, 20, 0, 20);
        logo_header.setMaxHeight(18);
        headerText = new TextView(getContext());
        headerText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerText.setAllCaps(true);
        headerText.setTextColor(getContext().getColor(R.color.colorAccent));
        headerText.setTextSize((float) 18.0);
        aboutUs = view.findViewById(R.id.about_card);
        training = view.findViewById(R.id.card_training);


        toolbar = getActivity().findViewById(R.id.toolbar);
        /**
         * Card viw init
         */

        consulting = view.findViewById(R.id.consulting_card) ;
        poshCard = view.findViewById(R.id.posh_card) ;
        rktFoundation = view.findViewById(R.id.rkt_foundation_card) ;
        downloadCard  = view.findViewById(R.id.download_card) ;
        videosCard = view.findViewById(R.id.card_vidoes) ;
        contactCard = view.findViewById(R.id.card_contact_us) ;

        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUi(new Training(), R.id.training, toolbar, getString(R.string.training));
            }
        });
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//        Fragment fragment = (Fragment) getFragmentManager().getFragments();

                updateUi(new AboutUsFragment(), R.id.about, toolbar, getString(R.string.about_us));


            }
        });
        consulting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUi(new Consultancy()  ,R.id.consulting , toolbar , getString(R.string.consulting));
            }
        });
        poshCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUi(new Posh()  ,R.id.posh , toolbar , getString(R.string.posh));

            }
        });
        rktFoundation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUi(new Foundation()  ,R.id.rkt_foundation , toolbar , getString(R.string.rkt_foundation));

            }
        });
        downloadCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUi(new Downloads()  , R.id.download , toolbar  , getString(R.string.download));
            }
        });
        videosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUi(new VideosFragment()  ,R.id.videos , toolbar , getString(R.string.videos));

            }
        });
        contactCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUi(new Contact_fragment()  ,R.id.contact , toolbar , getString(R.string.contact_us));

            }
        });



    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void flipperText(String slide) {
        TextView textView = new TextView(getContext());
        textView.setText(slide);
        textView.setTextColor(getContext().getColor(R.color.text_color));
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        viewFlipper.addView(textView);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);
        //animation
        viewFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
        viewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void updateUi(Fragment fragment, int index, Toolbar toolbar, String string) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_holder, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        navigationView = getActivity().findViewById(R.id.nav);
        navigationView.setCheckedItem(index);
        MenuItem item = navigationView.getCheckedItem();
        item.setChecked(true);
        changeThemeToCustom(toolbar, string);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void changeThemeToCustom(Toolbar toolbar, String text) {
        toolbar.setBackgroundColor(getContext().getColor(R.color.colorPrimaryDark));
        toolbar.setElevation((float) 20.0);

        if (toolbar.getChildCount() > 1) {
            toolbar.removeView(customLayout);
            customLayout.removeAllViews();
        }
        toolbar.addView(customLayout);
        customLayout.addView(logo_header);
        customLayout.addView(headerText);
        headerText.setText(text);
        customLayout.addView(headerBottom);
//        View view = customLayout.findViewById(R.id.txt);
//        view.setMinimumWidth(headerText.getMaxWidth());

        toolbar.setBackgroundColor(getContext().getColor(R.color.grey_back));
//        activity.setTheme(R.style.NoActionBarGrey);
//        MenuItem item =


    }


//    @SuppressLint("ResourceType")
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    private void changeToNormal(Toolbar toolbar) {
//        toolbar.setBackgroundColor(getContext().getColor(R.color.transparent));
//        toolbar.setElevation((float) 0.0);
//        if (customLayout.getChildCount() > 0) {
//            toolbar.removeView(customLayout);
//        }
//
//        MenuItem item = navigationView.getCheckedItem();
//        try {
//            item.setChecked(false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
////        getApplication().setTheme(R.style.NoActionBar);
//
//    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG ", "onResume: Resume");
        for (String slide : strSlide) {
            flipperText(slide);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

//        Log.d("TAG ", "onAttach: Attach fragment ");
//        for (String slide : strSlide) {
//            flipperText(slide);
//        }
    }
}
