package br.com.sistemaEventos.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.sistemaEventos.dao.EventoDAO;
import br.com.sistemaEventos.dao.UsuarioDAO;
import br.com.sistemaEventos.model.Evento;

@ManagedBean
public class LoginMB {

	private String cpf;
	private String senha;
	private Integer idEvento;
	private EventoDAO eventoDAO = new EventoDAO();
	private List<Evento> evNovos;
	private List<Evento> evInscAber;
	private List<Evento> evInscEnce;

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

	public List<Evento> getEvNovos() {
		if (evNovos == null) {
			evNovos = eventoDAO.listaNovos();
		}
		return evNovos;
	}

	public void setEvNovos(List<Evento> evNovos) {
		this.evNovos = evNovos;
	}

	public List<Evento> getEvInscAber() {
		if (evInscAber == null) {
			evInscAber = eventoDAO.listaInscAberta();
		}
		return evInscAber;
	}

	public void setEvInscAber(List<Evento> evInscAber) {
		this.evInscAber = evInscAber;
	}

	public List<Evento> getEvInscEnce() {
		if (evInscEnce == null) {
			evInscEnce = eventoDAO.listaInscEncerrada();
		}
		return evInscEnce;
	}

	public void setEvInscEnce(List<Evento> evInscEnce) {
		this.evInscEnce = evInscEnce;
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
