package com.gama.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorTotal;

    @NotNull
    @ManyToOne
    private Usuario usuario;

    private Date dataVenda;

    @OneToMany(mappedBy = "vendaId")
    private List<ProdutoVenda> produtos = new ArrayList<>();

    public Venda() { }

    public Venda(Double valorTotal, Usuario usuario, Date dataVenda, List<ProdutoVenda> produtos) {
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.dataVenda = dataVenda;
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

    public List<ProdutoVenda> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoVenda> produtos) {
        this.produtos = produtos;
    }

    public void popular( List<ProdutoVenda> produtoVendas, double valorTotal){
        this.setValorTotal(valorTotal);
        this.setProdutos(produtoVendas);
        this.dataVenda =  new Date();
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", usuario=" + usuario +
                ", dataVenda=" + dataVenda +
                ", listaProdutoVenda=" + produtos +
                '}';
    }
}
