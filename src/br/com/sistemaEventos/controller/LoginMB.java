package br.com.sistemaEventos.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.sistemaEventos.dao.UsuarioDAO;
import br.com.sistemaEventos.model.Evento;

@ManagedBean
public class LoginMB {

	private String cpf;
	private String senha;
	private Integer idEvento;
	private List<Evento> eventos;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public String logar() {

		if (new UsuarioDAO().existe(cpf, senha)) {
			return "usuario";
		}
		senha = "";
		System.out.println("nao encontrado");
		return null;
	}

}
