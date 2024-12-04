package com.desafiotecnico.pedrapido.dto;

import com.desafiotecnico.pedrapido.entities.ItemPedido;

public class ItemPedidoDTO {

    private Long produtoId;
    private Integer quantidade;
    private Double preco;
    private String observacao;

    public ItemPedidoDTO() {
    }

    public ItemPedidoDTO(Long produtoId, Integer quantidade, Double preco, String observacao) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.preco = preco;
        this.observacao = observacao;
    }

    public ItemPedidoDTO(ItemPedido entity) {
        produtoId = entity.getProduto().getId();
        quantidade = entity.getQuantidade();
        preco = entity.getPreco();
        observacao = entity.getObservacao();
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public String getObservacao() {
        return observacao;
    }

    public Double getSubTotal(){
        return preco * quantidade;
    }

}
