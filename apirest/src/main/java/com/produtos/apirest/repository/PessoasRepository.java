package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.model.Pessoa;

public interface PessoasRepository  extends JpaRepository<Pessoa, Long>{

	Pessoa findById(long id); 
	
	
	
}
