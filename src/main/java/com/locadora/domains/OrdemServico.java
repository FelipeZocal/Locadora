package com.locadora.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.domains.enums.PrioridadeAluguel;
import com.locadora.domains.enums.OrdemAluguel;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ordemservico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim = LocalDate.now();

    private String tituloOS;
    private String descricao;
    private PrioridadeAluguel prioridadeAluguel;
    private OrdemAluguel ordemAluguel;

    @ManyToOne//relacao muitos para um
    @JoinColumn(name = "idpessoajuridica") //refere ao id da Pessoa Juridica
    private PessoaJuridica pessoaJuridica;

    @ManyToOne
    @JoinColumn(name = "idpessoafisica")
    private PessoaFisica pessoaFisica;


    public OrdemServico() { }
    public OrdemServico(UUID id, String tituloOS, String descricao, PrioridadeAluguel prioridadeAluguel, OrdemAluguel ordemAluguel, PessoaJuridica pessoaJuridica, PessoaFisica pessoaFisica) {
        this.id = id;
        this.tituloOS = tituloOS;
        this.descricao = descricao;
        this.prioridadeAluguel = prioridadeAluguel;
        this.ordemAluguel = ordemAluguel;
        this.pessoaJuridica = pessoaJuridica;
        this.pessoaFisica = pessoaFisica;
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

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getTituloOS() {
        return tituloOS;
    }

    public void setTituloOS(String tituloOS) {
        this.tituloOS = tituloOS;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PrioridadeAluguel getPrioridadeAluguel() {
        return prioridadeAluguel;
    }

    public void setPrioridadeAluguel(PrioridadeAluguel prioridadeAluguel) {
        this.prioridadeAluguel = prioridadeAluguel;
    }

    public OrdemAluguel getStatusAluguel() {
        return ordemAluguel;
    }

    public void setStatusAluguel(OrdemAluguel ordemAluguel) {
        this.ordemAluguel = ordemAluguel;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemServico that = (OrdemServico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
