package com.locadora.domains.enums;

public enum OrdemAluguel {
    DISPONIVEL(0, "DISPONIVEL"), ANALISE(1, "EM ANALISE"), LOCADO(2, "LOCADO");

    private Integer id;
    private String ordemAluguel;

    OrdemAluguel(Integer id, String ordemAluguel) {
        this.id = id;
        this.ordemAluguel= ordemAluguel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusAlugel() {
        return ordemAluguel;
    }

    public void setStatusAlugel(String ordemAluguel) {
        this.ordemAluguel = ordemAluguel;
    }

    public static OrdemAluguel toEnum(Integer id){
        if(id==null) return null;
        for (OrdemAluguel x : OrdemAluguel.values()){
            if (id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Inválido");
    }

}


