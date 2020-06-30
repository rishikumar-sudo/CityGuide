package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguide.HelperClasses.SliderAdapter;
import com.example.cityguide.R;
import com.example.cityguide.User.UserDashboard;

public class OnBoardingScreen extends AppCompatActivity {
    private SliderAdapter sliderAdapter;
    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    Button btnnext,btnskip;
    Button btnGetStarted;
    int currentPos;
    Animation animation;

TextView dots[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding_screen);
        viewPager=findViewById(R.id.view_pager);
         btnnext=findViewById(R.id.next_btn);
         btnskip=findViewById(R.id.skip_btn);
         btnGetStarted=findViewById(R.id.get_started_btn);
        dotsLayout =(LinearLayout) findViewById(R.id.dots);

        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDots(0);
       viewPager.addOnPageChangeListener(changeListener);
       viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
           @Override
           public void transformPage(View page, float position) {
               final float normalizedposition = Math.abs(Math.abs(position) - 1);
               page.setScaleX(normalizedposition / 2 + 0.5f);
               page.setScaleY(normalizedposition / 2 + 0.5f);
           }
       });

    }
    public void next(View view) {
        viewPager.setCurrentItem(currentPos + 1);
    }

    private void addDots(int position) {
        dots=new TextView[4];
        dotsLayout.removeAllViews();
        for (int i=0;i<dots.length;i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }
    public void skip(View view) {
        startActivity(new Intent(this, UserDashboard.class));
        finish();
    }
    ViewPager.OnPageChangeListener changeListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPos = position;

            if (position == 0) {
                btnGetStarted.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                btnGetStarted.setVisibility(View.INVISIBLE);
            } else if (position == 2) {
                btnGetStarted.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(OnBoardingScreen.this, R.anim.bottom_anim);
                btnGetStarted.setAnimation(animation);
                btnskip.setVisibility(View.INVISIBLE);
                btnGetStarted.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}