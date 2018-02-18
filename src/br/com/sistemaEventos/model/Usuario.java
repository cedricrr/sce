package br.com.sistemaEventos.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(name = "data_cadastro")
	private Date dataCadastro; // informação contida na tabela pessoa
	@Column(nullable = false, unique = true)
	private String email;
	private boolean ativo = true;
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_usuario_perfil"), name = "id_perfil", nullable = false)
	private Perfil perfil;
	@Column(nullable = false)
	private String senha;
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Pessoa pessoa;

	public Usuario() {
		pessoa = new Pessoa();
	}

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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
