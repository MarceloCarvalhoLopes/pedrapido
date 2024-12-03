package com.desafiotecnico.pedrapido.dto;

import com.desafiotecnico.pedrapido.entities.Categoria;
import com.desafiotecnico.pedrapido.entities.DetalheProduto;
import com.desafiotecnico.pedrapido.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDTO {

    private Long id;
    private String descricao;
    private Double preco;

    private List<CategoriaDTO> categorias = new ArrayList<>();

    private List<DetalheProdutoDTO> detalhesProdutoDTOS = new ArrayList<>();

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String descricao, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public ProdutoDTO(Produto entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
        preco = entity.getPreco();

        for (Categoria categoria : entity.getCategorias()) {
            categorias.add(new CategoriaDTO(categoria));
        }

        for (DetalheProduto detalheProduto : entity.getDetalhes()) {
            detalhesProdutoDTOS.add(new DetalheProdutoDTO(detalheProduto));
        }

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

    public List<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public List<DetalheProdutoDTO> getDetalhesProdutoDTOS() {
        return detalhesProdutoDTOS;
    }
}
