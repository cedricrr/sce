package br.com.sistemaEventos.dao;

import java.util.List;

import br.com.sistemaEventos.model.Uf;

public class UfDAO {

	DAO<Uf> dao = new DAO<Uf>(Uf.class);
	
	public void adicionar(Uf uf) {
		dao.adicionar(uf);
	}
	
	public void remover(Uf uf) {
		dao.remove(uf);
	}
	
	public void atualizar(Uf uf) {
		dao.altera(uf);
	}
	
	public Uf buscaPorId(Integer id) {
		return dao.busca(id);
	}
	
	public List<Uf> listaTodos() {
		return dao.listaTodos();
	}
}
