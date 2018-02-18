package br.com.sistemaEventos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "pessoa_evento")
public class PessoaEvento {

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_pessoa_evento_pessoa"),nullable=false, name="id_pessoa")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_pessoa_evento_evento"),nullable=false, name="id_evento")
	private Evento evento;

	@Column(name = "data_inscricao", nullable = false)
	private Date dataInscricao;

	@Column(length = 1, columnDefinition = "character(1) default 'N'")
	private String presenca;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public String getPresenca() {
		return presenca;
	}

	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}

}
