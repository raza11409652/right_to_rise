package com.droidtech.ridetorise.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
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
import com.droidtech.ridetorise.fragment.Contact_fragment;
import com.droidtech.ridetorise.fragment.Downloads;
import com.droidtech.ridetorise.fragment.HomeFragment;
import com.droidtech.ridetorise.fragment.Posh;
import com.droidtech.ridetorise.fragment.Training;
import com.droidtech.ridetorise.fragment.VideosFragment;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {
    FrameLayout homeFragmentHolder;
    HomeFragment homeFragment;
    DrawerLayout drawerLayout;
    ImageView logo_header;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    Toolbar toolbar;
    LinearLayout customView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.parent_drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        customView = new LinearLayout(this);
        customView.setOrientation(LinearLayout.VERTICAL);
        textView = new TextView(this);
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
        homeFragmentHolder = findViewById(R.id.frame_layout_holder);
        homeFragment = new HomeFragment();
        updateUi(homeFragment);
        setTitle("");

        logo_header = new ImageView(this);

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
                    case R.id.home:
                        updateUi(new HomeFragment());
                        changeToNormal(toolbar);
                        break;
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
        toolbar.removeView(customView);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void changeThemeToCustom(Toolbar toolbar, String headerText) {
        toolbar.setBackgroundColor(getColor(R.color.colorPrimaryDark));
        toolbar.setElevation((float) 10.0);

        textView.setTextColor(getColor(R.color.colorAccent));
        if (toolbar.getChildCount() > 1) {
            toolbar.removeView(customView);
            customView.removeAllViews();
        }
        toolbar.addView(customView);

        customView.addView(logo_header);
        customView.setPadding(10, 10, 10, 10);

        logo_header.setImageDrawable(getDrawable(R.drawable.text_logo));

        customView.addView(textView);
        textView.setText(headerText);
        textView.setTextSize((float) 24.0);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

    private void closeDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    private void updateUi(Fragment fragment) {
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
}
