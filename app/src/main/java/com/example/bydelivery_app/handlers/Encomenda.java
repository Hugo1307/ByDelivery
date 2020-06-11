package com.example.bydelivery_app.handlers;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Encomenda {

    private static int id = 100;
    private List<Produto> productsList;
    private int deliveryId;
    private Date deliveryDate;
    private Date deliveryPrevision;
    private boolean expressDelivery;
    private double deliveryPrice;
    private int deliveryState;              // 0 - Em preparação; 1 - Em Trânsito; 2 - Entregue

    public Encomenda(List<Produto> productsList, Date deliveryDate, Date deliveryPrevision, boolean expressDelivery, double deliveryPrice, int deliveryState) {
        id++;

        this.deliveryId = id;
        this.productsList = productsList;
        this.deliveryDate = deliveryDate;
        this.deliveryPrevision = deliveryPrevision;
        this.expressDelivery = expressDelivery;
        this.deliveryPrice = deliveryPrice;
        this.deliveryState = deliveryState;
    }

    public List<Produto> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Produto> productsList) {
        this.productsList = productsList;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Date getDeliveryPrevision() {
        return deliveryPrevision;
    }

    public boolean isExpressDelivery(){
        return expressDelivery;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public int getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(int deliveryState) {
        this.deliveryState = deliveryState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Encomenda)) return false;
        Encomenda encomenda = (Encomenda) o;
        return deliveryId == encomenda.deliveryId &&
                productsList.equals(encomenda.productsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productsList, deliveryId);
    }
}
