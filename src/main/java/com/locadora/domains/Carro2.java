package com.locadora.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.domains.dtos.Carro2DTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="veiculo2")
public class Carro2 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo2")
    private Integer idCarro;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateAquisicao;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valorAquisicao;

    @NotNull
    @NotBlank
    private String nomeProprietario;

    @NotNull
    @NotBlank
    private String cpfProprietario;

    public Carro2() {

    }

    public Carro2(Integer idCarro, String descricao, LocalDate dateAquisicao, BigDecimal valorAquisicao, String nomeProprietario, String cpfProprietario) {
        this.idCarro = idCarro;
        this.descricao = descricao;
        this.dateAquisicao = dateAquisicao;
        this.valorAquisicao = valorAquisicao;
        this.nomeProprietario = nomeProprietario;
        this.cpfProprietario = cpfProprietario;
    }

    public Carro2(Carro2DTO dto){
        this.idCarro = dto.getIdCarro();
        this.descricao = dto.getDescricao();
        this.dateAquisicao = dto.getDateAquisicao();
        this.valorAquisicao = dto.getValorAquisicao();
        this.nomeProprietario = dto.getNomeProprietario();
        this.cpfProprietario = dto.getCpfProprietario();
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public @NotNull @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank String descricao) {
        this.descricao = descricao;
    }

    public @NotNull LocalDate getDateAquisicao() {
        return dateAquisicao;
    }

    public void setDateAquisicao(@NotNull LocalDate dateAquisicao) {
        this.dateAquisicao = dateAquisicao;
    }

    public @NotNull @Digits(integer = 10, fraction = 2) BigDecimal getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull @Digits(integer = 10, fraction = 2) BigDecimal valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull @NotBlank String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(@NotNull @NotBlank String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public @NotNull @NotBlank String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(@NotNull @NotBlank String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro2 carro2 = (Carro2) o;
        return Objects.equals(idCarro, carro2.idCarro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCarro);
    }
}
