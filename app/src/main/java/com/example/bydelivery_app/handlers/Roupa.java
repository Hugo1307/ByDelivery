package com.example.bydelivery_app.handlers;

public class Roupa extends Produto {
    public Roupa(String productName, String productSeller, String productDescription, int productImage, int productQuantity, double productPrice, double productRating, int productWeight, String productSize) {
        super(productName, productSeller, productDescription, productImage, productQuantity, productPrice, productRating, productWeight, productSize);
    }

    public Roupa(String productName, String productSeller, String productDescription, int productImage, int productQuantity, double productPrice, double productRating, int productWeight, int productSize) {
        super(productName, productSeller, productDescription, productImage, productQuantity, productPrice, productRating, productWeight, productSize);
    }
}
