package com.example.bydelivery_app;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartFragment extends Fragment {

    private static final String TAG = "CartFragment";
    private View v;
    private ArrayList<String> productNames = new ArrayList<>();
    private ArrayList<String> productSellers = new ArrayList<>();
    private ArrayList<Integer> productImages = new ArrayList<>();
    private ArrayList<Double> productPrices = new ArrayList<>();
    private ArrayList<Integer> productQuantityList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, null);
        v = view;

        Log.d(TAG, "onCreate: started");

        initImageBitMaps();

        return view;
    }

    private void initImageBitMaps(){

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

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recycler = v.findViewById(R.id.recycler_view);
        Adapter adapter = new Adapter(getContext(), productNames, productSellers, productPrices, productQuantityList, productImages);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void testeDeNome(@NotNull View v){

        productNames.remove(productNames.size()-1);

    }

}
