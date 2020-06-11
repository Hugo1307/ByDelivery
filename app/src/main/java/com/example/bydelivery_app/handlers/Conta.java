package com.example.bydelivery_app.handlers;

public class Conta {

    private String name;
    private String email;
    private String password;
    private String morada;
    private String numeroTelemovel;
    private int metodoPagamento;
    private boolean contaProfissional;

    public Conta(String name, String email, String password, String morada, String numeroTelemovel, int metodoPagamento, boolean contaProfissional) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.morada = morada;
        this.numeroTelemovel = numeroTelemovel;
        this.metodoPagamento = metodoPagamento;
        this.contaProfissional = contaProfissional;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getNumeroTelemovel(){
        return numeroTelemovel;
    }

    public String getMorada() {
        return morada;
    }

    public int getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(int metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public boolean isContaProfissional() {
        return contaProfissional;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNumeroTelemovel(String numeroTelemovel) {
        this.numeroTelemovel = numeroTelemovel;
    }
}
