package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.AdapterProductsList;
import com.example.bydelivery_app.MainActivity;
import com.example.bydelivery_app.R;
import com.example.bydelivery_app.handlers.FragmentChangeListener;

import java.util.ArrayList;

public class ProductsFragment extends Fragment {

    private static final String TAG = "ProductsFragment";

    private static View rootView;
    private ArrayList<String> productNames = new ArrayList<>();
    private ArrayList<String> productSellers = new ArrayList<>();
    private ArrayList<Integer> productImages = new ArrayList<>();
    private ArrayList<Double> productPrices = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        rootView = view;

        initRecyclerMap();

        return view;

    }

    private void initRecyclerMap(){

        productImages.clear();
        productNames.clear();
        productSellers.clear();
        productPrices.clear();

        productImages.add(R.drawable.binafa_banner);
        productNames.add("Bifana");
        productSellers.add("Restaurante do Sole");
        productPrices.add(7.50);

        productImages.add(R.drawable.hamburguer_banner);
        productNames.add("Hamburguer");
        productSellers.add("Burger Classic");
        productPrices.add(5.19);

        productImages.add(R.drawable.gelados_banner);
        productNames.add("Gelados");
        productSellers.add("Artisani");
        productPrices.add(1.99);

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recycler = rootView.findViewById(R.id.recycler_view);

        AdapterProductsList adapter = new AdapterProductsList(getContext(), productNames, productSellers, productPrices, productImages);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    public static void openProduct(String productName, String productSeller, int productImage, double productPrice){

        MainActivity main = (MainActivity) rootView.getContext();
        ProductDetailsFragment productDetailsFragment = new ProductDetailsFragment();

        productDetailsFragment.applyChanges(productName, productSeller, productImage, productPrice);

        Fragment fr = productDetailsFragment;
        FragmentChangeListener fc = (FragmentChangeListener) rootView.getContext();
        fc.replaceFragment(fr);

    }

}
