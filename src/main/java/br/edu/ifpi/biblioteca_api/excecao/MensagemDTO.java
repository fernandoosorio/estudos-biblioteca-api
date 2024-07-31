package br.edu.ifpi.biblioteca_api.excecao;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MensagemDTO {
    String mensagem;
    HttpStatus status;
    
}
