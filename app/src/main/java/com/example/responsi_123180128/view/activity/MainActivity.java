package com.example.responsi_123180128.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.responsi_123180128.R;
import com.example.responsi_123180128.view.fragment.RsRujukanFragment;
import com.example.responsi_123180128.view.fragment.KasusCovidFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView navbar;
    private Fragment fragment = new KasusCovidFragment() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        navbar = findViewById(R.id.btm_nav);
        navbar.setOnNavigationItemSelectedListener(this);

        loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragmentcontainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menubtmnav_kasus:
                fragment = new KasusCovidFragment();
                break;

            case R.id.menubtmnav_rs:
                fragment = new RsRujukanFragment();
        }
        return loadFragment(fragment);
    }
}