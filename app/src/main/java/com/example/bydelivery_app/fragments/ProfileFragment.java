package com.example.bydelivery_app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bydelivery_app.R;

public class ProfileFragment extends Fragment {

    private static View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    /* nao consegui fazer
    EditText text = (EditText) v.findViewById(R.id.editTextId);
    PhoneNumberUtils.formatNumber(text.getText().toString());
    PhoneNumberUtils.compare(String a, String b);


    Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items_spinner, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);
    */

    public void terminarSessao(View v){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
}


