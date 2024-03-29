package com.gama.ecommerce.controller;

import com.gama.ecommerce.api.object.RespostaMensagem;
import com.gama.ecommerce.api.object.ViaCepObject;
import com.gama.ecommerce.model.Usuario;
import com.gama.ecommerce.repository.UsuarioRepository;
import com.gama.ecommerce.service.RestTemplateService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioRepository repository;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Criado com sucesso"),
            @ApiResponse(code = 400, message = "Ocorreu um erro ao criar um usuario")
    })
    public ResponseEntity<?> incluir(@Valid @RequestBody Usuario usuario) {

        ViaCepObject viaCepObject = RestTemplateService.getCepViaRestTemplate(usuario.getEndereco().getCep());

        if (viaCepObject == null || repository.existsByCpfOrLogin(usuario.getCpf(), usuario.getLogin())) {

            return ResponseEntity.status(400).body(new RespostaMensagem("Cep invalido ou CPF/Login ja cadastrado"));
        } else {
            usuario.getEndereco().atualizarComViaCepObject(viaCepObject);
            usuario.criptografarSenha();
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
        }
    }


    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Alterado com sucesso"),
            @ApiResponse(code = 404, message = "Registro não encontrado")
    })
    public ResponseEntity<Usuario> alterarPorId(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario) {
        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();
        usuario.setId(id);
        usuario.criptografarSenha();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(repository.save(usuario));
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Encontrado com sucesso"),
            @ApiResponse(code = 404, message = "Registro não encontrado")
    })
    public ResponseEntity<Usuario> buscarPorId(@PathVariable("id") Long id) {

        Optional<Usuario> usuarioDB = repository.findById(id);
        if (usuarioDB.isPresent()) {
            return ResponseEntity.ok(usuarioDB.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Excluido com sucesso"),
            @ApiResponse(code = 404, message = "Registro não encontrado")
    })
    public ResponseEntity<Void> apagar(@PathVariable("id") Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

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
