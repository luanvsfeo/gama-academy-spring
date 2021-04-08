package com.gama.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Compra {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorTotal;

    private Date dataCompra;

    @OneToMany(mappedBy = "compraId")
    @NotEmpty
    private List<ProdutoCompra> produtos = new ArrayList<>();


    public Compra() {  }

    public Compra(Double valorTotal, Date dataCompra, List<ProdutoCompra> produtos) {
        this.valorTotal = valorTotal;
        this.dataCompra = dataCompra;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public List<ProdutoCompra> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoCompra> produtos) {
        this.produtos = produtos;
    }

    public void popular(List<ProdutoCompra> produtoCompras, double valorTotal){
        this.produtos = produtoCompras;
        this.valorTotal = valorTotal;
        this.dataCompra = new Date();
    }
}
