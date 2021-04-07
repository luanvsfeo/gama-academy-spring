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

    Usuario findByLogin(String login);

}
