package com.locadora.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.locadora.domains.dtos.PessoaJuridicaDTO;
import com.locadora.domains.enums.TipoPessoa;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("JURIDICA")
public class PessoaJuridica extends Pessoa{

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaJuridica")
    private List<OrdemServico> ordemServico = new ArrayList<>();

    public PessoaJuridica(Long id, String nomeCompleto, String cpf, String email, String senha) {
        super(id, nomeCompleto, cpf, email, senha);
        addTipoPessoa(TipoPessoa.JURIDICA);
    }

    public PessoaJuridica(PessoaJuridicaDTO obj){
        this.id = obj.getId();
        this.nomeCompleto = obj.getNomeCompleto();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.createdAt = obj.getCreatedAt();
        this.tipoPessoa = obj.getTipoPessoa().stream()
                .map( x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.JURIDICA);
    }

    public PessoaJuridica(){
        super();
        addTipoPessoa(TipoPessoa.JURIDICA);
    }

    public List<OrdemServico> getOrdemServico() {

        return ordemServico;
    }

    public void setOrdemServicos(List<OrdemServico> ordemServico) {

        this.ordemServico = ordemServico;
    }
}
