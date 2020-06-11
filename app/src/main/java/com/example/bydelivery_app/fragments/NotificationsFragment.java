package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.adapters.AdapterNotificationsList;
import com.example.bydelivery_app.handlers.RecyclerValuesStorage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NotificationsFragment extends Fragment {

    private View rootView;
    private RecyclerView recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notifications, null);
        FloatingActionButton btnClear = view.findViewById(R.id.notificationsClearBtn);

        rootView = view;

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (recycler.getAdapter().getItemCount() != 0) {
                    Toast.makeText(getContext(), "Notificações limpas", Toast.LENGTH_SHORT).show();
                }

                RecyclerValuesStorage.getNotificationsImages().clear();
                RecyclerValuesStorage.getNotificationsTitles().clear();
                RecyclerValuesStorage.getNotificationsBodyStrings().clear();
                RecyclerValuesStorage.getNotificationsHours().clear();

                recycler.getAdapter().notifyDataSetChanged();
                rootView.findViewById(R.id.notificationsLayout3).setVisibility(View.VISIBLE);
                rootView.findViewById(R.id.notificationsLayout3).bringToFront();

            }
        });

        initRecyclerView();

        return view;
    }

    private void initRecyclerView(){
        RecyclerView recycler = rootView.findViewById(R.id.notificationsRecyclerView);
        AdapterNotificationsList adapter = new AdapterNotificationsList();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        this.recycler = recycler;

        if (adapter.getItemCount() > 0) {
            rootView.findViewById(R.id.notificationsLayout3).setVisibility(View.INVISIBLE);
        }

    }

}
