package com.desafiotecnico.pedrapido.controllers;

import com.desafiotecnico.pedrapido.dto.ItemDetalheProdutoDTO;
import com.desafiotecnico.pedrapido.services.ItemDetalheProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/itens")
public class ItemDetalheProdutoController {

    @Autowired
    private ItemDetalheProdutoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemDetalheProdutoDTO> findById(@PathVariable Long id){
        ItemDetalheProdutoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping()
    public ResponseEntity<Page<ItemDetalheProdutoDTO>> findAll(
            @RequestParam(name = "descricao", defaultValue = "") String descricao,
            Pageable pageable){
        Page<ItemDetalheProdutoDTO> dto = service.findAll(descricao,pageable);
        return ResponseEntity.ok(dto);
    }


}
