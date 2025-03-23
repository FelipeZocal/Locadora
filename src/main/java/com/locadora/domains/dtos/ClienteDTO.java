package com.locadora.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.domains.Cliente;
import com.locadora.domains.Locadora;
import com.locadora.domains.enums.Aprovacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ClienteDTO {

    private Integer idCliente;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O campo nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "O campo rg não pode ser nulo!")
    @NotBlank(message = "O campo rg não pode ser vazio!")
    private String rg;

    @NotNull(message = "O campo cpf não pode ser nulo!")
    @NotBlank(message = "O campo cpf não pode ser vazio!")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNasc;

    @NotNull(message = "O campo endereco não pode ser nulo!")
    @NotBlank(message = "O campo endereco não pode ser vazio!")
    private String endereco;

    @NotNull(message = "O campo telefone não pode ser nulo!")
    private int telefone;

    @NotNull(message = "O campo historico não pode ser nulo!")
    @NotBlank(message = "O campo historico não pode ser vazio!")
    private String historico;

    @NotNull(message = "O campo locadora é requerido!")
    private int locadora;
    private String razaoSocialLocadora;

    private int aprovacao;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.rg = cliente.getRg();
        this.cpf = cliente.getCpf();
        this.dataNasc = cliente.getDataNasc();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        this.historico = cliente.getHistorico();
        this.locadora = cliente.getLocadora().getIdLocadora();
        this.razaoSocialLocadora = cliente.getLocadora().getRazaoSocial();
        this.aprovacao = cliente.getAprovacao().getId();
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O campo nome não pode ser vazio!") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo rg não pode ser nulo!") @NotBlank(message = "O campo rg não pode ser vazio!") String getRg() {
        return rg;
    }

    public void setRg(@NotNull(message = "O campo rg não pode ser nulo!") @NotBlank(message = "O campo rg não pode ser vazio!") String rg) {
        this.rg = rg;
    }

    public @NotNull(message = "O campo cpf não pode ser nulo!") @NotBlank(message = "O campo cpf não pode ser vazio!") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo cpf não pode ser nulo!") @NotBlank(message = "O campo cpf não pode ser vazio!") String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public @NotNull(message = "O campo endereco não pode ser nulo!") @NotBlank(message = "O campo endereco não pode ser vazio!") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo endereco não pode ser nulo!") @NotBlank(message = "O campo endereco não pode ser vazio!") String endereco) {
        this.endereco = endereco;
    }

    @NotNull(message = "O campo telefone não pode ser nulo!")
    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull(message = "O campo telefone não pode ser nulo!") int telefone) {
        this.telefone = telefone;
    }

    public @NotNull(message = "O campo historico não pode ser nulo!") @NotBlank(message = "O campo historico não pode ser vazio!") String getHistorico() {
        return historico;
    }

    public void setHistorico(@NotNull(message = "O campo historico não pode ser nulo!") @NotBlank(message = "O campo historico não pode ser vazio!") String historico) {
        this.historico = historico;
    }

    @NotNull(message = "O campo locadora é requerido!")
    public int getLocadora() {
        return locadora;
    }

    public void setLocadora(@NotNull(message = "O campo locadora é requerido!") int locadora) {
        this.locadora = locadora;
    }

    public String getRazaoSocialLocadora() {
        return razaoSocialLocadora;
    }

    public void setRazaoSocialLocadora(String razaoSocialLocadora) {
        this.razaoSocialLocadora = razaoSocialLocadora;
    }

    public int getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(int aprovacao) {
        this.aprovacao = aprovacao;
    }
}
