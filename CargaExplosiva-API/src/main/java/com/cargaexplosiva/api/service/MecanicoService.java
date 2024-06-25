package com.cargaexplosiva.api.service;

import com.cargaexplosiva.api.dto.requestRegisterMecanicoDTO;
import com.cargaexplosiva.api.model.FuncionarioRole;
import com.cargaexplosiva.api.model.Mecanico;
import com.cargaexplosiva.api.repository.MecanicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MecanicoService {

    final MecanicoRepository mecanicoRepository;

    public MecanicoService(MecanicoRepository mecanicoRepository) {
        this.mecanicoRepository = mecanicoRepository;
    }

    public void save(requestRegisterMecanicoDTO mecanicoDTO) {
        var mecanico = new Mecanico();
        BeanUtils.copyProperties(mecanicoDTO, mecanico);
        mecanico.setPassword(new BCryptPasswordEncoder().encode(mecanicoDTO.password()));
        mecanico.setRole(FuncionarioRole.MECANICO);
        mecanicoRepository.save(mecanico);
    }
}
