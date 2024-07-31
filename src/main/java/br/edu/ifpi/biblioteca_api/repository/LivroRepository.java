package br.edu.ifpi.biblioteca_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpi.biblioteca_api.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{


    boolean existsByIsbn(String isbn);
}
