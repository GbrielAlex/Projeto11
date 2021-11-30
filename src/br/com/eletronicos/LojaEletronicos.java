package br.com.eletronicos;

import java.util.ArrayList;

public class LojaEletronicos {

    private String nome;
    private String cnpj;
    private ArrayList<Produto> produtos;
    private String local;
    private ArrayList<Produto> carrinhoDeCompras;

    public LojaEletronicos(String nome, String cnpj, ArrayList<Produto> produtos, String local) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.produtos = produtos;
        this.local = local;
        this.carrinhoDeCompras = new ArrayList<>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getLocal() {
        return local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public ArrayList<Produto> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(ArrayList<Produto> carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

    public boolean addProdutoNoCarrinho(Produto produto){
        for (Produto produtoAdcionar:this.carrinhoDeCompras){
            if(produtoAdcionar.equals(produto)) {
                return false;
            }
        }
        carrinhoDeCompras.add(produto);
        return true;
    }
    public boolean addProdutoNoEstoque(Produto produto){
        for (Produto produtoAdcionar:this.produtos){
            if(produtoAdcionar.equals(produto)) {
                return false;
            }
        }
        this.produtos.add(produto);
        return true;
    }
    public String emitirNotaFiscal(){
        String notaFiscal = this.getNome()+"\n"+
                this.getLocal()+"\n"
                + this.getCnpj()+"\n";
        double precoFinal = 0;
        for (Produto produto:this.carrinhoDeCompras){
                notaFiscal = notaFiscal + produto.getNomeProduto() + produto.getPreco() +"\n";
                precoFinal = precoFinal + produto.getPreco();
        }
        notaFiscal = notaFiscal + "Valor final: R$" + precoFinal;
        return notaFiscal;
    }
}
