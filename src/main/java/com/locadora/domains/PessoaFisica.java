package com.locadora.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.locadora.domains.dtos.PessoaFisicaDTO;
import com.locadora.domains.enums.TipoPessoa;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("FISICA")
public class PessoaFisica extends Pessoa{

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaFisica")
    private List<OrdemServico> ordemServico = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "pessoaFisica")
    private PessoaFisica pessoaFisica;

    public PessoaFisica(Long id, String nomeCompleto, String cpf, String email, String senha) {
        super(id, nomeCompleto, cpf, email, senha);
        addTipoPessoa(TipoPessoa.FISICA);
    }

    public PessoaFisica(PessoaFisicaDTO obj){
        this.id = obj.getId();
        this.nomeCompleto = obj.getNomeCompleto();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.createdAt = obj.getCreateAt();
        this.tipoPessoa = getTipoPessoa().stream()
                .map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.FISICA);
    }

    public PessoaFisica(){
        super();
        addTipoPessoa(TipoPessoa.FISICA);
    }

    public List<OrdemServico> getOrdemServicos() {
        return ordemServico;
    }

    public void setOrdemServicos(List<OrdemServico> ordemServicos) {
        this.ordemServico = ordemServicos;
    }
}
