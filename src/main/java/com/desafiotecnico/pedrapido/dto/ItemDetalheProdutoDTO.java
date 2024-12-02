package com.desafiotecnico.pedrapido.dto;

import com.desafiotecnico.pedrapido.entities.ItemDetalheProduto;

public class ItemDetalheProdutoDTO {

    private Long id;
    private String descricao;
    private Double preco;
    private String adicional;
    private String possueAcucar;

    public ItemDetalheProdutoDTO() {
    }

    public ItemDetalheProdutoDTO(Long id, String descricao, Double preco, String adicional, String possueAcucar) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.adicional = adicional;
        this.possueAcucar = possueAcucar;
    }

    public ItemDetalheProdutoDTO(ItemDetalheProduto entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
        preco = entity.getPreco();
        adicional = entity.getAdicional();
        possueAcucar = entity.getPossueAcucar();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public String getAdicional() {
        return adicional;
    }

    public String getPossueAcucar() {
        return possueAcucar;
    }
}
