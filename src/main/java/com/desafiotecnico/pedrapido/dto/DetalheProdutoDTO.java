package com.desafiotecnico.pedrapido.dto;

import com.desafiotecnico.pedrapido.entities.DetalheProduto;
import com.desafiotecnico.pedrapido.entities.ItemDetalheProduto;
import com.desafiotecnico.pedrapido.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class DetalheProdutoDTO {

    private Long id;
    private String descricao;
    private Produto produto;

    public List<ItemDetalheProdutoDTO> itemDetalheProdutos = new ArrayList<>();

    public DetalheProdutoDTO() {
    }

    public DetalheProdutoDTO(Long id, String descricao, Produto produto) {
        this.id = id;
        this.descricao = descricao;
        this.produto = produto;
    }

    public DetalheProdutoDTO(DetalheProduto entity) {
        id = entity.getId();
        descricao = entity.getDescricao();

        for (ItemDetalheProduto itemDetalheProduto : entity.getItemDetalheProdutos()){
            itemDetalheProdutos.add(new ItemDetalheProdutoDTO());
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<ItemDetalheProdutoDTO> getItemDetalheProdutos() {
        return itemDetalheProdutos;
    }
}
