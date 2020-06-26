package com.droidtech.ridetorise.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.droidtech.ridetorise.R;
import com.droidtech.ridetorise.fragment.AboutUsFragment;
import com.droidtech.ridetorise.fragment.Consultancy;
import com.droidtech.ridetorise.fragment.Contact_fragment;
import com.droidtech.ridetorise.fragment.Downloads;
import com.droidtech.ridetorise.fragment.Foundation;
import com.droidtech.ridetorise.fragment.HomeFragment;
import com.droidtech.ridetorise.fragment.Posh;
import com.droidtech.ridetorise.fragment.Training;
import com.droidtech.ridetorise.fragment.VideosFragment;
import com.droidtech.ridetorise.utils.TypeFaceUtils;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {
    FrameLayout homeFragmentHolder;
    HomeFragment homeFragment;
    DrawerLayout drawerLayout;
    ImageView logo_header;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    Toolbar toolbar;
    TextView headerText;
    LinearLayout customLayout;
    View headerBottom;
    Activity activity;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            TypeFaceUtils.overrideFont(getApplicationContext(), "SERIF", "fonts/font.ttf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentView(R.layout.activity_home);
        activity = this;
        drawerLayout = findViewById(R.id.parent_drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);


//        actionbar.setIcon(getDrawable(R.drawable.rkt_menu_ison));
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView = findViewById(R.id.nav);
        View headerView = navigationView.getHeaderView(0);
        try {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.rkt_menu_ison, getTheme());
            actionBarDrawerToggle.setHomeAsUpIndicator(drawable);

        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * Init views
         *
         */
        headerBottom = LayoutInflater.from(getApplicationContext()).inflate(R.layout.header_layout_logo, null, false);
        homeFragmentHolder = findViewById(R.id.frame_layout_holder);
        homeFragment = new HomeFragment();
        updateUi(homeFragment);
        setTitle("");
        toolbar.setNavigationIcon(getDrawable(R.drawable.menu_icon_));
        customLayout = new LinearLayout(this);
        customLayout.setOrientation(LinearLayout.VERTICAL);
        logo_header = new ImageView(this);
        logo_header.setImageDrawable(getDrawable(R.drawable.text_logo));
        logo_header.setPadding(0, 20, 0, 20);
        logo_header.setMaxHeight(18);
        headerText = new TextView(this);
        headerText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerText.setAllCaps(true);
        headerText.setTextColor(getColor(R.color.colorAccent));
        headerText.setTextSize((float) 18.0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                closeDrawer();
                switch (item.getItemId()) {
                    case R.id.videos:

                        updateUi(new VideosFragment());
                        changeThemeToCustom(toolbar, getString(R.string.videos));

                        break;
//                    case R.id.home:
//                        updateUi(new HomeFragment());
//                        changeToNormal(toolbar);
//                        break;
                    case R.id.contact:
                        changeThemeToCustom(toolbar, getString(R.string.contact_us));
                        updateUi(new Contact_fragment());
                        break;
                    case R.id.download:
                        updateUi(new Downloads());
                        changeThemeToCustom(toolbar, getString(R.string.download));
                        break;
                    case R.id.posh:
                        updateUi(new Posh());
                        changeThemeToCustom(toolbar, getString(R.string.posh));
                        break;
                    case R.id.training:
                        changeThemeToCustom(toolbar, getString(R.string.training));
                        updateUi(new Training());
                        break;
                    case R.id.consulting:
                        changeThemeToCustom(toolbar, getString(R.string.consulting));
                        updateUi(new Consultancy());
                        break;
                    case R.id.about:
                        changeThemeToCustom(toolbar, getString(R.string.about_us));
                        updateUi(new AboutUsFragment());
                        break;
                    case R.id.rkt_foundation:
                        changeThemeToCustom(toolbar, getString(R.string.rkt_foundation));
                        updateUi(new Foundation());
                        break;
                }

                return true;
            }
        });

    }

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void changeToNormal(Toolbar toolbar) {
        toolbar.setBackgroundColor(getColor(R.color.transparent));
        toolbar.setElevation((float) 0.0);
        Log.d("TAG", "changeToNormal: custom " + customLayout.getChildCount());
        if (customLayout.getChildCount() > 0) {
            toolbar.removeView(customLayout);
            if (customLayout.getChildCount() > 0) {
                customLayout.removeAllViews();
            }
        } else {
            Log.d("TAG", "changeToNormal: " + toolbar.getChildCount());
            try{
                toolbar.removeViewAt(2);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        MenuItem item = navigationView.getCheckedItem();
        try {
            item.setChecked(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getApplication().setTheme(R.style.NoActionBar);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void changeThemeToCustom(Toolbar toolbar, String text) {
        toolbar.setBackgroundColor(getColor(R.color.colorPrimaryDark));
        toolbar.setElevation((float) 10.0);

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

        toolbar.setBackgroundColor(getColor(R.color.grey_back));
//        activity.setTheme(R.style.NoActionBarGrey);


    }

    private void closeDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    public void updateUi(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(homeFragmentHolder.getId(), fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
        changeToNormal(toolbar);
        updateUi(new HomeFragment());

    }


}
