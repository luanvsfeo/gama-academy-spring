package com.gama.ecommerce.controller;

import com.gama.ecommerce.model.Usuario;
import com.gama.ecommerce.model.Venda;
import com.gama.ecommerce.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaRepository  vendaRepository;

    @GetMapping
    public List<Venda> listar(@RequestParam("usuarioId") Long usuarioId, @RequestParam("dataVenda")Date datavenda){

        if(usuarioId != null){
            return vendaRepository.findAllByUsuario(new Usuario(usuarioId));
        }else if(datavenda != null){
            return vendaRepository.findAllByDataVenda(datavenda);
        }else{
            return vendaRepository.findAll();
        }
    }
}
