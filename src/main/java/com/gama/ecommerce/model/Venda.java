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

    private Date dataVenda = new Date();

    @OneToMany(mappedBy = "vendaId")
    private List<ProdutoVenda> listaProdutoVenda = new ArrayList<>();

    public Venda() { }

    public Venda(Double valorTotal, Usuario usuario, Date dataVenda, List<ProdutoVenda> listaProdutoVenda) {
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.dataVenda = dataVenda;
        this.listaProdutoVenda = listaProdutoVenda;
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

    public List<ProdutoVenda> getListaProdutoVenda() {
        return listaProdutoVenda;
    }

    public void setListaProdutoVenda(List<ProdutoVenda> listaProdutoVenda) {
        this.listaProdutoVenda = listaProdutoVenda;
    }

    public void popular( List<ProdutoVenda> produtoVendas, double valorTotal){
        this.setValorTotal(valorTotal);
        this.setListaProdutoVenda(produtoVendas);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", usuario=" + usuario +
                ", dataVenda=" + dataVenda +
                ", listaProdutoVenda=" + listaProdutoVenda +
                '}';
    }
}
