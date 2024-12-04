package com.desafiotecnico.pedrapido.services;

import com.desafiotecnico.pedrapido.dto.ItemPedidoDTO;
import com.desafiotecnico.pedrapido.dto.PedidoDTO;
import com.desafiotecnico.pedrapido.entities.*;
import com.desafiotecnico.pedrapido.repositories.ClienteRepository;
import com.desafiotecnico.pedrapido.repositories.ItemPedidoRepository;
import com.desafiotecnico.pedrapido.repositories.PedidoRepository;
import com.desafiotecnico.pedrapido.repositories.ProdutoRepository;
import com.desafiotecnico.pedrapido.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public PedidoDTO findById(Long id){

        Pedido pedido = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));

        return new PedidoDTO(pedido);

    }

    @Transactional
    public PedidoDTO insert(PedidoDTO dto) {
        Pedido pedido = new Pedido();

        pedido.setData(Instant.now());
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        pedido.setDescricao(dto.getDescricao());

        Cliente cliente = clienteRepository.getReferenceById(dto.getCliente().getId());
        pedido.setCliente(cliente);

        for (ItemPedidoDTO itemDTO: dto.getItems()){
            Produto produto = produtoRepository.getReferenceById(itemDTO.getProdutoId());
            ItemPedido item = new ItemPedido(pedido,produto,itemDTO.getQuantidade(),produto.getPreco(), itemDTO.getObservacao());
            pedido.getItems().add(item);
        }

        repository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItems());

        return new PedidoDTO(pedido);
    }



}
