package com.locadora.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.domains.OrdemServico;
import com.locadora.domains.Pessoa;
import com.locadora.domains.PessoaFisica;
import com.locadora.domains.PessoaJuridica;
import com.locadora.domains.enums.OrdemAluguel;
import com.locadora.domains.enums.PrioridadeAluguel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class OrdemServicoDTO {

    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyyy")
    private LocalDate dataInicio = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFIm = LocalDate.now();

    @NotNull(message = "O campo Titulo é requerido!")
    private String tituloOS;

    @NotNull(message = "O campo descrição é requerido!")
    private String descricao;

    @NotNull(message = "O campo prioridadeAluguel não pode ser nulo!")
    @NotBlank(message = "O campo prioridadeAluguel não pode estar vazio!")
    private Integer prioridadeAluguel;

    @NotNull(message = "O campo ordemAluguel é requerido!")
    private Integer ordemStatus;

    @NotNull(message="O campo pessoaJuridica é requerido!")
    private Long pessoaJuridica;

    @NotNull(message="O campo pessoaFisica é requerido!")
    private Long pessoaFisica;
    private String pessoaFisicaNome;
    private String pessoaJuridicaNome;


    public OrdemServicoDTO() {
    }

    public OrdemServicoDTO(OrdemServico ordemServico) {
        this.id = ordemServico.getId();
        this.dataInicio = ordemServico.getDataInicio();
        this.dataFIm = ordemServico.getDataFim();
        this.tituloOS = ordemServico.getTituloOS();
        this.descricao = ordemServico.getDescricao();
        this.prioridadeAluguel = ordemServico.getPrioridadeAluguel().getId();
        this.ordemStatus = ordemServico.getStatusAluguel().getId();
        this.pessoaJuridica = ordemServico.getPessoaJuridica().getId();
        this.pessoaFisica = ordemServico.getPessoaFisica().getId();
        this.pessoaFisicaNome = ordemServico.getPessoaFisica().getNomeCompleto() + " ";
        this.pessoaJuridicaNome = ordemServico.getPessoaJuridica().getNomeCompleto() +"";
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFIm() {
        return dataFIm;
    }

    public void setDataFIm(LocalDate dataFIm) {
        this.dataFIm = dataFIm;
    }

    public @NotNull(message = "O campo Titulo é requerido!") String getTituloOS() {
        return tituloOS;
    }

    public void setTituloOS(@NotNull(message = "O campo Titulo é requerido!") String tituloOS) {
        this.tituloOS = tituloOS;
    }

    public @NotNull(message = "O campo descrição é requerido!") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição é requerido!") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo prioridadeAluguel não pode ser nulo!") @NotBlank(message = "O campo prioridadeAluguel não pode estar vazio!") Integer getPrioridadeAluguel() {
        return prioridadeAluguel;
    }

    public void setPrioridadeAluguel(@NotNull(message = "O campo prioridadeAluguel não pode ser nulo!") @NotBlank(message = "O campo prioridadeAluguel não pode estar vazio!") Integer prioridadeAluguel) {
        this.prioridadeAluguel = prioridadeAluguel;
    }

    public @NotNull(message = "O campo ordemAluguel é requerido!") Integer getOrdemStatus() {
        return ordemStatus;
    }

    public void setOrdemStatus(@NotNull(message = "O campo ordemAluguel é requerido!") Integer ordemStatus) {
        this.ordemStatus = ordemStatus;
    }

    public @NotNull(message = "O campo pessoaJuridica é requerido!") Long getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(@NotNull(message = "O campo pessoaJuridica é requerido!") Long pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public @NotNull(message = "O campo pessoaFisica é requerido!") Long getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(@NotNull(message = "O campo pessoaFisica é requerido!") Long pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public String getPessoaFisicaNome() {
        return pessoaFisicaNome;
    }

    public void setPessoaFisicaNome(String pessoaFisicaNome) {
        this.pessoaFisicaNome = pessoaFisicaNome;
    }

    public String getPessoaJuridicaNome() {
        return pessoaJuridicaNome;
    }

    public void setPessoaJuridicaNome(String pessoaJuridicaNome) {
        this.pessoaJuridicaNome = pessoaJuridicaNome;
    }
}
