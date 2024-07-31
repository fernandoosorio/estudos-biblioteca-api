package br.edu.ifpi.biblioteca_api.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.biblioteca_api.dto.LivroDTO;
import br.edu.ifpi.biblioteca_api.excecao.LivroNaoExisteException;
import br.edu.ifpi.biblioteca_api.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @GetMapping
    public List<LivroDTO> listAll(){
        return livroService.listarTodos();
    }

    @PostMapping
    public LivroDTO create(@Validated @RequestBody  LivroDTO dto) throws Exception{
        return livroService.salvar(dto);
    }

    @GetMapping("{id}")
    public LivroDTO findById( @PathVariable Long id) throws LivroNaoExisteException{
        return livroService.findById(id);
    }

    @DeleteMapping("{id}")
    public LivroDTO deleteById(@PathVariable Long id){
        return livroService.deleteById(id);
    }

    @PutMapping("{id}")
    public LivroDTO  update( @PathVariable Long id ,@RequestBody LivroDTO dto ){
        return livroService.update(id, dto);
    }

    

}
