package br.com.sistemaEventos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="area")
public class Area {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 200, nullable = false)
	private String descricao;
//	@ManyToOne
//	private Uf uf;
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_area_cidade"),nullable=false,name="id_cidade")
	private Cidade cidade;
	@Column(columnDefinition = "boolean default true")
	private boolean ativo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public Uf getUf() {
//		return uf;
//	}
//
//	public void setUf(Uf uf) {
//		this.uf = uf;
//	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
