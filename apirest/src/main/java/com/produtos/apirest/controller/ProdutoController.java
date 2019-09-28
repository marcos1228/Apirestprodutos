package com.produtos.apirest.controller;

import com.produtos.apirest.model.Produto;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController // Anotação que identifica um serviuce Web Restful
@RequestMapping(value = "/api") /* Uma URi padrão para a nossa aplicação */
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("produto/{id}")
	@ApiOperation(value = "Retorna um produto através do Id")
	public Produto listaProdutoUnico(@PathVariable long id) {/* @pathVariable estar anotação a variavél para se pegar pelo id*/

		return produtoRepository.findById(id);
	}

	@PostMapping("/produto")
	@ApiOperation(value= "Salvar produto")
	public Produto salvaProduto(@RequestBody @Valid Produto produto) { /* @RequestBody quer dizer que ele tem que vim no corpo da requisição no formato JSON, Produto é o que vem no corpo da requisição*/
		return produtoRepository.save(produto);

	}

	@DeleteMapping("/produto")
	@ApiOperation(value="Delete Produto")
	public void deleteProduto(@RequestBody @Valid Produto produto) {
		produtoRepository.delete(produto);
	}

	@PutMapping("/produto/{id}")
	@ApiOperation(value="Atualiza produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
		
	}
		
	}

