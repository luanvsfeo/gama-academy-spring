package com.gama.ecommerce.controller;

import com.gama.ecommerce.model.Usuario;
import com.gama.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Usuario> incluir(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok( repository.save(usuario) );
    }


    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Usuario> alterarPorId (@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario) {
        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();
        usuario.setId(id);
        return ResponseEntity.ok(repository.save(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable("id") Long id) {

        Optional<Usuario> usuarioDB = repository.findById(id);
        if (usuarioDB.isPresent()) {
            return ResponseEntity.ok(usuarioDB.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> apagar(@PathVariable("id") Long id) {
        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private boolean validaCadastro(String cpf, String login) throws Exception {
        if (repository.existsByCpfOrLogin(cpf, login)) {
            throw new Exception("Cpf já consta no banco de dados");
        }
        return true;
    }

}

