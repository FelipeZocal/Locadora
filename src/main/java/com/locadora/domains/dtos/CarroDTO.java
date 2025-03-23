package com.locadora.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.domains.Carro;
import com.locadora.domains.Locadora;
import com.locadora.domains.enums.Conservacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarroDTO {
    private Integer idCarro;

    @NotNull(message = "O campo marca não pode ser nulo!")
    @NotBlank(message = "O campo marca não pode ser vazio!")
    private String marca;

    @NotNull(message = "O campo modelo não pode ser nulo!")
    @NotBlank(message = "O campo modelo não pode ser vazio!")
    private String modelo;

    @NotNull(message = "O campo cor não pode ser nulo!")
    @NotBlank(message = "O campo cor não pode ser vazio!")
    private String cor;

    @NotNull(message = "O campo anoFabricacao não pode ser nulo!")
    @Digits(integer = 4,fraction = 0)
    private int anoFabricacao;

    @NotNull(message = "O campo valorAluguel não pode ser nulo!")
    @Digits(integer = 10,fraction = 2)
    private BigDecimal valorAluguel;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAluguel;

    @NotNull(message = "O campo placa não pode ser nulo!")
    @NotBlank(message = "O campo placa não pode ser vazio!")
    private String placa;

    @NotNull(message = "O campo quilometragem não pode ser nulo!")
    @Digits(integer = 15,fraction = 0)
    private int quilometragem;

    @NotNull(message = "O campo quantidadePortas não pode ser nulo!")
    @Digits(integer = 1,fraction = 0)
    private int quantidadePortas;

    @NotNull(message = "O campo numeroChassis não pode ser nulo!")
    @NotBlank(message = "O campo numeroChassis não pode ser vazio!")
    private String numeroChassis;

    @NotNull(message = "O campo Locadora é requerido!")
    private int locadora;
    private String razaoSocialLocadora;

    private int conservacao;

    public CarroDTO() {
    }

    public CarroDTO(Carro carro) {
        this.idCarro = carro.getIdCarro();
        this.marca = carro.getMarca();
        this.modelo = carro.getModelo();
        this.cor = carro.getCor();
        this.anoFabricacao = carro.getAnoFabricacao();
        this.valorAluguel = carro.getValorAluguel();
        this.dataAluguel = carro.getDataAluguel();
        this.placa = carro.getPlaca();
        this.quilometragem = carro.getQuilometragem();
        this.quantidadePortas = carro.getQuantidadePortas();
        this.numeroChassis = carro.getNumeroChassis();
        this.locadora = carro.getLocadora().getIdLocadora();
        this.razaoSocialLocadora = carro.getLocadora().getRazaoSocial();
        this.conservacao = carro.getConservacao().getId();
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public @NotNull(message = "O campo marca não pode ser nulo!") @NotBlank(message = "O campo marca não pode ser vazio!") String getMarca() {
        return marca;
    }

    public void setMarca(@NotNull(message = "O campo marca não pode ser nulo!") @NotBlank(message = "O campo marca não pode ser vazio!") String marca) {
        this.marca = marca;
    }

    public @NotNull(message = "O campo modelo não pode ser nulo!") @NotBlank(message = "O campo modelo não pode ser vazio!") String getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull(message = "O campo modelo não pode ser nulo!") @NotBlank(message = "O campo modelo não pode ser vazio!") String modelo) {
        this.modelo = modelo;
    }

    public @NotNull(message = "O campo cor não pode ser nulo!") @NotBlank(message = "O campo cor não pode ser vazio!") String getCor() {
        return cor;
    }

    public void setCor(@NotNull(message = "O campo cor não pode ser nulo!") @NotBlank(message = "O campo cor não pode ser vazio!") String cor) {
        this.cor = cor;
    }

    @NotNull(message = "O campo anoFabricacao não pode ser nulo!")
    @Digits(integer = 4, fraction = 0)
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(@NotNull(message = "O campo anoFabricacao não pode ser nulo!") @Digits(integer = 4, fraction = 0) int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public @NotNull(message = "O campo valorAluguel não pode ser nulo!") @Digits(integer = 10, fraction = 2) BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(@NotNull(message = "O campo valorAluguel não pode ser nulo!") @Digits(integer = 10, fraction = 2) BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public @NotNull(message = "O campo placa não pode ser nulo!") @NotBlank(message = "O campo placa não pode ser vazio!") String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotNull(message = "O campo placa não pode ser nulo!") @NotBlank(message = "O campo placa não pode ser vazio!") String placa) {
        this.placa = placa;
    }

    @NotNull(message = "O campo quilometragem não pode ser nulo!")
    @Digits(integer = 15, fraction = 0)
    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(@NotNull(message = "O campo quilometragem não pode ser nulo!") @Digits(integer = 15, fraction = 0) int quilometragem) {
        this.quilometragem = quilometragem;
    }

    @NotNull(message = "O campo quantidadePortas não pode ser nulo!")
    @Digits(integer = 1, fraction = 0)
    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(@NotNull(message = "O campo quantidadePortas não pode ser nulo!") @Digits(integer = 1, fraction = 0) int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public @NotNull(message = "O campo numeroChassis não pode ser nulo!") @NotBlank(message = "O campo numeroChassis não pode ser vazio!") String getNumeroChassis() {
        return numeroChassis;
    }

    public void setNumeroChassis(@NotNull(message = "O campo numeroChassis não pode ser nulo!") @NotBlank(message = "O campo numeroChassis não pode ser vazio!") String numeroChassis) {
        this.numeroChassis = numeroChassis;
    }

    @NotNull(message = "O campo Locadora é requerido!")
    public int getLocadora() {
        return locadora;
    }

    public void setLocadora(@NotNull(message = "O campo Locadora é requerido!") int locadora) {
        this.locadora = locadora;
    }

    public String getRazaoSocialLocadora() {
        return razaoSocialLocadora;
    }

    public void setRazaoSocialLocadora(String razaoSocialLocadora) {
        this.razaoSocialLocadora = razaoSocialLocadora;
    }

    public int getConservacao() {
        return conservacao;
    }

    public void setConservacao(int conservacao) {
        this.conservacao = conservacao;
    }
}
