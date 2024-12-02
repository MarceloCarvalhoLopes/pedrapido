package com.desafiotecnico.pedrapido.services;

import com.desafiotecnico.pedrapido.dto.ItemDetalheProdutoDTO;
import com.desafiotecnico.pedrapido.entities.ItemDetalheProduto;
import com.desafiotecnico.pedrapido.repositories.ItemDetalheProdutoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemDetalheProdutoService {

    @Autowired
    private ItemDetalheProdutoRepositoy repositoy;

    @Transactional(readOnly = true)
    public ItemDetalheProdutoDTO findById(Long id){
        ItemDetalheProduto item = repositoy.getReferenceById(id);
        return new ItemDetalheProdutoDTO(item);
    }

    @Transactional(readOnly = true)
    public Page<ItemDetalheProdutoDTO> findAll(String descricao, Pageable pageable){
        Page<ItemDetalheProduto> result = repositoy.searchByName(descricao, pageable);
        return result.map(x -> new ItemDetalheProdutoDTO(x));
    }

}
