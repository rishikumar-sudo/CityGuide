package com.example.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cityguide.HelperClasses.FeaturedAdapter;
import com.example.cityguide.HelperClasses.FeaturedHelperClass;
import com.example.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {
    //Variables
    RecyclerView featuredRecycler,mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1,gradient2,gradient3,gradient4;

    //Drawer Menu
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderlogo, img2;
    private TextView txtName, textappname;
    private Toolbar toolbarr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        SharedPreferences sharedPreferences = getSharedPreferences("WelcomeScreen", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IsFirtTime",false);
        editor.apply();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbarr=findViewById(R.id.toolbar);
        setSupportActionBar(toolbarr);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbarr, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.navigation_view);
        // Navigation view header
        navHeader =  navigationView.getHeaderView(0);
        txtName = navHeader.findViewById(R.id.menu_slogan);
        textappname= navHeader.findViewById(R.id.app_name);
        imgNavHeaderlogo = navHeader.findViewById(R.id.logo);
        img2 = navHeader.findViewById(R.id.img2);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        // mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        //categoriesRecycler = findViewById(R.id.categories_recycler);


        //Menu Hooks
        setNavigationDrawer();




        //Recycler views function calls
        featuredRecycler();
        //mostViewedRecycler();
        //categoriesRecycler();
    }

    public void setNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_aboutus:
                        Toast.makeText(getApplicationContext(),"About Us",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_whyus:
                        Toast.makeText(getApplicationContext(),"WhyUs",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_subject:
                        Toast.makeText(getApplicationContext(),"Subject",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_setting:
                        Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_share:
                        Toast.makeText(getApplicationContext(),"Share",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_rateus:
                        Toast.makeText(getApplicationContext(),"rateus",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;


                }
                return  true;
            }
        });
    }

    //Recycler views functions

    //private void categoriesRecycler();

    //private void mostViewedRecycler();
    public void featuredRecycler(){
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.career_counselling,"Career Counselling", "Career Counselling is a process that focuses on helping one understand one’s own self, as well as work trends, so that one can take an informed decision about career and education."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.engaging_lect,"Engaging Lectures", "Through this students will get a chance to learn in lectures which are a blend of live and innovative classes including animations, videos and live experiments."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.book_store,"Book and Library Store", "Download free textE-books and books prescribed for students by our experts.."));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});


    }
}