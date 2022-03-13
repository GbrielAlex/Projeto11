import br.com.eletronicos.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TrioDeTech {

    public static void main(String[] args) throws IOException {

        LojaEletronicos trioDeTech = new LojaEletronicos("TrioDeTech","36934235000106",new ArrayList<>(),"Centro Rio Tinto numero 420");
        trioDeTech.pegarDadosArquivo();

        //A partir dessa linha começa a criação da menu grafico do projeto
        boolean continuarMenu = true;
        while (continuarMenu){
            String opcaoCliente = JOptionPane.showInputDialog("TriodeJao \n" +
                    "Digite 1 para aproximar a lista de produtos\n" +
                    "Digite 2 para mostrar seu carrinho \n" +
                    "Digite 3 para comprar os itens no seu carinho\n"+
                    "Digite 4 para adcionar um produto no estoque\n"+
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
                if(confirmarCompra.toLowerCase().equals("sim")){
                    JOptionPane.showMessageDialog(null, trioDeTech.emitirNotaFiscal());
                }else {
                    JOptionPane.showMessageDialog(null,"Compra cancelada");
                }

            }else if(opcaoCliente.equals("4")){
                Eletronico eletronico;
                Produto produto;
                String nome = JOptionPane.showInputDialog("DIga o nome do produto que deseja adcionar ");
                String marca = JOptionPane.showInputDialog("QUal a marca do produto ");
                String processador = JOptionPane.showInputDialog("Qual o processador do produto: ");
                String tipoComputador = JOptionPane.showInputDialog("ELe é um dispositivel movel , desktop ou laptop?");
                int quantMemoriaRam = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de memoria ram que ele tem"));
                int armazenamento = Integer.parseInt(JOptionPane.showInputDialog("Quantos gigabytes de Armazenamento"));
                Random gerador = new Random();
                String codigo = String.valueOf(gerador.nextInt(999999999));

                if (tipoComputador.toLowerCase().equals("dispositivel movel")){
                    String tipoTela = JOptionPane.showInputDialog("Qual o tipo de tela do dispositivo: ");
                    double tamanhoTela = Double.parseDouble(JOptionPane.showInputDialog("Qual o tamanho da tela: "));
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do produto:"));
                    eletronico = new DispositivoMovel(quantMemoriaRam,processador,tipoTela,tamanhoTela,armazenamento);
                    produto = new Produto(nome,preco,marca,eletronico,codigo);
                    trioDeTech.addProdutoNoEstoque(produto);

                }else if(tipoComputador.toLowerCase().equals("desktop")){
                    String tipoArmazenamento = JOptionPane.showInputDialog("Qual o tipo de armazenamento");
                    String placaDeVideo = JOptionPane.showInputDialog("Qual é a placa de video do produto");
                    String placaMae = JOptionPane.showInputDialog("Qual a placa mãe equipada nele");
                    String tipoMemoriaRam = JOptionPane.showInputDialog("Qual o tipo da memoriaRam instalada");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do produto:"));
                    eletronico = new Desktop(quantMemoriaRam,tipoMemoriaRam,processador,armazenamento,tipoArmazenamento,placaDeVideo,placaMae);
                    produto = new Produto(nome,preco,marca,eletronico,codigo);
                    trioDeTech.addProdutoNoEstoque(produto);

                }else if(tipoComputador.toLowerCase().equals("laptop")) {
                    String tipoTela = JOptionPane.showInputDialog("Qual o tipo de tela do dispositivo: ");
                    double tamanhoTela = Double.parseDouble(JOptionPane.showInputDialog("Qual o tamanho da tela: "));
                    String tipoArmazenamento = JOptionPane.showInputDialog("Qual o tipo de armazenamento");
                    String placaDeVideo = JOptionPane.showInputDialog("Qual é a placa de video do produto");
                    String tipoMemoriaRam = JOptionPane.showInputDialog("Qual o tipo da memoriaRam instalada");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do produto:"));
                    eletronico = new Laptop(quantMemoriaRam, tipoMemoriaRam, processador, tipoTela, tamanhoTela, armazenamento, tipoArmazenamento, placaDeVideo);
                    produto = new Produto(nome, preco, marca, eletronico, codigo);
                    trioDeTech.addProdutoNoEstoque(produto);
                }
            } else if(opcaoCliente.equals("5")){
                continuarMenu = false;
            }
        }
    }
}
