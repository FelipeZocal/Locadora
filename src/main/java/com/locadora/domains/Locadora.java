package com.locadora.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.locadora.domains.dtos.LocadoraDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "locadora")
public class Locadora {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_locadora")
    private Integer idLocadora;

    @NotNull
    @NotBlank
    private String razaoSocial;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cnpj;

    @NotNull @NotBlank
    private String endereco;

    @NotNull
    @Digits(integer = 15,fraction = 0)
    private int telefone;

    @NotNull
    @Digits(integer = 10,fraction = 0)
    private int carrosDisponiveis;

    @JsonIgnore
    @OneToMany(mappedBy = "locadora")
    private List<Cliente> clientes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "locadora")
    private List<Carro> carros = new ArrayList<>();


    public Locadora() {
    }

    public Locadora(Integer idLocadora, String razaoSocial, String cnpj, String endereco, int telefone, int carrosDisponiveis) {
        this.idLocadora = idLocadora;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.carrosDisponiveis = carrosDisponiveis;
    }

    public Locadora(LocadoraDTO dto) {
        this.idLocadora = dto.getIdLocadora();
        this.razaoSocial = dto.getRazaoSocial();
        this.cnpj = dto.getCnpj();
        this.endereco = dto.getEndereco();
        this.telefone = dto.getTelefone();
        this.carrosDisponiveis = dto.getCarrosDisponiveis();
    }

    public Integer getIdLocadora() {
        return idLocadora;
    }

    public void setIdLocadora(Integer idLocadora) {
        this.idLocadora = idLocadora;
    }

    public @NotNull @NotBlank String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull @NotBlank String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public @NotNull @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull @NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull @NotBlank String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull @NotBlank String endereco) {
        this.endereco = endereco;
    }

    @NotNull
    @Digits(integer = 15, fraction = 0)
    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull @Digits(integer = 15, fraction = 0) int telefone) {
        this.telefone = telefone;
    }

    @NotNull
    @Digits(integer = 10, fraction = 0)
    public int getCarrosDisponiveis() {
        return carrosDisponiveis;
    }

    public void setCarrosDisponiveis(@NotNull @Digits(integer = 10, fraction = 0) int carrosDisponiveis) {
        this.carrosDisponiveis = carrosDisponiveis;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locadora locadora = (Locadora) o;
        return Objects.equals(idLocadora, locadora.idLocadora);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idLocadora);
    }
}
