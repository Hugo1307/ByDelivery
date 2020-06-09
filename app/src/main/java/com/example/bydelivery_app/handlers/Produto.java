package com.example.bydelivery_app.handlers;

import java.util.Objects;

public class Produto {

    private String productName;
    private String productDescription;
    private String productSeller;
    private int productImage;
    private int productQuantity;
    private double productPrice;
    private double productRating;
    private int productWeight;
    private int productSize;

    public Produto(String productName, String productSeller, String productDescription, int productImage, int productQuantity,
                   double productPrice, double productRating, int productWeight, int productSize){

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSeller() {
        return productSeller;
    }

    public void setProductSeller(String productSeller) {
        this.productSeller = productSeller;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    public int getProductSize() {
        return productSize;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductRating() {
        return productRating;
    }

    public void setProductRating(double productRating) {
        this.productRating = productRating;
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
