package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.adapters.AdapterOrdersList;
import com.example.bydelivery_app.handlers.Encomenda;
import com.example.bydelivery_app.handlers.EncomendasList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class OrdersFragment extends Fragment {

    private static final String TAG = "OrdersFragment";
    private View rootView;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onCreate: started");

        View view = inflater.inflate(R.layout.fragment_orders, null);
        final FloatingActionButton cancelOrdersBtn = view.findViewById(R.id.ordersCancelAll);
        final RecyclerView ordersRecycler = view.findViewById(R.id.ordersRecyclerView);
        rootView = view;

        cancelOrdersBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clearOrders(ordersRecycler);
                return true;
            }
        });

        cancelOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Mantenha pressionado para cancelar todas as encomendas";
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        initRecyclerView();

        return view;
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recycler = rootView.findViewById(R.id.ordersRecyclerView);
        AdapterOrdersList adapter = new AdapterOrdersList();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void clearOrders(RecyclerView ordersRecycler) {

        boolean canCancel = true;
        for (Encomenda e : EncomendasList.getListaEncomendas()) {
            if (e.getDeliveryState() != 1) {
                canCancel = false;
                break;
            }
        }

        if (canCancel) {
            EncomendasList.clear();
            Objects.requireNonNull(ordersRecycler.getAdapter()).notifyDataSetChanged();
        }else{
            Toast.makeText(getContext(), "Não é possível cancelar todas as encomendas", Toast.LENGTH_SHORT).show();
        }

    }

}
