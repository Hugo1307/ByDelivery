package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.adapters.AdapterParceirosList;

public class ParceirosFragment extends Fragment {

    private static final String TAG = "OrdersFragment";
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parceiros, null);
        rootView = view;

        Log.d(TAG, "onCreate: started");

        initRecyclerView();

        return view;
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recycler = rootView.findViewById(R.id.parceirosRecyclerView);
        AdapterParceirosList adapter = new AdapterParceirosList();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
