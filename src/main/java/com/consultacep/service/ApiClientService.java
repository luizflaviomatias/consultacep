package com.consultacep.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiClientService {
	
	private final RestTemplate restTemplate;

    public ApiClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, String> consultarCepApi(String cep) {
        String apiUrl = "http://localhost:8080/api/cep";
        return restTemplate.getForObject(apiUrl + "/" + cep, Map.class);
    }

}
