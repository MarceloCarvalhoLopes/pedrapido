package com.desafiotecnico.pedrapido.repositories;

import com.desafiotecnico.pedrapido.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Long> {
}
