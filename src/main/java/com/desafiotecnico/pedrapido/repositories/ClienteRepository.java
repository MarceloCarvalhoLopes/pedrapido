package com.desafiotecnico.pedrapido.repositories;

import com.desafiotecnico.pedrapido.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
