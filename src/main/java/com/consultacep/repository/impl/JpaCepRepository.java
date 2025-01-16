package com.consultacep.repository.impl;

import org.springframework.stereotype.Repository;

import com.consultacep.model.ConsultaCep;
import com.consultacep.repository.CepRepository;
import com.consultacep.repository.ConsultaCepRepository;

@Repository
public class JpaCepRepository implements CepRepository {

	private final ConsultaCepRepository repository = null;

    @Override
    public ConsultaCep salvar(ConsultaCep consulta) {
        return repository.save(consulta);
    }

}
