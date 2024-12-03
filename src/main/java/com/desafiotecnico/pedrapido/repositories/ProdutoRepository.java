package com.desafiotecnico.pedrapido.repositories;

import com.desafiotecnico.pedrapido.entities.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(nativeQuery = true, value ="""
            select p.id,
                   p.descricao,
                   p.preco
              from tb_produto p
             where UPPER(p.descricao) like UPPER(CONCAT('%', :descricao, '%'))
    
      """)
    Page<Produto> searchByName(String descricao, Pageable pageable);

}
