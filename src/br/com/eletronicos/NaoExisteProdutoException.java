package br.com.eletronicos;

public class NaoExisteProdutoException extends Exception{

    public NaoExisteProdutoException(){
        super();
    }
    public NaoExisteProdutoException(String mensagem){
        super(mensagem);
    }
}
