package com.example.bydelivery_app.handlers;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public abstract class Carrinho {

    private static final String TAG = "Carrinho";

    private static List<Produto> cartProducts = new ArrayList<>();
    private static double deliveryPrice = 0;

    public static List<Produto> getCartProducts() {
        return cartProducts;
    }

    public static void setCartProducts(List<Produto> cartProducts) {
        Carrinho.cartProducts = cartProducts;
    }

    public static double getDeliveryPrice() {
        return deliveryPrice;
    }

    public static void setDeliveryPrice(double deliveryPrice) {
        Carrinho.deliveryPrice = deliveryPrice;
    }

    public static double getProductsPVPPrice(){

        double totalProductsPrice = 0;
        for (Produto p : Carrinho.cartProducts) {
            totalProductsPrice += p.getProductPrice() * p.getProductQuantity();
        }

        return totalProductsPrice;
    }

    public static double getTotalPVPPrice(){

        double totalPrice = 0;

        totalPrice += getProductsPVPPrice();
        totalPrice += Carrinho.deliveryPrice;

        return totalPrice;
    }

    public static double getOrderIVA(){
        return getTotalPVPPrice() * 0.23;
    }

    public static void addProduct(Produto p){

        if (!Carrinho.getCartProducts().contains(p)){
            Log.d(TAG, "addProduct: dont contains");
            Carrinho.cartProducts.add(p);
        }else{
            Log.d(TAG, "addProduct: contains");
            Carrinho.cartProducts.get(Carrinho.getCartProducts().indexOf(p)).add();
        }

    }

    public static void clear(){

        for (Produto p : Carrinho.cartProducts) {
            p.set(1);
        }

        Carrinho.cartProducts.clear();
        Carrinho.deliveryPrice = 0;
    }

}
