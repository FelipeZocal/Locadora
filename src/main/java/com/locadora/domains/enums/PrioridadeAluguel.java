package com.locadora.domains.enums;

public enum PrioridadeAluguel {

    IMEDIATO(0, "IMEDIATO"), ESPERA(1, "ESPERA"), APROVADO(2, "APROVADO");

    private Integer id;
    private String prioridadeAluguel;

    PrioridadeAluguel(Integer id, String prioridadeAluguel) {
        this.id = id;
        this.prioridadeAluguel = prioridadeAluguel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrioridadeAluguel() {
        return prioridadeAluguel;
    }

    public void setPrioridadeAluguel(String prioridadeAluguel) {
        this.prioridadeAluguel = prioridadeAluguel;
    }

    public static PrioridadeAluguel toEnum(Integer id){
        if(id==null) return null;
        for (PrioridadeAluguel x : PrioridadeAluguel.values()){
            if (id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Inválido");
    }
}
