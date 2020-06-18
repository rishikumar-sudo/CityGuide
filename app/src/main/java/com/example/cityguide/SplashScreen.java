package com.example.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Annotation;

public class SplashScreen extends AppCompatActivity {
private  static  int SPLASH_TIMER=5000;
Animation sideanim,bottomanim;
ImageView imageView;
TextView powerbyline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                Intent intent=new Intent(SplashScreen.this,UserDashboard.class);
                startActivity(intent);

            }
        },SPLASH_TIMER);
    }




}