package br.com.eletronicos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class LojaEletronicos implements LojaEletronicosInterface{

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
                + "cnpj: "+ this.getCnpj()+"\n";
        double precoFinal = 0;
        for (Produto produto:this.carrinhoDeCompras){
                notaFiscal = notaFiscal + produto.getNomeProduto() + " R$" + produto.getPreco() +"\n";
                precoFinal = precoFinal + produto.getPreco();
        }
        notaFiscal = notaFiscal + "Valor final: R$" + precoFinal;
        this.carrinhoDeCompras = new ArrayList<>();
        return notaFiscal;
    }

    public String mostrarProdutos(){
        String todosProdutos = "";
        int cont = 1;
        for (Produto produto:this.produtos){
            todosProdutos = todosProdutos+ cont + " - "+produto.getNomeProduto() + " R$" + produto.getPreco() + "\n";
        cont ++;
        }
        return todosProdutos;
    }

    public String mostrarProdutosCarrinho(){
        String todosProdutos = "";
        int cont = 1;
        for (Produto produto:this.carrinhoDeCompras){
            todosProdutos = todosProdutos + cont + " "+ produto.getNomeProduto() + " R$" + produto.getPreco() + "\n";
        cont ++;
        }
        return todosProdutos;
    }

    public void removerProdutoCarrinho(String nomeProdutoARemover) throws NaoExisteProdutoException {
        int cont = 0;
        for (Produto produtoARemover: carrinhoDeCompras) {
            if (nomeProdutoARemover.equals(produtoARemover.getNomeProduto())) {
                carrinhoDeCompras.remove(cont);
                return;
            }
            cont++;
        }
        throw new NaoExisteProdutoException("Não existe produto "+nomeProdutoARemover.toString());
    }

    public String mostrarNotaFiscal(){
        String notaFiscal = this.getNome()+"\n"+
                this.getLocal()+"\n"
                + "cnpj: "+ this.getCnpj()+"\n";
        double precoFinal = 0;
        for (Produto produto:this.carrinhoDeCompras){
            notaFiscal = notaFiscal + produto.getNomeProduto() + " R$" + produto.getPreco() +"\n";
            precoFinal = precoFinal + produto.getPreco();
        }
        notaFiscal = notaFiscal + "\nValor final: R$" + precoFinal+"\n";
        return notaFiscal;
    }

    public void pegarDadosArquivo() throws IOException {
        String linha;
        int cont = 1;
        String[] produto ;
        FileReader produtos = new FileReader("produtos.txt");
        BufferedReader lerProdutos = new BufferedReader(produtos);
        linha = lerProdutos.readLine();
        while(linha != null) {
            produto = linha.split("##");
            if (produto[0].equals("Laptop")){
                Laptop computador = new Laptop(Integer.parseInt(produto[4]),"DDR4",produto[3],produto[7],
                        Double.parseDouble(produto[8]),Integer.parseInt(produto[6]), produto[5],produto[2]);
                Produto produtoVender = new Produto(produto[1],Double.parseDouble(produto[9]),produto[10],computador,produto[11]);
                this.addProdutoNoEstoque(produtoVender);
            }else if (produto[0].equals("Desktop")){
                Desktop computador = new Desktop(Integer.parseInt(produto[5]),produto[8],produto[3],Integer.parseInt(produto[7]),
                        produto[6],produto[2],produto[4]);
                Produto produtoVender = new Produto(produto[1],Double.parseDouble(produto[9]),"TrioDetech",computador,produto[10]);
                this.addProdutoNoEstoque(produtoVender);
            }else if (produto[0].equals("Movel")){
                DispositivoMovel computador = new DispositivoMovel(Integer.parseInt(produto[2]),produto[5],produto[3],Double.parseDouble(produto[4]),Integer.parseInt(produto[6]));
                Produto produtoVender = new Produto(produto[1],Double.parseDouble(produto[7]),produto[8],computador,produto[9]);
                this.addProdutoNoEstoque(produtoVender);
            }
            linha = lerProdutos.readLine();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LojaEletronicos that = (LojaEletronicos) o;
        return Objects.equals(nome, that.nome) && Objects.equals(cnpj, that.cnpj) && Objects.equals(local, that.local);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cnpj, local);
    }

}
