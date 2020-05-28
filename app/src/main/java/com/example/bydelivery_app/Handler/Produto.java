package com.example.bydelivery_app.Handler;

public class Produto {
    private String NomeDoProduto, NomeDoParceiro;
    private int Imagem, Quantidade;
    private double Preço;

    public Produto(String NomeDoProduto, String NomeDoParceiro, int Imagem, int Quantidade, double Preço){
        this.NomeDoProduto = NomeDoProduto;
        this.NomeDoParceiro = NomeDoParceiro;
        this.Imagem = Imagem;
        this.Quantidade = Quantidade;
        this.Preço = Preço;
    }

    public String  getNomeDoProduto(){
        return NomeDoProduto;
    }
    public void setNomeDoProduto(String NomeDoProduto){
        this.NomeDoProduto = NomeDoProduto;
    }
    public String getNomeDoParceiro(){
        return NomeDoParceiro;
    }
    public void setNomeDoParceiro(String NomeDoParceiro){
        this.NomeDoParceiro = NomeDoParceiro;
    }
    public int getImagem(){
        return Imagem;
    }
    public void setImagem(int Imagem){
        this.Imagem = Imagem;
    }
    public int getQuantidade(){
        return Quantidade;
    }
    public void setQuantidade(int Quantidade){
        this.Quantidade = Quantidade;
    }
    public double getPreço(){
        return Preço;
    }
    public void setPreço(double Preço){
        this.Preço = Preço;
    }

}
