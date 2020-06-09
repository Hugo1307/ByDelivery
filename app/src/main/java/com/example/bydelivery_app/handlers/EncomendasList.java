package com.example.bydelivery_app.handlers;

import java.util.ArrayList;
import java.util.List;

public abstract class EncomendasList {

    private static List<Encomenda> listaEncomendas = new ArrayList<>();

    public static void addEncomenda(Encomenda e) {

        if (!listaEncomendas.contains(e)) {
            listaEncomendas.add(e);
        }

    }

    public static void removeEncomenda(int i) {
        if (listaEncomendas.size() > i) {
            listaEncomendas.remove(i);
        }
    }

    public static void clear() {
        EncomendasList.listaEncomendas.clear();
    }

    public static List<Encomenda> getListaEncomendas() {
        return listaEncomendas;
    }

    public static void setListaEncomendas(List<Encomenda> listaEncomendas) {
        EncomendasList.listaEncomendas = listaEncomendas;
    }

}
