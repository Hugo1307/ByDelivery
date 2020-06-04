package com.example.bydelivery_app;

import android.content.Intent;
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
import com.example.bydelivery_app.fragments.ProductsFragment;
import com.example.bydelivery_app.fragments.ProfileFragment;
import com.example.bydelivery_app.handlers.FragmentChangeListener;
import com.example.bydelivery_app.handlers.RecyclerValuesStorage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends FragmentActivity implements FragmentChangeListener {

    private static final String TAG = "MainActivity";

    private Fragment currentFragment;
    private CartFragment cartFragment = new CartFragment();
    private ProductsFragment productsFragment = new ProductsFragment();

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
                        selectedFragment = cartFragment;
                        break;
                    case R.id.nav_notifications:
                        selectedFragment = new NotificationsFragment();
                        break;
                    default:
                        Log.d(TAG, "onNavigationItemSelected: unknown Fragment");
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
                return true;
            }
        };

    @Override
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }

    public static void addNotification(int image, String title, String body, String notificationTime) {

        RecyclerValuesStorage.getNotificationsImages().add(image);
        RecyclerValuesStorage.getNotificationsTitles().add(title);
        RecyclerValuesStorage.getNotificationsBodyStrings().add(body);
        RecyclerValuesStorage.getNotificationsHours().add(notificationTime);

        Log.d(TAG, "addNotification: added new notification");

    }

    public static void cleanNotifications(int image, String title, String body, String notificationTime) {

        RecyclerValuesStorage.getNotificationsImages().clear();
        RecyclerValuesStorage.getNotificationsTitles().clear();
        RecyclerValuesStorage.getNotificationsBodyStrings().clear();
        RecyclerValuesStorage.getNotificationsHours().clear();

    }

    /////////////////////////////////////////////////////////
    //                GETTERS E SETTERS                    //
    /////////////////////////////////////////////////////////

    public CartFragment getCartFragment(){ return this.cartFragment; }

    public ProductsFragment getProductsFragment() { return productsFragment; }

}