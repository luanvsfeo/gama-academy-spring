package com.gama.ecommerce.model;

import javax.persistence.*;

@Entity
public class ProdutoVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    private Venda venda;

    private Integer quantidade;

    private Double valorTotal;

    private Double valorUnitario;

    public ProdutoVenda() {
    }

    public ProdutoVenda(Produto produto, Venda venda, Integer quantidade, Double valorTotal, Double valorUnitario) {
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.valorUnitario = valorUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "ProdutoVenda{" +
                "id=" + id +
                ", produto=" + produto +
                ", venda=" + venda +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
