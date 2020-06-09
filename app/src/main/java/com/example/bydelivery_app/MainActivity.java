package com.example.bydelivery_app;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bydelivery_app.fragments.CartFragment;
import com.example.bydelivery_app.fragments.HomeFragment;
import com.example.bydelivery_app.fragments.NotificationsFragment;
import com.example.bydelivery_app.fragments.OrdersFragment;
import com.example.bydelivery_app.fragments.ParceirosFragment;
import com.example.bydelivery_app.fragments.ProfileFragment;
import com.example.bydelivery_app.handlers.FragmentChangeListener;
import com.example.bydelivery_app.handlers.OrdinaryMethods;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends FragmentActivity implements FragmentChangeListener {

    private static final String TAG = "MainActivity";

    private static Fragment currentFragment;

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

        OrdinaryMethods.addParceiro(R.drawable.burgerclassic_logo, "Burger Classic", "Um serviço de qualidade" ,2.1);

    }

    public void abrirPerfil(View v){

        replaceFragment(new ProfileFragment());

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
                    case R.id.nav_notifications:
                        selectedFragment = new NotificationsFragment();
                        break;
                    case R.id.nav_orders:
                        selectedFragment = new OrdersFragment();
                        break;
                    case R.id.nav_partners:
                        selectedFragment = new ParceirosFragment();
                        break;
                    default:
                        selectedFragment = new HomeFragment();
                        Log.d(TAG, "onNavigationItemSelected: unknown Fragment");
                        break;
                }
                replaceFragment(selectedFragment);
                return true;
            }
        };

    @Override
    public void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (currentFragment != null) {
            if (currentFragment.getClass() != fragment.getClass()) {
                fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        }
        fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();

        currentFragment = fragment;
    }

}