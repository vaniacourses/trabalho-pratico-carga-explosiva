package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestSaveAbastecimentoDTO;
import com.cargaexplosiva.api.dto.responseSaveAbastecimentoDTO;
import com.cargaexplosiva.api.model.Abastecimento;
import com.cargaexplosiva.api.repository.AbastecimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AbastecimentoService {
    final AbastecimentoRepository abastecimentoRepository;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public Object save(requestSaveAbastecimentoDTO abastecimentoDTO) {
        var abastecimento = new Abastecimento();
        BeanUtils.copyProperties(abastecimentoDTO, abastecimento);
        abastecimento = abastecimentoRepository.save(abastecimento);
        return new responseSaveAbastecimentoDTO(abastecimento);
    }

    public Abastecimento findById(UUID id) {
        return abastecimentoRepository.findById(id).orElse(null);
    }

    /*public List<Abastecimento> findAllByVeiculoId(UUID veiculoId) {
        return abastecimentoRepository.findByVeiculoId(veiculoId);
    }*/

    public void delete(UUID id) {
        abastecimentoRepository.deleteById(id);
    }
}
