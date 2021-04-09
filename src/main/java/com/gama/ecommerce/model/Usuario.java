package com.gama.ecommerce.model;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "campo nome não pode ser nulo")
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
    @Column(nullable = false, length = 50, unique = true)
    private String cpf;

    @NotBlank(message = "campo login não pode ser nulo")
    @Column(nullable = false, unique = true)
    @Size(min = 5, max = 10)
    private String login;

    @NotBlank(message = "campo senha não pode ser nulo")
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Date dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Usuario() { }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(@NotBlank(message = "campo nome não pode ser nulo") @Size(min = 1, max = 80) String nome, @NotBlank(message = "campo email não pode ser nulo") @Size(min = 1, max = 50) String email, @NotBlank(message = "campo cpf não pode ser nulo") @Size(min = 1, max = 50) @CPF String cpf, @NotBlank(message = "campo login não pode ser nulo") @Size(min = 5, max = 10) String login, @NotBlank(message = "campo senha não pode ser nulo") @Size(min = 5, max = 10) String senha, Date dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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

    public void criptografarSenha() {
        this.senha =  new BCryptPasswordEncoder().encode(senha);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

