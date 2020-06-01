package com.example.bydelivery_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.bydelivery_app.Handler.FragmentChangeListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends FragmentActivity implements FragmentChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottomMenu);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            bottomNav.setSelectedItemId(R.id.nav_home);
        }

    }

    public void abrirPerfil(View v){

        Intent intent = new Intent(getApplicationContext(), ProfileFragment.class);
        startActivity(intent);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_shop_cart:
                        selectedFragment = new CartFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
                return true;
            }
        };

    @Override
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }
}