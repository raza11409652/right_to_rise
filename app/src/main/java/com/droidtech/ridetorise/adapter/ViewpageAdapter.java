package com.droidtech.ridetorise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.droidtech.ridetorise.R;
import com.droidtech.ridetorise.modal.Sliding;

import java.util.ArrayList;

public class ViewpageAdapter extends PagerAdapter {
    Context context  ;
    ArrayList<Sliding>list  ;

    public ViewpageAdapter(Context context, ArrayList<Sliding> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.single_text, collection, false);
        TextView text  = layout.findViewById(R.id.slide_txt) ;
        text.setText(list.get(position).getString());
        ((ViewPager)collection).addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
