package com.example.bydelivery_app.handlers;

import java.util.ArrayList;
import java.util.List;

public abstract class OrdinaryMethods {

    public static void addNotification(int image, String title, String body, String notificationTime) {
        RecyclerValuesStorage.getNotificationsImages().add(image);
        RecyclerValuesStorage.getNotificationsTitles().add(title);
        RecyclerValuesStorage.getNotificationsBodyStrings().add(body);
        RecyclerValuesStorage.getNotificationsHours().add(notificationTime);
    }

    public static void addParceiro(int image, String name, String mot, double rating){
        RecyclerValuesStorage.getParceirosLogos().add(image);
        RecyclerValuesStorage.getParceirosNames().add(name);
        RecyclerValuesStorage.getParceirosMOTDs().add("\"" + mot + "\"");
        RecyclerValuesStorage.getParceirosRatings().add(rating);
    }

    public static void addProduct(String productName, String productSeller, int productImage, double productPrice, int productQuantity){

        List<String> productsNames = RecyclerValuesStorage.getProductNames();
        List<String> productsSellers = RecyclerValuesStorage.getProductSellers();
        List<Integer> productsImages = RecyclerValuesStorage.getProductImages();
        List<Double> productsPrices = RecyclerValuesStorage.getProductPrices();
        List<Integer> productsQuantityList = RecyclerValuesStorage.getProductQuantityList();

        if (productsNames.contains(productName)) {

            int productIndex = productsNames.indexOf(productName);
            int currentQuantity = productsQuantityList.get(productIndex);

            if (productsSellers.get(productIndex).equals(productSeller)) {
                currentQuantity = currentQuantity + productQuantity;
                productsQuantityList.set(productIndex, currentQuantity);
            }

        }else{
            productsNames.add(productName);
            productsSellers.add(productSeller);
            productsImages.add(productImage);
            productsPrices.add(productPrice);
            productsQuantityList.add(productQuantity);

            RecyclerValuesStorage.setProductNames(productsNames);
            RecyclerValuesStorage.setProductSellers(productsSellers);
            RecyclerValuesStorage.setProductImages(productsImages);
            RecyclerValuesStorage.setProductPrices(productsPrices);
            RecyclerValuesStorage.setProductQuantityList(productsQuantityList);
        }

    }

    public static void calcCartPrice(){

        List<Double> returnValue = new ArrayList<>();

        List<Double> productPrices = RecyclerValuesStorage.getProductPrices();
        double deliveryPrice = RecyclerValuesStorage.getDeliveryPrice();



    }

}
