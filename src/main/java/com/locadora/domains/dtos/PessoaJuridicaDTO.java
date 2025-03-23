package com.locadora.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.domains.PessoaJuridica;
import com.locadora.domains.enums.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PessoaJuridicaDTO {

    protected Long id;

    @NotNull(message = "O campo nome não pode ser nulo!")
    @NotBlank(message = "O Campo nome não pode estar vazio!")
    protected String nomeCompleto;

    @NotNull(message = "O campo email não pode ser nulo!")
    @NotBlank(message = "O campo email não pode estar vazio!")
    protected String email;

    @NotNull(message = "O campo senha não pode ser nulo!")
    @NotBlank(message = "O campo senha não pode estar vazio!")
    protected String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();
    protected Set<Integer> tipoPessoa = new HashSet<>();

    public PessoaJuridicaDTO() {}

    public PessoaJuridicaDTO(PessoaJuridica obj) {
        this.id = obj.getId();
        this.nomeCompleto = obj.getNomeCompleto();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.createdAt = obj.getCreatedAt();
        this.tipoPessoa.stream().map(TipoPessoa::toEnum).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O Campo nome não pode estar vazio!") String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(@NotNull(message = "O campo nome não pode ser nulo!") @NotBlank(message = "O Campo nome não pode estar vazio!") String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public @NotNull(message = "O campo email não pode ser nulo!") @NotBlank(message = "O campo email não pode estar vazio!") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "O campo email não pode ser nulo!") @NotBlank(message = "O campo email não pode estar vazio!") String email) {
        this.email = email;
    }

    public @NotNull(message = "O campo senha não pode ser nulo!") @NotBlank(message = "O campo senha não pode estar vazio!") String getSenha() {
        return senha;
    }

    public void setSenha(@NotNull(message = "O campo senha não pode ser nulo!") @NotBlank(message = "O campo senha não pode estar vazio!") String senha) {
        this.senha = senha;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<TipoPessoa> getTipoPessoa() {
        return tipoPessoa == null ? Collections.emptySet() :
                tipoPessoa.stream().map(TipoPessoa::toEnum).collect(Collectors.toSet());
    }

    public void addTipoPessoa (TipoPessoa tipoPessoa) {
        this.tipoPessoa.add(tipoPessoa.getId());
    }
}
