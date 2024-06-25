package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.model.ControlePresenca;
import com.cargaexplosiva.api.model.Dirigindo;
import com.cargaexplosiva.api.model.Esperando;
import com.cargaexplosiva.api.model.Motorista;
import com.cargaexplosiva.api.repository.ControlePresencaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;

@Service
@Transactional
public class ControlePresencaService {

    final ControlePresencaRepository controlePresencaRepository;
    final MotoristaService motoristaService;

    public ControlePresencaService(ControlePresencaRepository controlePresencaRepository, MotoristaService motoristaService) {
        this.controlePresencaRepository = controlePresencaRepository;
        this.motoristaService = motoristaService;
    }

    private ControlePresenca findPontoAberto(Motorista motorista) {
        return controlePresencaRepository.findByMotoristaAndSaidaIsNull(motorista).orElse(null);
    }

    public boolean compareDate(Timestamp entrada, Timestamp saida){
        int horas =
                (int) ChronoUnit.HOURS.between(entrada.toLocalDateTime(),
                        saida.toLocalDateTime());
        return !(horas > 10);
    }

    public void baterPonto(UserDetails auth, Timestamp data,
                           boolean dirigindo) throws Exception{
        try {
            var motorista = motoristaService.find(auth.getUsername());
            if(motorista != null && motorista.isAtivo()){
                var existPonto = findPontoAberto(motorista);
                if(existPonto != null){
                    if(compareDate(existPonto.getEntrada(), data)){
                        existPonto.setSaida(data);
                        existPonto.calcularHorasTrabalhadas((dirigindo) ?  new Dirigindo() : new Esperando());
                        controlePresencaRepository.save(existPonto);
                    }else{
                        existPonto.setSaida(existPonto.getSaida());
                        existPonto.setHorasDeTrabalhos(0);
                        controlePresencaRepository.save(existPonto);
                    }
                }else {
                    var ponto = new ControlePresenca(motorista, data,
                            (dirigindo) ?  new Dirigindo() : new Esperando());
                    controlePresencaRepository.save(ponto);
                }
            }else{
                throw new Exception("Motorista nao encontrado.");
            }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
