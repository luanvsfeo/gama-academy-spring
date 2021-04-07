package com.gama.ecommerce.model;

import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "campo name não pode ser nulo")
    @Size(min = 1, max = 80)
    @Column(nullable = false, length = 80)
    private String nome;

    @NotBlank(message = "campo email não pode ser nulo")
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String email;

    @NotBlank(message = "campo cpf não pode ser nulo")
    @Size(min = 1, max = 50)
    @CPF
    @Column(nullable = false, length = 50)
    private String cpf;

    @NotBlank(message = "campo login não pode ser nulo")
    @Column(nullable = false)
    @Size(min = 5, max = 10)
    private String login;

    @NotBlank(message = "campo senha não pode ser nulo")
    @Column(nullable = false)
    @Size(min = 5, max = 10)
    private String senha;

    @NotBlank(message = "campo dataNascimento não pode ser nulo")
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String dataNascimento;

    public Usuario() { }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(String nome, String email, String cpf, String dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }

}

