package br.com.sistemaEventos.dao;

import java.util.List;

import br.com.sistemaEventos.model.Evento;

public class EventoDAO {

	DAO<Evento> dao = new DAO<Evento>(Evento.class);
	
	public void adicionar(Evento evento) {
		dao.adicionar(evento);
	}
	
	public void remover(Evento evento) {
		dao.remove(evento);
	}
	
	public void atualizar(Evento evento) {
		dao.altera(evento);
	}
	
	public Evento buscaPorId(Integer id) {
		return dao.busca(id);
	}
	
	public List<Evento> listaTodos() {
		return dao.listaTodos();
	}
}
