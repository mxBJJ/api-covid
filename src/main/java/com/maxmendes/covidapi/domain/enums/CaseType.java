package com.maxmendes.covidapi.domain.enums;

public enum CaseType {
    SUSPECT(0, "SINTOMAS"),
    CONFIRMED(1, "CONFIRMADO"),
    DEATH(2, "MORTE");


    private int cod;
    private String covidCase;

    CaseType(int cod, String covidCase) {
        this.cod = cod;
        this.covidCase = covidCase;
    }

    public int getCod() {
        return cod;
    }

    public String getCovidCase() {
        return covidCase;
    }

    public static CaseType toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(CaseType c : CaseType.values()){
            if(cod.equals(c.getCod())){
                return c;
            }
        }

        throw new IllegalArgumentException("O código de status " + cod + " não corresponde.");
    }
}
