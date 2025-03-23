package com.locadora.domains.enums;

public enum Conservacao {
    BOM(0,"BOM"), RAZOAVEL(1,"RAZOAVEL"),RUIM(2,"RUIM"),REFORMA(3,"REFORMA"),PT(3,"PT(PERCA TOTAL)");

    private Integer id;
    private String conservacao;

    Conservacao() {
    }

    Conservacao(Integer id, String conservacao) {
        this.id = id;
        this.conservacao = conservacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConservacao() {
        return conservacao;
    }

    public void setConservacao(String conservacao) {
        this.conservacao = conservacao;
    }

    public static Conservacao toEnum(Integer id) {
        if (id == null) return null;
        for (Conservacao x : Conservacao.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Conservação inválida!");
    }
}
