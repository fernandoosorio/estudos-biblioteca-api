package br.edu.ifpi.biblioteca_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.edu.ifpi.biblioteca_api.dto.LivroDTO;
import br.edu.ifpi.biblioteca_api.excecao.LivroJaCadastradoException;
import br.edu.ifpi.biblioteca_api.excecao.LivroNaoExisteException;
import br.edu.ifpi.biblioteca_api.model.Livro;
import br.edu.ifpi.biblioteca_api.repository.LivroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    ModelMapper mapper = new ModelMapper();

    public List<LivroDTO> listarTodos(){
        List<Livro> livros = livroRepository.findAll();
        List<LivroDTO> retorno = new ArrayList<>();

        for (Livro livro : livros) {
            retorno.add(mapper.map(livro, LivroDTO.class));
        }
        return retorno;  
    }

    public LivroDTO salvar( LivroDTO dto) throws Exception {
        Livro livro = mapper.map(dto, Livro.class);
        
        if( livroRepository.existsByIsbn(dto.getIsbn())){
            throw new LivroJaCadastradoException();
        }
        
        livroRepository.save(livro);

        return mapper.map(livro, LivroDTO.class);

    }


    public LivroDTO findById(Long id) throws LivroNaoExisteException{

        Optional<Livro>  livro = livroRepository.findById(id);
        if(livro.isPresent() ){
            return mapper.map(livro, LivroDTO.class);
        }else{
            throw new LivroNaoExisteException();
        }
        
    }

    public LivroDTO deleteById(Long id){
        Livro livro = livroRepository.findById(id).get();
        LivroDTO dto = mapper.map(livro, LivroDTO.class);
        livroRepository.delete(livro);
        return dto;
    }

    public LivroDTO update( Long id, LivroDTO dto){
        Livro livroBanco = livroRepository.findById(id).get();
        Livro livro = mapper.map(dto, Livro.class);
        livro.setId(livroBanco.getId());

        livroRepository.save(livro);

        return mapper.map(livro, LivroDTO.class);


    }

   


}
