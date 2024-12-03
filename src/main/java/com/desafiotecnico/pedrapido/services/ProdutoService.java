package com.desafiotecnico.pedrapido.services;

import com.desafiotecnico.pedrapido.dto.CategoriaDTO;
import com.desafiotecnico.pedrapido.dto.ProdutoDTO;
import com.desafiotecnico.pedrapido.entities.Categoria;
import com.desafiotecnico.pedrapido.entities.Produto;
import com.desafiotecnico.pedrapido.repositories.ProdutoRepository;
import com.desafiotecnico.pedrapido.services.exceptions.DatabaseException;
import com.desafiotecnico.pedrapido.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id){

        Produto produto = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ProdutoDTO(produto);

    }

    @Transactional(readOnly = true)
    public Page<ProdutoDTO> findAll(String descricao, Pageable pageable){
        Page<Produto> result = repository.searchByName(descricao,pageable);
        return result.map(x -> new ProdutoDTO(x));
    }

    @Transactional
    public ProdutoDTO insert(ProdutoDTO dto){
        Produto entity = new Produto();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProdutoDTO(entity);
    }

    @Transactional
    public ProdutoDTO update(Long id, ProdutoDTO dto){

        try {
            Produto entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProdutoDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw  new ResourceNotFoundException("Recurso não encontrado");
        }

        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }


    }


    private void copyDtoToEntity(ProdutoDTO dto, Produto entity) {
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        entity.getCategorias().clear();
        for (CategoriaDTO catDto : dto.getCategorias()){
            Categoria cat = new Categoria();
            cat.setId(catDto.getId());
            entity.getCategorias().add(cat);
        }
    }
}
