package com.example.bydelivery_app.handlers;

import java.util.ArrayList;
import java.util.List;

public abstract class Pesquisa {

    public static List<Produto> makeSearch(String palavra){

        List<Produto> searchResults = new ArrayList<>();

        for (Produto p : ProductsList.getAllProducts()) {
            if (p.getProductName().toLowerCase().equals(palavra.toLowerCase()) ||
                    p.getProductName().toLowerCase().contains(palavra.toLowerCase())) {

                searchResults.add(p);
            }
        }

        return searchResults;

    }

    public static List<Produto> getProductsBySeller(String sellerName){

        List<Produto> returnList = new ArrayList<>();

        for (Produto p : ProductsList.getAllProducts()) {
            if (p.getProductSeller().equalsIgnoreCase(sellerName))
                returnList.add(p);
        }

        return returnList;
    }

}
