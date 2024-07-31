package br.edu.ifpi.biblioteca_api.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExcecoesHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public MensagemDTO tratarException( Exception e){
        return new MensagemDTO( e.getMessage() , HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(LivroNaoExisteException.class)
    public MensagemDTO tratarLivroNaoExisteException( Exception e){
        return new MensagemDTO( e.getMessage() , HttpStatus.NOT_FOUND);
    }


    
}
