package com.consultacep.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.consultacep.model.ConsultaCep;
	import com.consultacep.service.CepService;

@RestController
@RequestMapping("/cep")
public class CepController {
	
    @Autowired
    private CepService service;

    @GetMapping("/{cep}")
    public ConsultaCep consultarCep(@PathVariable String cep) {
        return service.consultarCep(cep);
    }

}
