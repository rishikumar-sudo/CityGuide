package com.example.cityguide.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cityguide.R;

public class SliderAdapter extends PagerAdapter {


    LayoutInflater layoutInflater;
    Context context;
    ImageView imageView;
    private TextView textheading;
    private TextView textdesc;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    private  int img[]={R.drawable.search_place,R.drawable.make_a_call,R.drawable.add_missing_place,R.drawable.sit_back_and_relax};
    private  int heading[]={R.string.first_slide_title,R.string.second_slide_title,R.string.third_slide_title,R.string.fourth_slide_title};
    private   int desc[]={R.string.first_slide_desc,R.string.second_slide_desc,R.string.third_slide_desc,R.string.fourth_slide_desc};
    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(ConstraintLayout)object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)container);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slides_layout,container,false);
        imageView=view.findViewById(R.id.slider_image);
        textheading=view.findViewById(R.id.slider_heading);
        textdesc=view.findViewById(R.id.slider_desc);
        imageView.setImageResource(img[position]);
        textheading.setText(heading[position]);
        textdesc.setText(desc[position]);

      container.addView(view);
        return view;
    }
}
