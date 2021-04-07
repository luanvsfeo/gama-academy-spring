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

    List<Produto> findAllByValorUnitario(Double valor);
    List<Produto> findAllByMarca(Marca marca);
    List<Produto> findAllByCategoria(Categoria categoria);
    Optional<Produto> findByNome(String nome);
    boolean existsByQuantidadeDisponivelGreaterThanAndId(int quantidade, long id);

}
