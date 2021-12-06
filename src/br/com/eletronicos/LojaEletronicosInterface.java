package br.com.eletronicos;

import java.io.IOException;

public interface LojaEletronicosInterface {

    boolean addProdutoNoCarrinho(Produto produto);

    boolean addProdutoNoEstoque(Produto produto);

    String emitirNotaFiscal();

    String mostrarProdutos();

    String mostrarProdutosCarrinho();

    void removerProdutoCarrinho(String nomeProdutoARemover) throws NaoExisteProdutoException;

    String mostrarNotaFiscal();

    void pegarDadosArquivo() throws IOException;

}
