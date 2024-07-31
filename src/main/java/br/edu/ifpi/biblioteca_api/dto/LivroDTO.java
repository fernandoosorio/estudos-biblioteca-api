package br.edu.ifpi.biblioteca_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LivroDTO {

    private Long id;
    @NotBlank(message="Título não pode ser nulo") private String titulo;
    @NotBlank private String autor;
    private String isbn;
    private String editora;
    private Integer anoPublicacao;
    private String genero;
    private Boolean disponivel;   
    
}
