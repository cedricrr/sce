package br.com.sistemaEventos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, length = 150)
	private String nome;
	@Column(nullable = false, length = 20, unique=true)
	private String cpf;
	@Column(columnDefinition="boolean default true")
	private boolean ativo = true;
	@Column(name="data_cadastro",nullable = false) //informação contida na tabela usuario
	private Date dataCadastro;
	@Column(name="data_nascimento",nullable = false)
	private Date dataNascimento;

	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_pessoa_palestrante"),name="id_palestrante")
	private Palestrante palestrante;
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_pessoa_usuario"),name="id_usuario")
	private Usuario usuario;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Palestrante getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
