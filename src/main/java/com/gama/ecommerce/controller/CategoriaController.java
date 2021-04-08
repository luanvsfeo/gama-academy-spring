package com.gama.ecommerce.controller;

import com.gama.ecommerce.repository.CategoriaRepository;
import com.gama.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    public CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Categoria> incluir(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaRepository.save(categoria));
    }

}
