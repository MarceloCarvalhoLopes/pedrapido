package com.desafiotecnico.pedrapido.dto;

import com.desafiotecnico.pedrapido.entities.Categoria;

public class CategoriaDTO {

    private Long id;
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public CategoriaDTO(Categoria entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
