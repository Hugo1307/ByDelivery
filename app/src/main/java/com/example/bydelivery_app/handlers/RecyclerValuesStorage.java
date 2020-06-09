package com.example.bydelivery_app.handlers;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerValuesStorage {

    ///////////////////////////////////////////////////////////////////
    //                        NOTIFICAÇÕES                           //
    ///////////////////////////////////////////////////////////////////

    private static ArrayList<Integer> notificationsImages = new ArrayList<>();
    private static ArrayList<String> notificationsTitles = new ArrayList<>();
    private static ArrayList<String> notificationsBodyStrings = new ArrayList<>();
    private static ArrayList<String> notificationsHours = new ArrayList<>();

    public static ArrayList<Integer> getNotificationsImages() {
        return notificationsImages;
    }

    public static void setNotificationsImages(ArrayList<Integer> notificationsImages) {
        RecyclerValuesStorage.notificationsImages = notificationsImages;
    }

    public static ArrayList<String> getNotificationsTitles() {
        return notificationsTitles;
    }

    public static void setNotificationsTitles(ArrayList<String> notificationsTitles) {
        RecyclerValuesStorage.notificationsTitles = notificationsTitles;
    }

    public static ArrayList<String> getNotificationsBodyStrings() {
        return notificationsBodyStrings;
    }

    public static void setNotificationsBodyStrings(ArrayList<String> notificationsBodyStrings) {
        RecyclerValuesStorage.notificationsBodyStrings = notificationsBodyStrings;
    }

    public static ArrayList<String> getNotificationsHours() {
        return notificationsHours;
    }

    public static void setNotificationsHours(ArrayList<String> notificationsHours) {
        RecyclerValuesStorage.notificationsHours = notificationsHours;
    }

    ///////////////////////////////////////////////////////////////////
    //                        ENCOMENDAS                             //
    ///////////////////////////////////////////////////////////////////

    private static List<String> orderTitles = new ArrayList<>();
    private static List<Integer> orderImages = new ArrayList<>();

    public static List<String> getOrderTitles() {
        return orderTitles;
    }

    public static void setOrderTitles(List<String> orderTitles) {
        RecyclerValuesStorage.orderTitles = orderTitles;
    }

    public static List<Integer> getOrderImages() {
        return orderImages;
    }

    public static void setOrderImages(List<Integer> orderImages) {
        RecyclerValuesStorage.orderImages = orderImages;
    }

    ///////////////////////////////////////////////////////////////////
    //                        PARCEIROS                              //
    ///////////////////////////////////////////////////////////////////

    private static List<String> parceirosNames = new ArrayList<>();
    private static List<String> parceirosMOTDs = new ArrayList<>();
    private static List<Integer> parceirosLogos = new ArrayList<>();
    private static List<Double> parceirosRatings = new ArrayList<>();

    public static List<String> getParceirosNames() {
        return parceirosNames;
    }

    public static void setParceirosNames(List<String> parceirosNames) {
        RecyclerValuesStorage.parceirosNames = parceirosNames;
    }

    public static List<Integer> getParceirosLogos() {
        return parceirosLogos;
    }

    public static void setParceirosLogos(List<Integer> parceirosLogos) {
        RecyclerValuesStorage.parceirosLogos = parceirosLogos;
    }

    public static List<Double> getParceirosRatings() {
        return parceirosRatings;
    }

    public static void setParceirosRatings(List<Double> parceirosRatings) {
        RecyclerValuesStorage.parceirosRatings = parceirosRatings;
    }

    public static List<String> getParceirosMOTDs() {
        return parceirosMOTDs;
    }

    public static void setParceirosMOTDs(List<String> parceirosMOTDs) {
        RecyclerValuesStorage.parceirosMOTDs = parceirosMOTDs;
    }

    ///////////////////////////////////////////////////////////////////
    //                        CARRINHO                               //
    ///////////////////////////////////////////////////////////////////

    private static List<String> productNames = new ArrayList<>();
    private static List<Integer> productImages = new ArrayList<>();
    private static List<String> productSellers = new ArrayList<>();
    private static List<Double> productPrices = new ArrayList<>();
    private static List<Integer> productQuantityList = new ArrayList<>();
    private static double deliveryPrice = 0;

    public static List<String> getProductNames() {
        return productNames;
    }

    public static void setProductNames(List<String> productNames) {
        RecyclerValuesStorage.productNames = productNames;
    }

    public static List<Integer> getProductImages() {
        return productImages;
    }

    public static void setProductImages(List<Integer> productImages) {
        RecyclerValuesStorage.productImages = productImages;
    }

    public static List<String> getProductSellers() {
        return productSellers;
    }

    public static void setProductSellers(List<String> productSellers) {
        RecyclerValuesStorage.productSellers = productSellers;
    }

    public static List<Double> getProductPrices() {
        return productPrices;
    }

    public static void setProductPrices(List<Double> productPrices) {
        RecyclerValuesStorage.productPrices = productPrices;
    }

    public static List<Integer> getProductQuantityList() {
        return productQuantityList;
    }

    public static void setProductQuantityList(List<Integer> productQuantityList) {
        RecyclerValuesStorage.productQuantityList = productQuantityList;
    }

    public static double getDeliveryPrice() {
        return deliveryPrice;
    }

    public static void setDeliveryPrice(double deliveryPrice) {
        RecyclerValuesStorage.deliveryPrice = deliveryPrice;
    }
}
