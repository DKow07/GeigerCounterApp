package com.kowalski.damian.geiger.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.kowalski.damian.geiger.R;
import com.kowalski.damian.geiger.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final Fragment homeFragment = new HomeFragment();

    private Fragment currentFragment;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        if (currentFragment == null) {
            setTitle(getString(R.string.home_label));
            switchFragment(homeFragment);
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home_action && currentFragment != homeFragment) {
                    currentFragment = homeFragment;
                    setTitle(getString(R.string.home_label));
                    switchFragment(currentFragment);
                    return true;
                } else if (id == R.id.results_action) {
                    currentFragment = null;
                    Toast.makeText(MainActivity.this, "placeholder", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }

    private void switchFragment(Fragment fragment) {
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }
}
