package com.gama.ecommerce.controller;

import com.gama.ecommerce.model.*;
import com.gama.ecommerce.repository.CompraRepository;
import com.gama.ecommerce.repository.ProdutoCompraRepository;
import com.gama.ecommerce.repository.ProdutoRepository;
import com.gama.ecommerce.utils.ConversaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoCompraRepository produtoCompraRepository;


    @GetMapping
    public List<Compra> listar() {
        return compraRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Compra compra) {

        List<Long> produtosId = compra.getProdutos().stream().map(x -> x.getProduto().getId()).collect(Collectors.toList());

        HashMap<Long, Double> produtoCompraMap = ConversaoUtils.converterProdutoCompraListToMap(compra.getProdutos());

        for (Long produtoId : produtoCompraMap.keySet()) {
            if (produtoCompraMap.get(produtoId) == null) {
                return ResponseEntity.badRequest().build();
            }
        }

        if (produtosId.size() == produtoRepository.quantidadePorIds(produtosId)) {

            List<ProdutoCompra> produtoCompraList = compra.getProdutos();
            compra.setProdutos(null);
            compra = compraRepository.save(compra);

            double valorTotal = 0;

            for (ProdutoCompra produtoCompra : produtoCompraList) {

                Produto produto = produtoRepository.findById(produtoCompra.getProduto().getId()).get();
                produto.aumentarQuantidadeDisponivel(produtoCompra.getQuantidade());
                produtoRepository.save(produto);
                produtoCompra.setCompraId(compra.getId());
                produtoCompra.setValorTotal(produtoCompra.getValorUnitario() * produtoCompra.getQuantidade());

                valorTotal += produtoCompra.getValorTotal();
            }

            compra.popular(produtoCompraList, valorTotal);
            produtoCompraRepository.saveAll(produtoCompraList);

            return ResponseEntity.ok(compraRepository.save(compra));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
