package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguide.R;
import com.example.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
private  static  int SPLASH_TIMER=5000;
Animation sideanim,bottomanim;
ImageView imageView;
TextView powerbyline;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
       imageView=findViewById(R.id.imageView);
       powerbyline=findViewById(R.id.textView);
       sideanim= AnimationUtils.loadAnimation(this,R.anim.side_anim);
       bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
       imageView.setAnimation(sideanim);
       powerbyline.setAnimation(bottomanim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences("WelcomeScreen", MODE_PRIVATE);

               if( sharedPreferences.getBoolean("IsFirtTime",true))
                {
                    Intent intent=new Intent(SplashScreen.this, OnBoardingScreen.class);
                    startActivity(intent);
                }else
               {
                   Intent intent=new Intent(SplashScreen.this, UserDashboard.class);
                   startActivity(intent);
               }


            }
        },SPLASH_TIMER);
    }




}