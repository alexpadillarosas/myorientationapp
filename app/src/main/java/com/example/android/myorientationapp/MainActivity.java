package com.example.android.myorientationapp;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LandscapeFragment firstFragmentInstance = new LandscapeFragment();

//        FragmentTransaction firstFragmentTransaction = firstFragmentManager.beginTransaction();
//        firstFragmentTransaction.replace(R.id.content_main, firstFragmentInstance, "first_fragment_tag")
//                .addToBackStack(null)
//                .commit();

        //helps use work with fragments in an activity
        FragmentManager fragmentManager = getSupportFragmentManager();
        //add, attach, detach,remove, replace, animate, transition or show/hide
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //lets us access/change config relating to the app/device/etc
        Configuration configuration = getResources().getConfiguration();

        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            LandscapeFragment landscapeFragment = new LandscapeFragment();
            fragmentTransaction.replace(R.id.content_main, landscapeFragment);
        }
        else
        {
            PortraitFragment portraitFragment = new PortraitFragment();
            fragmentTransaction.replace(R.id.content_main, portraitFragment);
        }
        fragmentTransaction.commit();
    }


}
