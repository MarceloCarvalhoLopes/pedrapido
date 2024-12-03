package com.desafiotecnico.pedrapido.repositories;

import com.desafiotecnico.pedrapido.entities.ItemDetalheProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDetalheProdutoRepositoy extends JpaRepository<ItemDetalheProduto,Long> {

    @Query(nativeQuery = true,value = """
            select p.id,
                   p.descricao,
                   p.preco,
                   p.adicional,
                   p.possue_acucar
              from tb_item_detalhe_produto p
             where UPPER(p.descricao) LIKE UPPER(CONCAT('%', :descricao, '%'))
            """)
    Page<ItemDetalheProduto> searchByName(String descricao, Pageable pageable);
}
