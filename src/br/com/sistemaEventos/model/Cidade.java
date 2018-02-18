package br.com.sistemaEventos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="cidade")
public class Cidade {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 200, nullable = false)
	private String nome;
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_cidade_uf"),name="id_uf",nullable=false)
	private Uf uf;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

}
