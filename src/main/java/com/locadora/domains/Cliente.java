package com.locadora.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.locadora.domains.dtos.ClienteDTO;
import com.locadora.domains.enums.Aprovacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    private Integer idCliente;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    @Column(unique = true)
    private String rg;

    @NotNull @NotBlank
    @Column(unique = true)
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNasc;

    @NotNull @NotBlank
    private String endereco;

    @NotNull
    private int telefone;

    @NotNull @NotBlank
    private String historico;

    @ManyToOne
    @JoinColumn(name="idlocadora")
    private Locadora locadora;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "aprovacao")
    private Aprovacao aprovacao;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nome, String rg, String cpf, LocalDate dataNasc, String endereco, int telefone, String historico, Locadora locadora, Aprovacao aprovacao) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.historico = historico;
        this.locadora = locadora;
        this.aprovacao = aprovacao;
    }

    public Cliente(ClienteDTO dto) {
        this.idCliente = dto.getIdCliente();
        this.nome = dto.getNome();
        this.rg = dto.getRg();
        this.cpf = dto.getCpf();
        this.dataNasc = dto.getDataNasc();
        this.endereco = dto.getEndereco();
        this.telefone = dto.getTelefone();
        this.historico = dto.getHistorico();
        this.locadora = new Locadora();
        this.locadora.setIdLocadora(dto.getLocadora());
        this.aprovacao = Aprovacao.toEnum(dto.getAprovacao());
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank String getRg() {
        return rg;
    }

    public void setRg(@NotNull @NotBlank String rg) {
        this.rg = rg;
    }

    public @NotNull @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull @NotBlank String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public @NotNull @NotBlank String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull @NotBlank String endereco) {
        this.endereco = endereco;
    }

    @NotNull
    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull int telefone) {
        this.telefone = telefone;
    }

    public @NotNull @NotBlank String getHistorico() {
        return historico;
    }

    public void setHistorico(@NotNull @NotBlank String historico) {
        this.historico = historico;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public Aprovacao getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Aprovacao aprovacao) {
        this.aprovacao = aprovacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCliente);
    }
}
