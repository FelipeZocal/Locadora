package com.locadora.domains.enums;

public enum Aprovacao {
    APROVADO(0,"APROVADO"), EMANALISE(1,"EM ANALISE"),RUIM(2,"RUIM"),BANIDO(3,"BANIDO");

    private Integer id;
    private String aprovacao;

    Aprovacao() {
    }

    Aprovacao(Integer id, String aprovacao) {
        this.id = id;
        this.aprovacao = aprovacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(String aprovacao) {
        this.aprovacao = aprovacao;
    }


    public static Aprovacao toEnum(Integer id) {
        if (id == null) return null;
        for (Aprovacao x : Aprovacao.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Aprovação inválida!");
    }

}
