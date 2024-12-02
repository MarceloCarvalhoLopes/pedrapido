package com.desafiotecnico.pedrapido.services;

import com.desafiotecnico.pedrapido.dto.ItemDetalheProdutoDTO;
import com.desafiotecnico.pedrapido.entities.ItemDetalheProduto;
import com.desafiotecnico.pedrapido.repositories.ItemDetalheProdutoRepositoy;
import com.desafiotecnico.pedrapido.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemDetalheProdutoService {

    @Autowired
    private ItemDetalheProdutoRepositoy repositoy;

    @Transactional(readOnly = true)
    public ItemDetalheProdutoDTO findById(Long id) {
        ItemDetalheProduto item = repositoy.getReferenceById(id);
        return new ItemDetalheProdutoDTO(item);
    }

    @Transactional(readOnly = true)
    public Page<ItemDetalheProdutoDTO> findAll(String descricao, Pageable pageable) {
        Page<ItemDetalheProduto> result = repositoy.searchByName(descricao, pageable);
        return result.map(x -> new ItemDetalheProdutoDTO(x));
    }

    public ItemDetalheProdutoDTO insert(ItemDetalheProdutoDTO dto) {
        ItemDetalheProduto entity = new ItemDetalheProduto();
        copyDtoToEntity(dto, entity);
        entity = repositoy.save(entity);
        return new ItemDetalheProdutoDTO(entity);
    }

    @Transactional
    private void copyDtoToEntity(ItemDetalheProdutoDTO dto, ItemDetalheProduto entity) {
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        entity.setAdicional(dto.getAdicional());
        entity.setPossueAcucar(dto.getPossueAcucar());
    }

    @Transactional
    public ItemDetalheProdutoDTO update(Long id, ItemDetalheProdutoDTO dto) {

        try{
            ItemDetalheProduto entity = repositoy.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repositoy.save(entity);
            return new ItemDetalheProdutoDTO(entity);

        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if (!repositoy.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        repositoy.deleteById(id);
    }

}
