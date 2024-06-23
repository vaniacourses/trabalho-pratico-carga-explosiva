package com.cargaexplosiva.api.model;

import java.time.temporal.ChronoUnit;

public class Dirigindo implements HorasTrabalhadas{
    @Override
    public float getHorasTrabalhadas(ControlePresenca controlePresenca) {
        float minutos =
                ChronoUnit.MINUTES.between(controlePresenca.getEntrada().toLocalDateTime(),
                controlePresenca.getSaida().toLocalDateTime());
        return (minutos/60);
    }
}
