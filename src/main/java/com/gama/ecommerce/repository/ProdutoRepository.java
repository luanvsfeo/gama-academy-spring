package com.gama.ecommerce.repository;

import com.gama.ecommerce.model.Categoria;
import com.gama.ecommerce.model.Marca;
import com.gama.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<List<Produto>> findByValorUnitario(Double valor);
    Optional<List<Produto>> findByMarca(Marca marca);
    Optional<List<Produto>> findByCategoria(Categoria categoria);
    Optional<Produto> findByNome(String nome);


    /*Optional<Produto> findByMarcas(String marcas);
    Optional<Produto> findByCategorias(String categorias);*/

}
