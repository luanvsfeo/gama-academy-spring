package com.gama.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class ProdutoVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @JsonIgnore
    private Long vendaId;

    private Integer quantidade;

    private Double valorTotal;

    private Double valorUnitario;

    public ProdutoVenda() { }

    public ProdutoVenda(Long id, Produto produto, Long vendaId, Integer quantidade, Double valorTotal, Double valorUnitario) {
        this.id = id;
        this.produto = produto;
        this.vendaId = vendaId;
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


    public Long getVendaId() {
        return vendaId;
    }

    public void setVendaId(Long vendaId) {
        this.vendaId = vendaId;
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
                ", vendaId=" + vendaId +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                ", valorUnitario=" + valorUnitario +
                '}';
    }

    public void popular(Produto produto, long vendaId){
        this.setValorUnitario(produto.getValorUnitario());
        this.setValorTotal(produto.getValorUnitario() * this.getQuantidade());
        this.setVendaId(vendaId);
    }
}
