package com.gama.ecommerce.controller;

import com.gama.ecommerce.model.Marca;
import com.gama.ecommerce.repository.MarcaRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    public MarcaRepository marcaRepository;

    @GetMapping
    public List<Marca> listarTodos() {
        return marcaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Criado com sucesso"),
            @ApiResponse(code = 400,message = "Ocorreu um erro ao criar")
    })
    public ResponseEntity<Marca> incluir(@Valid @RequestBody Marca marca) {
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaRepository.save(marca));
    }
}
