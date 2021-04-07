package com.gama.ecommerce.controller;

import com.gama.ecommerce.model.Categoria;
import com.gama.ecommerce.model.Marca;
import com.gama.ecommerce.model.Produto;
import com.gama.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    public ProdutoRepository produtoRepository;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Produto> incluir(@Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoRepository.save(produto));
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Produto> alterarPorId(@PathVariable("id") Long id, @Valid @RequestBody Produto produto) {

        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produto.setId(id);
        return ResponseEntity.ok(produtoRepository.save(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable("id") Long id) {

        Optional<Produto> produtoDB = produtoRepository.findById(id);
        if (produtoDB.isPresent()) {
            return ResponseEntity.ok(produtoDB.get());
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping
    public List<Produto> listarTodos(@RequestParam(value = "marca", required = false) Long marca,
                                     @RequestParam(value = "categoria", required = false) Long categoria,
                                     @RequestParam(value = "valorUnitario", required = false) Double valorUnitario) {
        if (marca != null) {
            return produtoRepository.findAllByMarca(new Marca(marca));
        } else if (categoria != null) {
            return produtoRepository.findAllByCategoria(new Categoria(categoria));
        } else if (valorUnitario != null) {
            return produtoRepository.findAllByValorUnitario(valorUnitario);
        } else {
            return produtoRepository.findAll();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> apagar(@PathVariable("id") Long id) {

        if (!produtoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
