package com.desafiotecnico.pedrapido.dto;

import com.desafiotecnico.pedrapido.entities.ItemPedido;
import com.desafiotecnico.pedrapido.entities.Pedido;
import com.desafiotecnico.pedrapido.entities.StatusPedido;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {

    private Long id;
    private String descricao;
    private Instant data;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private ClienteDTO cliente;

    private List<ItemPedidoDTO> items = new ArrayList<>();

    public PedidoDTO() {
    }

    public PedidoDTO(Long id, String descricao, Instant data, StatusPedido status, ClienteDTO cliente) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
        this.cliente = cliente;
    }

    public PedidoDTO(Pedido entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
        data = entity.getData();
        status = entity.getStatus();
        this.cliente = new ClienteDTO(entity.getCliente());

        for (ItemPedido itemPedido : entity.getItems()){
            ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO(itemPedido);
            items.add(itemPedidoDTO);
        }
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Instant getData() {
        return data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public List<ItemPedidoDTO> getItems() {
        return items;
    }


    public Double getTotal(){
        double sum = 0.0;
        for (ItemPedidoDTO item: items){
            sum += item.getSubTotal();
        }
        return sum;
    }
}
