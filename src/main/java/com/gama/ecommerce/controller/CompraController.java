package com.gama.ecommerce.controller;

import com.gama.ecommerce.api.object.RespostaMensagem;
import com.gama.ecommerce.model.*;
import com.gama.ecommerce.repository.CompraRepository;
import com.gama.ecommerce.repository.ProdutoCompraRepository;
import com.gama.ecommerce.repository.ProdutoRepository;
import com.gama.ecommerce.utils.ConversaoUtils;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Criado com sucesso"),
            @ApiResponse(code = 400,message = "Ocorreu um erro ao criar")
    })
    public ResponseEntity<?> criar(@Valid @RequestBody Compra compra) {

        List<Long> produtosId = compra.getProdutos().stream().map(x -> x.getProduto().getId()).collect(Collectors.toList());

        HashMap<Long, Double> produtoCompraMap = ConversaoUtils.converterProdutoCompraListToMap(compra.getProdutos());

        for (Long produtoId : produtoCompraMap.keySet()) {
            if (produtoCompraMap.get(produtoId) == null) {
                return ResponseEntity.status(400).body(new RespostaMensagem("Produto sem valor unitario"));
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
            return ResponseEntity.status(400).body(new RespostaMensagem("Produto não cadastrado presente na compra"));
        }
    }
}
