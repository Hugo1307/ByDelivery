package com.example.bydelivery_app.handlers;

import java.util.ArrayList;
import java.util.List;

public abstract class Pesquisa {

    public static List<Produto> makeSearch(String palavra){

        List<Produto> searchResults = new ArrayList<>();

        for (Produto p : ProductsList.getAllProducts()) {
            if (p.getProductName().equalsIgnoreCase(palavra) || p.getProductName().contains(palavra))
                    searchResults.add(p);
        }

        return searchResults;

    }

}
