package com.example.bydelivery_app.handlers;

import java.util.Objects;

public class Produto {

    private static int id = 0;
    private int productId;
    private String productName;
    private String productDescription;
    private String productSeller;
    private int productImage;
    private int productQuantity;
    private double productPrice;
    private double productRating;
    private int productWeight;
    private int productSize; private String productSizeClothes;

    public Produto(String productName, String productSeller, String productDescription, int productImage, int productQuantity,
                   double productPrice, double productRating, int productWeight, int productSize){

        Produto.id++;
        this.productId = Produto.id;
        this.productName = productName;
        this.productSeller = productSeller;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.productWeight = productWeight;
        this.productSize = productSize;
    }

    public Produto(String productName, String productSeller, String productDescription, int productImage, int productQuantity,
                   double productPrice, double productRating, int productWeight, String productSize){

        Produto.id++;
        this.productId = Produto.id;
        this.productName = productName;
        this.productSeller = productSeller;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.productWeight = productWeight;
        this.productSizeClothes = productSize;
    }

    public int getProductId(){
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSeller() {
        return productSeller;
    }

    public int getProductImage() {
        return productImage;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public int getProductSize() {
        return productSize;
    }

    public String getProductSizeClothes() {
        return productSizeClothes;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductRating() {
        return productRating;
    }

    public void add(int q){
        this.productQuantity += q;
    }

    public void add(){
        this.productQuantity++;
    }

    public void remove(int q){
        this.productQuantity -= q;
    }

    public void remove(){
        this.productQuantity--;
    }

    public void set(int quantidade){
        this.productQuantity = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return productImage == produto.productImage &&
                Double.compare(produto.productPrice, productPrice) == 0 &&
                productName.equals(produto.productName) &&
                productSeller.equals(produto.productSeller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productSeller, productImage, productPrice);
    }
}
