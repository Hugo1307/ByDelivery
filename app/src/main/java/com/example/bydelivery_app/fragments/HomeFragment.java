package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.handlers.ContasList;
import com.example.bydelivery_app.handlers.FragmentChangeListener;
import com.example.bydelivery_app.handlers.Pesquisa;
import com.example.bydelivery_app.handlers.ProductsList;

public class HomeFragment extends Fragment {
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RelativeLayout comidaLayout = view.findViewById(R.id.category1);
        RelativeLayout roupaLayout = view.findViewById(R.id.category2);
        RelativeLayout farmaciaLayout = view.findViewById(R.id.category3);
        RelativeLayout tecnologiaLayout = view.findViewById(R.id.category4);
        RelativeLayout papelariaLayout = view.findViewById(R.id.category5);
        RelativeLayout eletronicosLayout = view.findViewById(R.id.category6);
        RelativeLayout exercicio = view.findViewById(R.id.category7);
        RelativeLayout outrosLayout = view.findViewById(R.id.category8);
        final AutoCompleteTextView searchBar = view.findViewById(R.id.homeSearchBar);
        ImageView searchButton = view.findViewById(R.id.homeSearchButton);
        TextView moradaLabel = view.findViewById(R.id.homeMoradaLabel);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_expandable_list_item_1, ProductsList.getAllProductsNames());


        searchBar.setAdapter(adapter);

        moradaLabel.setText(ContasList.getCurrentAccount().getMorada());

        comidaLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Fragment fr = new ProductsFragment(ProductsList.getComida(), "Comida");
                FragmentChangeListener fc = (FragmentChangeListener) getActivity();
                fc.replaceFragment(fr);
            }
        });

        roupaLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Fragment fr = new ProductsFragment(ProductsList.getRoupa(), "Roupa");
                FragmentChangeListener fc = (FragmentChangeListener) getActivity();
                fc.replaceFragment(fr);
            }
        });

        farmaciaLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Fragment fr = new ProductsFragment(ProductsList.getFarmacia(), "Farmácia");
                FragmentChangeListener fc = (FragmentChangeListener) getActivity();
                fc.replaceFragment(fr);
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!searchBar.getText().toString().equals("")) {
                    Fragment fr = new SearchFragment(Pesquisa.makeSearch(searchBar.getText().toString()));
                    FragmentChangeListener fc = (FragmentChangeListener) getActivity();
                    fc.replaceFragment(fr);
                }else{
                    Toast.makeText(getContext(), "Insira uma palavra-chave primeiro", Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;

    }

}
