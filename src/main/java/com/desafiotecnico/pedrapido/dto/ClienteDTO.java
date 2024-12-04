package com.desafiotecnico.pedrapido.dto;

import com.desafiotecnico.pedrapido.entities.Cliente;

import java.time.LocalDate;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String endereco;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String email, String telefone, LocalDate dataNascimento, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public ClienteDTO(Cliente entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        dataNascimento = entity.getDataNascimento();
        endereco = entity.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }
}
