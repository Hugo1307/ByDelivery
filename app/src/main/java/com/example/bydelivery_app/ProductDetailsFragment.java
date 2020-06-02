package com.example.bydelivery_app;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ProductDetailsFragment extends Fragment {

    private static final String TAG = "ProductDetailsFragment";
    private View rootView;
    
    private String productName = "Bifana";
    private String productSeller = "Bifanas & Co.";
    private int productImage = R.drawable.binafa_banner;
    private double productPrice = 5.55;
    private int productQuantity = 2;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_productdetails, null);
        rootView = view;

        view.findViewById(R.id.productDetailsBuyNowBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: button clicked");

                ((MainActivity) getActivity()).getCartFragment().addProduct(productName, productSeller, productImage, productPrice,
                        productQuantity);
            }
        });

        return view;
    }



}
