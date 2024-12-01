package com.desafiotecnico.pedrapido.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_detalhe_produto")
public class DetalheProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToMany()
    @JoinTable(name = "tb_itens_detalhe_produto",
        joinColumns = @JoinColumn(name = "detalhe_produto_id"),
        inverseJoinColumns = @JoinColumn(name = "item_detalhe_produto_id"))
    private Set<ItemDetalheProduto> itemDetalheProdutos = new HashSet<>();

    public DetalheProduto() {
    }

    public DetalheProduto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

    public Set<ItemDetalheProduto> getItemDetalheProdutos() {
        return itemDetalheProdutos;
    }

    public void setItemDetalheProdutos(Set<ItemDetalheProduto> itemDetalheProdutos) {
        this.itemDetalheProdutos = itemDetalheProdutos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalheProduto that = (DetalheProduto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
