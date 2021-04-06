package com.gama.ecommerce.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorTotal;
    @ManyToOne
    private Usuario usuario;
    private Date dataVenda;
    @OneToMany
    private List<ProdutoVenda> produtoVendaList = new ArrayList<>();

    public Venda() {
    }

    public Venda(Double valorTotal, Usuario usuario, Date dataVenda, List<ProdutoVenda> produtoVendaList) {
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.dataVenda = dataVenda;
        this.produtoVendaList = produtoVendaList;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<ProdutoVenda> getProdutoVendaList() {
        return produtoVendaList;
    }

    public void setProdutoVendaList(List<ProdutoVenda> produtoVendaList) {
        this.produtoVendaList = produtoVendaList;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", usuario=" + usuario +
                ", dataVenda=" + dataVenda +
                ", produtoVendaList=" + produtoVendaList +
                '}';
    }
}
