package com.gama.ecommerce.repository;

import com.gama.ecommerce.model.ProdutoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda,Long> {
}
