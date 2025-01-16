package com.consultacep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultacep.model.ConsultaCep;

public interface ConsultaCepRepository extends JpaRepository<ConsultaCep, Long> {
	
}
