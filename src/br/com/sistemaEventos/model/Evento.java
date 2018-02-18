package br.com.sistemaEventos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="evento")
public class Evento {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(length=200,nullable=false)
	private String descricao;
	@Column(nullable=false, name="inicio_inscricao")
	private Date inicioInscricao;
	@Column(nullable=false, name="termino_inscricao")
	private Date terminoInscricao;
	@Column(nullable=false,columnDefinition="boolean default true")
	private boolean ativo ;
	@Column(name="emite_certificado", length=1,columnDefinition = "character(1) default 'N'")
	private String emiteCertificado = "N";
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_evento_cidade"),name="id_cidade",nullable=false)
	private Cidade cidade;
	private Date horaInicio;
	private Date horaTermino;
	private Integer numeroVaga;
	private Integer cargaHoraria;
	@Column(length=50)
	private String local;
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_evento_pessoa"),name="id_pessoa")
	private Pessoa pessoa;/*ou Palestrante palestrante;*/

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

	public Date getInicioInscricao() {
		return inicioInscricao;
	}

	public void setInicioInscricao(Date inicioInscricao) {
		this.inicioInscricao = inicioInscricao;
	}

	public Date getTerminoInscricao() {
		return terminoInscricao;
	}

	public void setTerminoInscricao(Date terminoInscricao) {
		this.terminoInscricao = terminoInscricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getEmiteCertificado() {
		return emiteCertificado;
	}

	public void setEmiteCertificado(String emiteCertificado) {
		this.emiteCertificado = emiteCertificado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Date horaTermino) {
		this.horaTermino = horaTermino;
	}

	public Integer getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(Integer numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
