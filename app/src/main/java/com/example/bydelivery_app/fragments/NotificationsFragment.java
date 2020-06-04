package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.AdapterNotificationsList;
import com.example.bydelivery_app.R;

public class NotificationsFragment extends Fragment {

    private static final String TAG = "NotificationsFragment";
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, null);
        rootView = view;

        Log.d(TAG, "onCreate: started");

        initRecyclerView();

        return view;
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recycler = rootView.findViewById(R.id.notificationsRecyclerView);
        AdapterNotificationsList adapter = new AdapterNotificationsList();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
