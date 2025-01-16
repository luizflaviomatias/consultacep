package com.consultacep.serviceimpl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consultacep.service.CepClient;

@Service
public class CorreiosApiClient implements CepClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Map<String, String> consultarCep(String cep) {
        String apiUrl = "http://localhost:8080/api/cep";
        return restTemplate.getForObject(apiUrl + "/" + cep, Map.class);
    }
}
