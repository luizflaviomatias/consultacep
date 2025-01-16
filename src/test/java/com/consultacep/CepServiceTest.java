package com.consultacep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.consultacep.model.ConsultaCep;
import com.consultacep.repository.ConsultaCepRepository;
import com.consultacep.service.CepService;

public class CepServiceTest {
	
	@InjectMocks
    private CepService cepService;

    @Mock
    private ConsultaCepRepository repository;

    @Mock
    private RestTemplate restTemplate;

    public CepServiceTest() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    public void testConsultarCep() {
        // Simular resposta da API externa
        Map<String, String> apiResponse = Map.of(
                "logradouro", "Praça da Sé",
                "bairro", "Sé",
                "cidade", "São Paulo",
                "estado", "SP"
        );

        // Simular o comportamento do RestTemplate
        when(restTemplate.getForObject(anyString(), eq(Map.class))).thenReturn(apiResponse);

        // Simular o comportamento do repository
        when(repository.save(any(ConsultaCep.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Executar o método de teste
        ConsultaCep consulta = cepService.consultarCep("01001000");

        // Verificar os resultados
        assertEquals("Praça da Sé", consulta.getLogradouro());
        assertEquals("Sé", consulta.getBairro());
        assertEquals("São Paulo", consulta.getCidade());
        assertEquals("SP", consulta.getEstado());
        assertEquals("01001000", consulta.getCep());

        // Verificar se os métodos foram chamados
        verify(restTemplate, times(1)).getForObject(anyString(), eq(Map.class));
        verify(repository, times(1)).save(any(ConsultaCep.class));
    }

}
