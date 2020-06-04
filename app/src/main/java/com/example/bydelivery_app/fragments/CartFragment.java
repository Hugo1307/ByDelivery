package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.AdapterCartList;
import com.example.bydelivery_app.R;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    private static final String TAG = "CartFragment";
    private static View v;
    private ArrayList<String> productNames = new ArrayList<>();
    private ArrayList<String> productSellers = new ArrayList<>();
    private ArrayList<Integer> productImages = new ArrayList<>();
    private ArrayList<Double> productPrices = new ArrayList<>();
    private ArrayList<Integer> productQuantityList = new ArrayList<>();
    AdapterCartList adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, null);
        v = view;

        Log.d(TAG, "onCreate: started");

        initRecyclerView();

        return view;
    }

    /*
    private void addProductsToCart(){

        productImages.add(R.drawable.binafa_banner);
        productNames.add("Bifana");
        productSellers.add("Restaurante do Sol");
        productPrices.add(7.50);
        productQuantityList.add(1);

        productImages.add(R.drawable.hamburguer_banner);
        productNames.add("Hamburguer");
        productSellers.add("Burger Classic");
        productPrices.add(5.19);
        productQuantityList.add(1);

        initRecyclerView();

    }
    */

    public static void updatePriceEvaluation(double totalPrice,double deliveryPrice, double iva, double productsTotalPrice){

        Log.d(TAG, "updatePriceEvaluation: called");
        
        TextView labelTotalPrice = v.findViewById(R.id.label_totalPrice);
        TextView labelDeliveryPrice = v.findViewById(R.id.label_entregaPrice);
        TextView labelIvaPrice = v.findViewById(R.id.label_totalIVA);
        TextView labelProductsPrice = v.findViewById(R.id.label_productsTotalPrice);

        labelTotalPrice.setText(v.getContext().getString(R.string.totalPrice, String.valueOf(totalPrice)));
        labelDeliveryPrice.setText(v.getContext().getString(R.string.deliveyPrice, String.valueOf(deliveryPrice)));
        labelIvaPrice.setText(v.getContext().getString(R.string.ivaPrice, String.valueOf(iva)));
        labelProductsPrice.setText(v.getContext().getString(R.string.totalProductsPrice, String.valueOf(productsTotalPrice)));

        if (productsTotalPrice == 0) {
            v.findViewById(R.id.emptyCart).setVisibility(View.VISIBLE);
            v.findViewById(R.id.recycler_view).setVisibility(View.INVISIBLE);
        }else{
            v.findViewById(R.id.emptyCart).setVisibility(View.INVISIBLE);
            v.findViewById(R.id.recycler_view).setVisibility(View.VISIBLE);
        }

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recycler = v.findViewById(R.id.recycler_view);
        adapter = new AdapterCartList(getContext(), productNames, productSellers, productPrices, productQuantityList, productImages);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        updatePriceEvaluation(0, 0, 0, 0);
    }

    ///////////////////////////////////////////////////////////
    //                  GETTERS E SETTERS                    //
    ///////////////////////////////////////////////////////////

    void addProduct(String productName, String productSeller, int productImage, double productPrice, int productQuantity){

        if (productNames.contains(productName)) {

            int productIndex = productNames.indexOf(productName);
            int currentQuantity = productQuantityList.get(productIndex);

            if (productSellers.get(productIndex).equals(productSeller)) {
                currentQuantity = currentQuantity + productQuantity;
                productQuantityList.set(productIndex, currentQuantity);
            }

        }else{
            this.productNames.add(productName);
            this.productSellers.add(productSeller);
            this.productImages.add(productImage);
            this.productPrices.add(productPrice);
            this.productQuantityList.add(productQuantity);
        }

    }


}
