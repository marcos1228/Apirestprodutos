package com.produtos.apirest.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/* Essa class representa uma entidade no Banco De Dados */

@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {
	private static final long serialVersionUID = -1068039438684085017L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	@NotNull
	private BigDecimal quantidade;
	@NotNull
	private BigDecimal valor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	public Produto get() {
		return null;
	}

	
}
