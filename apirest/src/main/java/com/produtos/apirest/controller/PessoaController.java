package com.produtos.apirest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.produtos.apirest.model.Pessoa;
import com.produtos.apirest.repository.PessoasRepository;

@RestController
@RequestMapping(value = "/api")
public class PessoaController {
	@Autowired
	PessoasRepository pessoarepository;

	@GetMapping("/pessoas") /*
							 * Método que buscar uma lista de pessoas no Banco de Dados Através do Verbo
							 * HTTP Get que tem por sua finalidad Pegar algo
							 */
	public List<Pessoa> listapessoas() {
		return pessoarepository.findAll();
	}

	@GetMapping("/pessoa/{id}")
	public Pessoa listaunico(@PathVariable(value = "id") long id) {
		return pessoarepository.findById(id);
	}

	@PostMapping("pessoa")
	public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
		return pessoarepository.save(pessoa);
	}

	@DeleteMapping("/pessoa")
	public void deletePessoa(@RequestBody Pessoa pessoa) {
		pessoarepository.delete(pessoa);
	}

	@PutMapping("/pessoa")
	public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
		return pessoarepository.save(pessoa);
	}
}
