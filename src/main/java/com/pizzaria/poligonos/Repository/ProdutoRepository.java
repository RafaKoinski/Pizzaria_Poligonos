package com.pizzaria.poligonos.Repository;

import com.pizzaria.poligonos.Domain.Produto.ProdutoJPA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoJPA, Long> {
    Page<ProdutoJPA> findAllByAtivoTrue(Pageable pag);
}
