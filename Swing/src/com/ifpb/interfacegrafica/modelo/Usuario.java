package com.ifpb.interfacegrafica.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Usuario implements Serializable {

    private String email;
    private String nome;
    private LocalDate nascimento;
    private String senha;
    private static final long serialVersionUID = -3794774872648017318L;

    public Usuario(String email, String nome, LocalDate nascimento, String senha) {
        this.email = email;
        this.nome = nome;
        this.nascimento = nascimento;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public boolean autenticar(String email, String senha){
        return this.email.equals(email) && this.senha.equals(senha);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", senha='" + senha + '\'' +
                '}';
    }
}
