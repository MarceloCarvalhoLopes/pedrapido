package com.desafiotecnico.pedrapido.controllers;

import com.desafiotecnico.pedrapido.dto.ItemDetalheProdutoDTO;
import com.desafiotecnico.pedrapido.services.ItemDetalheProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @GetMapping
    public ResponseEntity<Page<ItemDetalheProdutoDTO>> findAll(
            @RequestParam(name = "descricao", defaultValue = "") String descricao,
            Pageable pageable){
        Page<ItemDetalheProdutoDTO> dto = service.findAll(descricao,pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ItemDetalheProdutoDTO> insert(@Valid @RequestBody ItemDetalheProdutoDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    





}
