package com.gama.ecommerce.utils;

import com.gama.ecommerce.model.ProdutoVenda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ConversaoUtils {

    public static Date converterStringToDate(String data ){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static HashMap<Long, Integer> converterListToMap(List<ProdutoVenda> produtoVendas) {
        HashMap<Long, Integer> produtoQuantidade = new HashMap<>();
        for (ProdutoVenda produtoVenda : produtoVendas) {
            produtoQuantidade.put(produtoVenda.getProduto().getId(), produtoVenda.getQuantidade());
        }
        return produtoQuantidade;
    }
}
