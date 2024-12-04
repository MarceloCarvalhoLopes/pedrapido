package com.desafiotecnico.pedrapido.services;

import com.desafiotecnico.pedrapido.dto.ClienteDTO;
import com.desafiotecnico.pedrapido.entities.Cliente;
import com.desafiotecnico.pedrapido.repositories.ClienteRepository;
import com.desafiotecnico.pedrapido.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new ClienteDTO(cliente);
    }

}
