package com.consultacep.service;

import java.util.Map;

public interface CepClient {

	Map<String, String> consultarCep(String cep);
	
}
