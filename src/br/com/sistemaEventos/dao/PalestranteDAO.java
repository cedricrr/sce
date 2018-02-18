package br.com.sistemaEventos.dao;

import java.util.List;

import br.com.sistemaEventos.model.Palestrante;

public class PalestranteDAO {

	DAO<Palestrante> dao = new DAO<Palestrante>(Palestrante.class);
	
	public void adicionar(Palestrante palestrante) {
		dao.adicionar(palestrante);
	}
	
	public void remover(Palestrante palestrante) {
		dao.remove(palestrante);
	}
	
	public void atualizar(Palestrante palestrante) {
		dao.altera(palestrante);
	}
	
	public Palestrante buscaPorId(Integer id) {
		return dao.busca(id);
	}
	
	public List<Palestrante> listaTodos() {
		return dao.listaTodos();
	}
}
