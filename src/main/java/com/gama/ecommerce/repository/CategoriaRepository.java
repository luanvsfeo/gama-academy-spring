package com.gama.ecommerce.repository;


import com.gama.ecommerce.model.Categoria;
import com.gama.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
