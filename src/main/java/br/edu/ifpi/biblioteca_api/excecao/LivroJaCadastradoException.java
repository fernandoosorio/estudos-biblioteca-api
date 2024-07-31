package br.edu.ifpi.biblioteca_api.excecao;

public class LivroJaCadastradoException  extends Exception{

    public LivroJaCadastradoException(){
        super("Livro Já cadastrado!");
    }
    
}
