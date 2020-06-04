package com.example.bydelivery_app.handlers;

import java.util.ArrayList;

public class ListenableArrayList<T> implements Listenable<T> {

    private ArrayList<T> internalList;
    private ListListener<T> listener;

    /* .. */

    public void add(T item) {
        listener.beforeOp(item);
        internalList.add(item);
        listener.afterOp(item);
    }

    public void remove(T item){
        listener.beforeOp(item);
        internalList.remove(item);
        listener.afterOp(item);
    }

    public T get(int index){
        return internalList.get(index);
    }

    public int size(){
        return internalList.size();
    }

    public void clear(){
        internalList.clear();
    }

    /* .. */

    @Override
    public void setListener(ListListener<T> listener) {
        this.listener = listener;
    }
}
