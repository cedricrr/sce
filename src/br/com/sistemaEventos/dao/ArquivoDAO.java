package br.com.sistemaEventos.dao;

import java.util.List;

import br.com.sistemaEventos.model.Arquivo;

public class ArquivoDAO {

	DAO<Arquivo> dao = new DAO<Arquivo>(Arquivo.class);
	
	public void adicionar(Arquivo area) {
		dao.adicionar(area);
	}
	
	public void remover(Arquivo area) {
		dao.remove(area);
	}
	
	public void atualizar(Arquivo area) {
		dao.altera(area);
	}
	
	public Arquivo buscaPorId(Integer id) {
		return dao.busca(id);
	}
	
	public List<Arquivo> listaTodos() {
		return dao.listaTodos();
	}
}
