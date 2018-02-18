package br.com.sistemaEventos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="uf")
public class Uf {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "sigla_uf", length = 2, nullable = false)
	private String sigla;
	@Column(length = 30, nullable = false)
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
