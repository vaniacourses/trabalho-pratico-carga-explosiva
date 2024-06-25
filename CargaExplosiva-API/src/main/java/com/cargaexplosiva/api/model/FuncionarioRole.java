package com.cargaexplosiva.api.model;

public enum FuncionarioRole{

    ADMINISTRADOR("ADMINISTRADOR"),
    GERENTE_FROTA("GERENTE-FROTA"),
    GERENTE_MECANICO("GERENTE-MECANICO"),
    MECANICO("MECANICO"),
    MOTORISTA("MOTORISTA");

    private final String role;

    FuncionarioRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
