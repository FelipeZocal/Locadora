package com.locadora.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.domains.dtos.CarroDTO;
import com.locadora.domains.enums.Conservacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carro")
    private Integer idCarro;

    @NotNull @NotBlank
    private String marca;

    @NotNull @NotBlank
    private String modelo;

    @NotNull @NotBlank
    private String cor;

    @NotNull
    @Digits(integer = 4,fraction = 0)
    private int anoFabricacao;

    @NotNull
    @Digits(integer = 10,fraction = 2)
    private BigDecimal valorAluguel;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAluguel;

    @NotNull @NotBlank
    @Column(unique = true)
    private String placa;

    @NotNull
    @Digits(integer = 15,fraction = 0)
    private int quilometragem;

    @NotNull
    @Digits(integer = 1,fraction = 0)
    private int quantidadePortas;

    @NotNull @NotBlank
    private String numeroChassis;

    @ManyToOne
    @JoinColumn(name="idlocadora")
    private Locadora locadora;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "conservacao")
    private Conservacao conservacao;

    public Carro() {
    }

    public Carro(Integer idCarro, String marca, String modelo, String cor, int anoFabricacao, BigDecimal valorAluguel, LocalDate dataAluguel, String placa, int quilometragem, int quantidadePortas, String numeroChassis, Locadora locadora, Conservacao conservacao) {
        this.idCarro = idCarro;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.valorAluguel = valorAluguel;
        this.dataAluguel = dataAluguel;
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.quantidadePortas = quantidadePortas;
        this.numeroChassis = numeroChassis;
        this.locadora = locadora;
        this.conservacao = conservacao;
    }

    public Carro(CarroDTO dto) {
        this.idCarro = dto.getIdCarro();
        this.marca = dto.getMarca();
        this.modelo = dto.getModelo();
        this.cor = dto.getCor();
        this.anoFabricacao = dto.getAnoFabricacao();
        this.valorAluguel = dto.getValorAluguel();
        this.dataAluguel = dto.getDataAluguel();
        this.placa = dto.getPlaca();
        this.quilometragem = dto.getQuilometragem();
        this.quantidadePortas = dto.getQuantidadePortas();
        this.numeroChassis = dto.getNumeroChassis();
        this.locadora = new Locadora();
        this.locadora.setIdLocadora(dto.getLocadora());
        this.conservacao = Conservacao.toEnum(dto.getConservacao());
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public @NotNull @NotBlank String getMarca() {
        return marca;
    }

    public void setMarca(@NotNull @NotBlank String marca) {
        this.marca = marca;
    }

    public @NotNull @NotBlank String getModelo() {
        return modelo;
    }

    public void setModelo(@NotNull @NotBlank String modelo) {
        this.modelo = modelo;
    }

    public @NotNull @NotBlank String getCor() {
        return cor;
    }

    public void setCor(@NotNull @NotBlank String cor) {
        this.cor = cor;
    }

    @NotNull
    @Digits(integer = 4, fraction = 0)
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(@NotNull @Digits(integer = 4, fraction = 0) int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public @NotNull @Digits(integer = 10, fraction = 2) BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(@NotNull @Digits(integer = 10, fraction = 2) BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public @NotNull @NotBlank String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotNull @NotBlank String placa) {
        this.placa = placa;
    }

    @NotNull
    @Digits(integer = 15, fraction = 0)
    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(@NotNull @Digits(integer = 15, fraction = 0) int quilometragem) {
        this.quilometragem = quilometragem;
    }

    @NotNull
    @Digits(integer = 1, fraction = 0)
    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(@NotNull @Digits(integer = 1, fraction = 0) int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public @NotNull @NotBlank String getNumeroChassis() {
        return numeroChassis;
    }

    public void setNumeroChassis(@NotNull @NotBlank String numeroChassis) {
        this.numeroChassis = numeroChassis;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(Conservacao conservacao) {
        this.conservacao = conservacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(idCarro, carro.idCarro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCarro);
    }
}
