import br.com.eletronicos.DispositivoMovel;
import br.com.eletronicos.Eletronico;
import br.com.eletronicos.LojaEletronicos;

import javax.swing.*;
import java.util.ArrayList;
import  br.com.eletronicos.Produto;

public class GabrielTech {

    public static void main(String[] args) {

        Eletronico A10 = new DispositivoMovel(2,"exinus","Amoled",6.2,32);
        Produto A10Produto = new Produto("A10",700,"Samsung",A10,"134515234");
        LojaEletronicos trioDeTech = new LojaEletronicos("TrioDeTech","36934235000106",new ArrayList<>(),"Centro Rio Tinto numero 420");
        trioDeTech.addProdutoNoEstoque(A10Produto);

    boolean continuar = true;
        while (continuar){
            String opcaoCliente = JOptionPane.showInputDialog("GabrielTech \n" +
                    "Digite 1 para mostrar a lista de produtos\n" +
                    "Digite 2 para mostrar seu carrinho \n" +
                    "Digite 3 para comprar os itens no seu carinhoa\n"+
                    "Digite 4 para sair\n");
            if (opcaoCliente.equals("1")){
                JOptionPane.showMessageDialog(null,trioDeTech.mostrarProdutos());

            }else if(opcaoCliente.equals("4")){
                continuar = false;
            }
        }


    }
}
