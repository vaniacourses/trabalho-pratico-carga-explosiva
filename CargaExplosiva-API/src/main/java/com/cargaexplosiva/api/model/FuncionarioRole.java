package com.cargaexplosiva.api.model;

public enum FuncionarioRole{

    ADMINISTRADOR("administrador"),
    GERENTE_FROTA("gerente_frota"),
    GERENTE_MECANICO("gerente_mecanico"),
    MECANICO("mecanico"),
    MOTORISTA("motorista");

    private final String role;

    FuncionarioRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
