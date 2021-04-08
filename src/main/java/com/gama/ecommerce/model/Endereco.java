package com.gama.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gama.ecommerce.api.object.ViaCepObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private String cep;

    private String bairro;

    private String localidade;

    private String uf;

    private Integer numero;

    private String complemento;

    @JsonIgnore
    private String ibge;

    @JsonIgnore
    private String gia;

    @JsonIgnore
    private String ddd;

    @JsonIgnore
    private String siafi;

    public Endereco() {
    }

    public Endereco(String logradouro, String cep, String bairro, String localidade, String uf, Integer numero, String complemento, String ibge, String gia, String ddd, String siafi) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.numero = numero;
        this.complemento = complemento;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }

    public Endereco(ViaCepObject viaCepObject) {
        this.logradouro = viaCepObject.getLogradouro();
        this.cep = viaCepObject.getCep();
        this.bairro = viaCepObject.getBairro();
        this.localidade = viaCepObject.getLocalidade();
        this.uf = viaCepObject.getUf();
        this.ibge = viaCepObject.getIbge();
        this.gia = viaCepObject.getGia();
        this.ddd = viaCepObject.getDdd();
        this.siafi = viaCepObject.getSiafi();
    }

    public void atualizarComViaCepObject(ViaCepObject viaCepObject) {
        this.logradouro = viaCepObject.getLogradouro();
        this.cep = viaCepObject.getCep();
        this.bairro = viaCepObject.getBairro();
        this.localidade = viaCepObject.getLocalidade();
        this.uf = viaCepObject.getUf();
        this.ibge = viaCepObject.getIbge();
        this.gia = viaCepObject.getGia();
        this.ddd = viaCepObject.getDdd();
        this.siafi = viaCepObject.getSiafi();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
