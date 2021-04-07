package com.gama.ecommerce.controller;

import com.gama.ecommerce.model.Marca;
import com.gama.ecommerce.repository.MarcaRepository;
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
    public ResponseEntity<Marca> incluir(@Valid @RequestBody Marca marca) {
        return ResponseEntity.ok(marcaRepository.save(marca));
    }
}
