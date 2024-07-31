package br.edu.ifpi.biblioteca_api.excecao;

public class LivroNaoExisteException extends Exception {

    public LivroNaoExisteException(){
        super("Livro não cadastrado!!");
    }
    
}
