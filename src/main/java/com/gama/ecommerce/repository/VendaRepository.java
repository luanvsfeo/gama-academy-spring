package com.gama.ecommerce.repository;

import com.gama.ecommerce.model.Usuario;
import com.gama.ecommerce.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findAllByUsuario(Usuario usuario);

    @Query(value = "select * from venda v where date(v.data_venda) = :dataVenda", nativeQuery = true)
    List<Venda> findAllByDataVenda(@Param("dataVenda") String data);

}
