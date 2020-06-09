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

    public Encomenda(List<Produto> productsList, Date deliveryDate, Date deliveryPrevision, boolean expressDelivery) {
        Encomenda.id++;

        this.productsList = productsList;
        this.deliveryId = Encomenda.id;
        this.deliveryDate = deliveryDate;
        this.deliveryPrevision = deliveryPrevision;
        this.expressDelivery = expressDelivery;
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
