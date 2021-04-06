package com.gama.ecommerce.controller;

import com.gama.ecommerce.model.ProdutoVenda;
import com.gama.ecommerce.model.Usuario;
import com.gama.ecommerce.model.Venda;
import com.gama.ecommerce.repository.ProdutoRepository;
import com.gama.ecommerce.repository.ProdutoVendaRepository;
import com.gama.ecommerce.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaRepository  vendaRepository;

    @Autowired
    private ProdutoVendaRepository  produtoVendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Venda> listar(@RequestParam(value = "usuarioId",required = false) Long usuarioId, @RequestParam(value = "dataVenda",required = false)Date datavenda){

        if(usuarioId != null){
            return vendaRepository.findAllByUsuario(new Usuario(usuarioId));
        }else if(datavenda != null){
            return vendaRepository.findAllByDataVenda(datavenda);
        }else{
            return vendaRepository.findAll();
        }
    }


    @PostMapping
    public void criar(@RequestBody Venda venda){


        Venda posSave = vendaRepository.save(venda);

        posSave.setListaProdutoVenda(venda.getListaProdutoVenda());

        // TODO - Diminuir a quantidade em estoque de cada produto
        double valorTotal = 0;

        for(ProdutoVenda produtoVenda : venda.getListaProdutoVenda()){
            produtoVenda.setValorUnitario(produtoVenda.getProduto().getValorUnitario());
            produtoVenda.setValorTotal(produtoVenda.getProduto().getValorUnitario() * produtoVenda.getQuantidade());
            valorTotal += produtoVenda.getValorTotal();
        }
        venda.setValorTotal(valorTotal);

        produtoVendaRepository.saveAll(venda.getListaProdutoVenda());
        vendaRepository.save(posSave);
    }
}
