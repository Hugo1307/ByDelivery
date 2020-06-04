package com.example.bydelivery_app.handlers;

public interface ListListener<T> {

    void beforeOp(T item);
    void afterOp(T item);

}
