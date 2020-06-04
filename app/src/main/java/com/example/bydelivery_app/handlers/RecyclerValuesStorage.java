package com.example.bydelivery_app.handlers;

import java.util.ArrayList;

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
}
