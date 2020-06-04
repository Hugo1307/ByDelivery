package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.handlers.FragmentChangeListener;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RelativeLayout categoryLayout1 = view.findViewById(R.id.category1);

        categoryLayout1.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: clicked");

                Fragment fr = new ProductsFragment();
                FragmentChangeListener fc = (FragmentChangeListener) getActivity();
                fc.replaceFragment(fr);
            }
        });

        return view;

    }

}
