import br.com.eletronicos.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import  br.com.eletronicos.Produto;

public class TrioDeTech {

    public static void main(String[] args) throws IOException {

        LojaEletronicos trioDeTech = new LojaEletronicos("TrioDeTech","36934235000106",new ArrayList<>(),"Centro Rio Tinto numero 420");


        String linha;
        int cont = 1;
        String[] produto ;
        FileReader produtos = new FileReader("/home/gabrielalexandre/IdeaProjects/Projeto 11/src/produtoslaptop.txt");
        BufferedReader lerProdutos = new BufferedReader(produtos);
        linha = lerProdutos.readLine();
        while(linha != null) {
            produto = linha.split("-");
            if (produto[0].equals("Laptop")){
                Laptop computador = new Laptop(Integer.parseInt(produto[4]),"DDR4",produto[3],produto[7],
                    Double.parseDouble(produto[8]),Integer.parseInt(produto[6]), produto[5],produto[2]);
                Produto produtoVender = new Produto(produto[1],Double.parseDouble(produto[9]),produto[10],computador,produto[11]);
                trioDeTech.addProdutoNoEstoque(produtoVender);
            }else if (produto[0].equals("Desktop")){
                Desktop computador = new Desktop(Integer.parseInt(produto[5]),produto[8],produto[3],Integer.parseInt(produto[7]),
                        produto[6],produto[2],produto[4]);
                Produto produtoVender = new Produto(produto[1],Double.parseDouble(produto[9]),"TrioDetech",computador,produto[10]);
                trioDeTech.addProdutoNoEstoque(produtoVender);
            }else if (produto[0].equals("Movel")){
                DispositivoMovel computador = new DispositivoMovel(Integer.parseInt(produto[2]),produto[5],produto[3],Double.parseDouble(produto[4]),Integer.parseInt(produto[6]));
                Produto produtoVender = new Produto(produto[1],Double.parseDouble(produto[7]),produto[8],computador,produto[9]);
                trioDeTech.addProdutoNoEstoque(produtoVender);
            }
            linha = lerProdutos.readLine();
        }


        boolean continuarMenu = true;
        while (continuarMenu){
            String opcaoCliente = JOptionPane.showInputDialog("TriodeTech \n" +
                    "Digite 1 para mostrar a lista de produtos\n" +
                    "Digite 2 para mostrar seu carrinho \n" +
                    "Digite 3 para comprar os itens no seu carinho\n"+
                    "Digite 4 para outras opções\n"+
                    "Digite 5 para sair\n");
            if (opcaoCliente.equals("1")){
                int opcaoDeCompra = Integer.parseInt(JOptionPane.showInputDialog("Escreva o numero referente ao item que deseja adcionar " +
                        "no seu carrinho \n " +trioDeTech.mostrarProdutos()));
                String confirmacao = JOptionPane.showInputDialog(trioDeTech.getProdutos().get(opcaoDeCompra - 1).fichaTecnica() + "\n\nDigite SIM se deseja confirmar") ;
                if (confirmacao.toLowerCase().equals("sim")) {
                    JOptionPane.showMessageDialog(null,"Item adicionado no carrinho com sucesso");
                    trioDeTech.addProdutoNoCarrinho(trioDeTech.getProdutos().get(opcaoDeCompra - 1));
                }else {
                    JOptionPane.showMessageDialog(null,"Ocorreu um erro tente novamente ");
                }
            }else if(opcaoCliente.toUpperCase().equals("2")) {
                String desejaRemocao  = JOptionPane.showInputDialog("Se desejar remover algum item digite REMOVER\n" + trioDeTech.mostrarProdutosCarrinho());
                if (desejaRemocao.toUpperCase().equals("REMOVER")){
                    int opcaoRemover = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero Referente ao produto que deseja remover do seu carrinho\n"+trioDeTech.mostrarProdutos()));
                    trioDeTech.removerProdutoCarrinho(trioDeTech.getCarrinhoDeCompras().get(opcaoRemover-1));
                    JOptionPane.showMessageDialog(null,"Produto removido com sucesso");
                }
            }else if(opcaoCliente.equals("3")){
                JOptionPane.showMessageDialog(null, trioDeTech.emitirNotaFiscal());

            }else if(opcaoCliente.equals("4")) {
            }

            else if(opcaoCliente.equals("5")){
                continuarMenu = false;
            }
        }

    }
}
