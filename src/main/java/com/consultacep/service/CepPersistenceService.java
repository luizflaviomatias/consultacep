package com.consultacep.service;

import com.consultacep.model.ConsultaCep;
import com.consultacep.repository.ConsultaCepRepository;

public class CepPersistenceService {

	private final ConsultaCepRepository repository;

    public CepPersistenceService(ConsultaCepRepository repository) {
        this.repository = repository;
    }

    public ConsultaCep salvarConsulta(ConsultaCep consulta) {
        return repository.save(consulta);
    }
	
}
