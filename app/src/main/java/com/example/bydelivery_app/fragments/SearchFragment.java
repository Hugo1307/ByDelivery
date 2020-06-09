package com.example.bydelivery_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bydelivery_app.R;
import com.example.bydelivery_app.adapters.AdapterSearchList;
import com.example.bydelivery_app.handlers.Pesquisa;
import com.example.bydelivery_app.handlers.ProductsList;
import com.example.bydelivery_app.handlers.Produto;

import java.util.List;

public class SearchFragment extends Fragment {

    private static final String TAG = "SearchFragment";
    private View rootView;
    private List<Produto> searchResults;

    public SearchFragment(String palavraChave){
        searchResults = Pesquisa.makeSearch(palavraChave);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_expandable_list_item_1, ProductsList.getAllProductsNames());
        final AutoCompleteTextView searchBar = view.findViewById(R.id.searchSearchBar);
        ImageView searchButton = view.findViewById(R.id.searchSearchButton);
        final TextView summaryResults = view.findViewById(R.id.searchSummaryResultsLabel);

        summaryResults.setText(searchResults.size() + " resultado(s) encontrado(s)");
        searchBar.setAdapter(adapter);
        rootView = view;

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchResults = Pesquisa.makeSearch(searchBar.getText().toString());
                summaryResults.setText(searchResults.size() + " resultado(s) encontrado(s)");
                initRecyclerView();
            }
        });

        initRecyclerView();

        return view;

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recycler = rootView.findViewById(R.id.searchRecyclerView);

        AdapterSearchList adapter = new AdapterSearchList(searchResults);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
