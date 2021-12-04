import br.com.eletronicos.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class TrioDeTech {

    public static void main(String[] args) throws IOException {

        LojaEletronicos trioDeTech = new LojaEletronicos("TrioDeTech","36934235000106",new ArrayList<>(),"Centro Rio Tinto numero 420");
        trioDeTech.pegarDadosArquivo();

        //A partir dessa linha começa a criação da menu grafico do projeto
        boolean continuarMenu = true;
        while (continuarMenu){
            String opcaoCliente = JOptionPane.showInputDialog("TriodeTech \n" +
                    "Digite 1 para mostrar a lista de produtos\n" +
                    "Digite 2 para mostrar seu carrinho \n" +
                    "Digite 3 para comprar os itens no seu carinho\n"+
                    "Digite 4 para sair\n");
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
                    String opcaoRemover = JOptionPane.showInputDialog("Digite o nome Referente ao produto que deseja remover do seu carrinho\n"+trioDeTech.mostrarProdutosCarrinho());
                    try {
                        trioDeTech.removerProdutoCarrinho(opcaoRemover);
                        JOptionPane.showMessageDialog(null,"Produto removido com sucesso");
                    } catch (NaoExisteProdutoException e) {
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }finally {
                        JOptionPane.showMessageDialog(null,"Continuando programa");
                    }
                }
            }else if(opcaoCliente.equals("3")){
                String confirmarCompra = JOptionPane.showInputDialog(trioDeTech.mostrarNotaFiscal()+"Digite sim para confirmar a comprar");
                JOptionPane.showMessageDialog(null, trioDeTech.emitirNotaFiscal());

            } else if(opcaoCliente.equals("4")){
                continuarMenu = false;
            }
        }
    }
}
