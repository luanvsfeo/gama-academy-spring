package com.gama.ecommerce.repository;

import com.gama.ecommerce.model.Usuario;
import com.gama.ecommerce.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findAllByUsuario(Usuario usuario);

    List<Venda> findAllByDataVenda(Date data);

}
