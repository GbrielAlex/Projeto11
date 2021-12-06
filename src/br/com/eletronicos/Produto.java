package br.com.eletronicos;

import java.util.Objects;

public class Produto{

    private String nomeProduto;
    private double preco;
    private String marca;
    private Eletronico tipoEletronico;
    private String codigoBarra;

    public Produto(String nomeProduto,double preco, String marca, Eletronico tipoEletronico, String codigoBarra) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.marca = marca;
        this.tipoEletronico = tipoEletronico;
        this.codigoBarra = codigoBarra;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Eletronico getTipoComputador() {
        return tipoEletronico;
    }
    public void setTipoComputador(Eletronico tipoEletronico) {
        this.tipoEletronico = tipoEletronico;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String fichaTecnica(){
        return tipoEletronico.toString();
    }

    public String toString(){
        return this.nomeProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nomeProduto, produto.nomeProduto) && Objects.equals(codigoBarra, produto.codigoBarra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeProduto, codigoBarra);
    }

}
