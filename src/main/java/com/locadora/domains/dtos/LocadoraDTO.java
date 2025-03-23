package com.locadora.domains.dtos;

import com.locadora.domains.Locadora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LocadoraDTO {

    private Integer idLocadora;

    @NotNull(message = "O campo razaoSocial não pode ser nulo!")
    @NotBlank(message = "O campo razaoSocial não pode ser vazio!")
    private String razaoSocial;

    @NotNull(message = "O campo cnpj não pode ser nulo!")
    @NotBlank(message = "O campo cnpj não pode ser vazio!")
    private String cnpj;

    @NotNull(message = "O campo endereco não pode ser nulo!")
    @NotBlank(message = "O campo endereco não pode ser vazio!")
    private String endereco;

    @NotNull(message = "O campo telefone não pode ser nulo!")
    private int telefone;

    @NotNull(message = "O campo carrosDisponiveis não pode ser nulo!")
    private int carrosDisponiveis;

    public LocadoraDTO() {
    }

    public LocadoraDTO(Locadora locadora) {
        this.idLocadora = locadora.getIdLocadora();
        this.razaoSocial = locadora.getRazaoSocial();
        this.cnpj = locadora.getCnpj();
        this.endereco = locadora.getEndereco();
        this.telefone = locadora.getTelefone();
        this.carrosDisponiveis = locadora.getCarros() != null ? locadora.getCarros().size() : 0;;
    }

    public Integer getIdLocadora() {
        return idLocadora;
    }

    public void setIdLocadora(Integer idLocadora) {
        this.idLocadora = idLocadora;
    }

    public @NotNull(message = "O campo razaoSocial não pode ser nulo!") @NotBlank(message = "O campo razaoSocial não pode ser vazio!") String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull(message = "O campo razaoSocial não pode ser nulo!") @NotBlank(message = "O campo razaoSocial não pode ser vazio!") String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public @NotNull(message = "O campo cnpj não pode ser nulo!") @NotBlank(message = "O campo cnpj não pode ser vazio!") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo cnpj não pode ser nulo!") @NotBlank(message = "O campo cnpj não pode ser vazio!") String cnpj) {
        this.cnpj = cnpj;
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

    @NotNull(message = "O campo carrosDisponiveis não pode ser nulo!")
    public int getCarrosDisponiveis() {
        return carrosDisponiveis;
    }

    public void setCarrosDisponiveis(@NotNull(message = "O campo carrosDisponiveis não pode ser nulo!") int carrosDisponiveis) {
        this.carrosDisponiveis = carrosDisponiveis;
    }
}
