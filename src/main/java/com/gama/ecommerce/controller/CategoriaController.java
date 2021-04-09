package com.gama.ecommerce.controller;

import com.gama.ecommerce.repository.CategoriaRepository;
import com.gama.ecommerce.model.Categoria;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Registros encontrados com sucesso")
    })
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Criado com sucesso"),
            @ApiResponse(code = 400,message = "Ocorreu um erro ao criar")
    })
    public ResponseEntity<Categoria> incluir(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
    }

}
