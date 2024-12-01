package com.desafiotecnico.pedrapido.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_item_detalhe_produto")
public class ItemDetalheProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double preco;
    private String adicional;
    private String possueAcucar;

    public ItemDetalheProduto() {
    }

    public ItemDetalheProduto(Long id, String descricao, Double preco, String adicional, String possueAcucar) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.adicional = adicional;
        this.possueAcucar = possueAcucar;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    public String getPossueAcucar() {
        return possueAcucar;
    }

    public void setPossueAcucar(String possueAcucar) {
        this.possueAcucar = possueAcucar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDetalheProduto that = (ItemDetalheProduto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
