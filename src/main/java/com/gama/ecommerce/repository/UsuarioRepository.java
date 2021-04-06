package com.gama.ecommerce.repository;

import com.gama.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNome(String nome);

    Optional<Usuario> findByCpf(String cpf);

    boolean existsByCpfOrLogin(String cpf, String login);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findById(Long id);

    /*@Query("select c from Pessoa c where c.nome = ?1")
    Optional<Pessoa> findByNome(String nome);

    @Query("select c from Pessoa c where c.cpf = ?1")
    Optional<Pessoa> findByCpf(String cpf);

    @Query("select c from Pessoa c where c.email = ?1")
    Optional<Pessoa> findByEmail(String email);*/

}
