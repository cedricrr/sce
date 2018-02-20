package br.com.sistemaEventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaEventos.dao.CidadeDAO;
import br.com.sistemaEventos.dao.EventoDAO;
import br.com.sistemaEventos.model.Certificado;
import br.com.sistemaEventos.model.Cidade;
import br.com.sistemaEventos.model.Evento;

@ManagedBean
@ViewScoped
public class EventoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Evento> eventos;
	private Evento evento = new Evento();
	private EventoDAO dao = new EventoDAO();
	private Integer idCidade;
	private List<Cidade> cidades;
	private boolean verificaChoque;
	private Certificado certificado;
	private CidadeDAO cidadeDAO = new CidadeDAO();

	public List<Evento> getEventos() {
		if (eventos == null) {
			eventos = dao.listaTodos();
		}
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public List<Cidade> getCidades() {
		if(cidades == null) {
			cidades = cidadeDAO.listaTodos();		
		}
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public boolean isVerificaChoque() {
		return verificaChoque;
	}

	public void setVerificaChoque(boolean verificaChoque) {
		this.verificaChoque = verificaChoque;
	}

	public Certificado getCertificado() {
		return certificado;
	}

	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}

	public String gravar() {
		evento.setCidade(new CidadeDAO().buscaPorId(idCidade));
		dao.adicionar(evento);
		eventos.add(evento);
		evento = new Evento();
		return null;
	}

	public void deletar(Evento evento) {
		dao.remover(evento);
		eventos.remove(evento);
	}

	public void alterar() {
		dao.atualizar(evento);
		evento = new Evento();
	}
}
