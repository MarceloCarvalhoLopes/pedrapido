package com.desafiotecnico.pedrapido.repositories;

import com.desafiotecnico.pedrapido.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {



}
