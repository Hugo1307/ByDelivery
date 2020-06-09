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

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.adapters.AdapterProductsList;
import com.example.bydelivery_app.handlers.FragmentChangeListener;
import com.example.bydelivery_app.handlers.ProductsList;
import com.example.bydelivery_app.handlers.Produto;

import java.util.List;

public class ProductsFragment extends Fragment {

    private static final String TAG = "ProductsFragment";

    private static View rootView;
    private List<Produto> productsList = ProductsList.getAllProducts();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        rootView = view;

        initRecyclerView();

        return view;
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recycler = rootView.findViewById(R.id.recycler_view);

        AdapterProductsList adapter = new AdapterProductsList(productsList);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    public static void openProduct(Produto p){

        Fragment fr = new ProductDetailsFragment(p);
        FragmentChangeListener fc = (FragmentChangeListener) rootView.getContext();
        fc.replaceFragment(fr);

    }

}
