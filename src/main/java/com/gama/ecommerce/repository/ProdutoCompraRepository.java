package com.gama.ecommerce.repository;

import com.gama.ecommerce.model.ProdutoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCompraRepository extends JpaRepository<ProdutoCompra,Long> {
}
