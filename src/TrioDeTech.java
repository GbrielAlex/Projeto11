import br.com.eletronicos.*;

import javax.swing.*;
import java.util.ArrayList;
import  br.com.eletronicos.Produto;

public class TrioDeTech {

    public static void main(String[] args) {

        Eletronico A10 = new DispositivoMovel(2,"exinus","Amoled",6.2,32);
        Produto A10Produto = new Produto("A10",700,"Samsung",A10,"134515234");
        LojaEletronicos trioDeTech = new LojaEletronicos("TrioDeTech","36934235000106",new ArrayList<>(),"Centro Rio Tinto numero 420");
        trioDeTech.addProdutoNoEstoque(A10Produto);
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
                if (confirmacao.equals("sim")) {
                    JOptionPane.showMessageDialog(null,"Item adicionado no carrinho com sucesso");
                    trioDeTech.addProdutoNoCarrinho(trioDeTech.getProdutos().get(opcaoDeCompra - 1));
                }else {
                    JOptionPane.showMessageDialog(null,"Ocorreu um erro tente novamente ");
                }
            }else if(opcaoCliente.equals("2")) {
                String desejaRemocao  = JOptionPane.showInputDialog( trioDeTech.mostrarProdutosCarrinho());
                if (desejaRemocao.equals("sim")){
                    int opcaoRemover = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero Referente ao produto que deseja remover do seu carrinho\n"+trioDeTech.mostrarProdutos()));
                    trioDeTech.removerProdutoCarrinho(trioDeTech.getProdutos().get(opcaoRemover));
                    JOptionPane.showMessageDialog(null,"Produto removido com sucesso");
                }
            }else if(opcaoCliente.equals("3")){
                JOptionPane.showMessageDialog(null, trioDeTech.emitirNotaFiscal());

            } else if(opcaoCliente.equals("4")){
                continuarMenu = false;
            }
        }


    }
}
