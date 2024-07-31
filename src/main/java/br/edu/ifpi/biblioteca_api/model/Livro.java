package br.edu.ifpi.biblioteca_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column private String titulo;
    @Column private String autor;
    @Column private String isbn;
    @Column private String editora;
    @Column private Integer anoPublicacao;
    @Column private String genero;
    @Column private Boolean disponivel;    

}
