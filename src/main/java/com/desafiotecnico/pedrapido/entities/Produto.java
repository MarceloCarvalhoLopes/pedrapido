package com.desafiotecnico.pedrapido.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double preco;

    @ManyToMany
    @JoinTable(
            name = "tb_produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "produto")
    private List<DetalheProduto> detalhes = new ArrayList<>();

    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> items = new HashSet<>();

    public Produto() {
    }

    public Produto(Long id, String descricao, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
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

    public Set<ItemPedido> getItems() {
        return items;
    }

    public List<Pedido> getPedidos(){
        return items.stream().map(x -> x.getPedido()).toList();
    }

    public List<DetalheProduto> getDetalhes() {
        return detalhes;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto that = (Produto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
