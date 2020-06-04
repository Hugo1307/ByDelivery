package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bydelivery_app.MainActivity;
import com.example.bydelivery_app.R;

import java.util.Calendar;
import java.util.Date;

public class ProductDetailsFragment extends Fragment {

    private static final String TAG = "ProductDetailsFragment";
    private View rootView;
    
    private String productName;
    private String productSeller;
    private int productImage;
    private double productPrice;

    public ProductDetailsFragment () {

        this.productName = "[ProductName]";
        this.productSeller = "[ProductSeller]";
        this.productImage = R.drawable.azul_login_waved;
        this.productPrice = 0;

    }

    public void applyChanges(String productName, String productSeller, int productImage, double productPrice){
        this.productName = productName;
        this.productSeller = productSeller;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_productdetails, null);

        ImageView imageProductImg = view.findViewById(R.id.productDetailsBannerImg);
        TextView labelproductSeller = view.findViewById(R.id.productDetailsSeller);
        final Date currentTime = Calendar.getInstance().getTime();

        rootView = view;
        imageProductImg.setImageResource(productImage);
        labelproductSeller.setText(productSeller);

        view.findViewById(R.id.productDetailsBuyNowBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: button clicked");

                ((MainActivity) getActivity()).getCartFragment().addProduct(productName, productSeller, productImage, productPrice,
                        1);

                MainActivity.addNotification(productImage, productName,
                        "Novo produto adicionado ao carrinho", currentTime.getHours() + ":" + String.format("%02d", currentTime.getMinutes()));
            }
        });

        return view;
    }



}
