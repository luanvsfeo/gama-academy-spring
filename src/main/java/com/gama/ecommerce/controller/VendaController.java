package com.gama.ecommerce.controller;

import com.gama.ecommerce.model.Produto;
import com.gama.ecommerce.model.ProdutoVenda;
import com.gama.ecommerce.model.Usuario;
import com.gama.ecommerce.model.Venda;
import com.gama.ecommerce.repository.ProdutoRepository;
import com.gama.ecommerce.repository.ProdutoVendaRepository;
import com.gama.ecommerce.repository.VendaRepository;
import com.gama.ecommerce.utils.ConversaoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Venda> listar(@RequestParam(value = "usuarioId", required = false) Long usuarioId,
                              @RequestParam(value = "dataVenda", required = false) String datavenda) {

        if (usuarioId != null) {
            return vendaRepository.findAllByUsuario(new Usuario(usuarioId));
        } else if (datavenda != null) {
            return vendaRepository.findAllByDataVenda(datavenda);
        } else {
            return vendaRepository.findAll();
        }
    }


    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Venda venda) {

        List<ProdutoVenda> produtoVendas = venda.getProdutos();
        HashMap<Long, Integer> produtoQuantidade = ConversaoUtils.converterListToMap(produtoVendas);

        if(!produtoQuantidade.isEmpty()){
            for (Long produtoId : produtoQuantidade.keySet()) {
                if (!produtoRepository.existsByQuantidadeDisponivelGreaterThanAndId(produtoQuantidade.get(produtoId), produtoId)) {
                    return ResponseEntity.badRequest().build();
                }
            }

            venda.setProdutos(null);
            Venda posSave = vendaRepository.save(venda);

            posSave.setProdutos(venda.getProdutos());

            double valorTotal = 0;

            for (ProdutoVenda produtoVenda : produtoVendas) {

                Produto produto = produtoRepository.findById(produtoVenda.getProduto().getId()).get();
                produto.dimiuirQuantidadeDisponivel(produtoVenda.getQuantidade());

                produtoVenda.popular(produto, venda.getId());
                valorTotal += produtoVenda.getValorTotal();

                produtoRepository.save(produto);
            }

            posSave.popular(produtoVendas, valorTotal);

            produtoVendaRepository.saveAll(venda.getProdutos());
            vendaRepository.save(posSave);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}