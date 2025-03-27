package com.locadora.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.domains.Carro2;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Carro2DTO {

    private Integer idCarro;

    @NotNull(message = "O campo descricao nao pode ser nulo!")
    @NotBlank(message = "O campo descricao nao pode ser vazio!!")
    private String descricao;

    @NotNull(message = "O campo dataAquisicao nao pode ser nulo!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateAquisicao;

    @NotNull(message = "O campo valorAquisicao nao pode ser nulo!")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valorAquisicao;

    @NotNull(message = "O campo nomeProprietario nao pode ser nulo!")
    @NotBlank(message = "O campo nomeProprietario nao pode estar vazio!")
    private String nomeProprietario;

    @NotNull(message = "O campo cpfProprietario nao pode ser nulo!")
    @NotBlank(message = "O campo cpfProprietario nao pode estar vazio!")
    private String cpfProprietario;

    public Carro2DTO() {
    }

    public Carro2DTO(Carro2 carro) {
        this.idCarro = carro.getIdCarro();
        this.descricao = carro.getDescricao();
        this.dateAquisicao = carro.getDateAquisicao();
        this.valorAquisicao = carro.getValorAquisicao();
        this.nomeProprietario = carro.getNomeProprietario();
        this.cpfProprietario = carro.getCpfProprietario();
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public @NotNull(message = "O campo descricao nao pode ser nulo!") @NotBlank(message = "O campo descricao nao pode ser vazio!!") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao nao pode ser nulo!") @NotBlank(message = "O campo descricao nao pode ser vazio!!") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo dataAquisicao nao pode ser nulo!") LocalDate getDateAquisicao() {
        return dateAquisicao;
    }

    public void setDateAquisicao(@NotNull(message = "O campo dataAquisicao nao pode ser nulo!") LocalDate dateAquisicao) {
        this.dateAquisicao = dateAquisicao;
    }

    public @NotNull(message = "O campo nomeProprietario nao pode ser nulo!") @NotBlank(message = "O campo nomeProprietario nao pode estar vazio!") String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(@NotNull(message = "O campo nomeProprietario nao pode ser nulo!") @NotBlank(message = "O campo nomeProprietario nao pode estar vazio!") String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public @NotNull(message = "O campo valorAquisicao nao pode ser nulo!") @Digits(integer = 10, fraction = 2) BigDecimal getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull(message = "O campo valorAquisicao nao pode ser nulo!") @Digits(integer = 10, fraction = 2) BigDecimal valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull(message = "O campo cpfProprietario nao pode ser nulo!") @NotBlank(message = "O campo cpfProprietario nao pode estar vazio!") String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(@NotNull(message = "O campo cpfProprietario nao pode ser nulo!") @NotBlank(message = "O campo cpfProprietario nao pode estar vazio!") String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }
}
