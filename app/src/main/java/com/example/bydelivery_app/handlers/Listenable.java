package com.example.bydelivery_app.handlers;

public interface Listenable<T> {

    void setListener(ListListener<T> listener);

}
