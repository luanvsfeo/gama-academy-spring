package com.gama.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "campo codigoBarra não pode ser nulo")
    private String codigoBarra;

    @NotBlank(message = "campo nome não pode ser nulo")
    @Size(min = 1, max = 80)
    @Column(nullable = false, length = 80)
    private String nome;


    @NotBlank(message = "campo unidadeMedida não pode ser nulo")
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String unidadeMedida;

    @ManyToOne
    private Marca marca;

    @ManyToOne
    private Categoria categoria;

    @Column(nullable = false)
    private Double valorUnitario;

    @Column(nullable = false)
    private Integer quantidadeDisponivel;

    public Produto() {
    }

    public Produto(String codigoBarra, @NotBlank(message = "campo nome não pode ser nulo") @Size(min = 1, max = 80) String nome, @NotBlank(message = "campo unidadeMedida não pode ser nulo") @Size(min = 1, max = 50) String unidadeMedida, Marca marca, Categoria categoria, @NotBlank(message = "campo valorUnitario não pode ser nulo") @Size(min = 1, max = 50) Double valorUnitario, @NotBlank(message = "campo quantidade não pode ser nulo") @Min(1) @Max(100) Integer quantidadeDisponivel) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.marca = marca;
        this.categoria = categoria;
        this.valorUnitario = valorUnitario;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", codigoBarra='" + codigoBarra + '\'' +
                ", nome='" + nome + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", marca=" + marca +
                ", categoria=" + categoria +
                ", valorUnitario=" + valorUnitario +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}


