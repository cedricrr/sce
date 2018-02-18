package br.com.sistemaEventos.dao;

import java.util.List;

import br.com.sistemaEventos.model.Area;

public class AreaDAO {

	DAO<Area> dao = new DAO<Area>(Area.class);
	
	public void adicionar(Area area) {
		dao.adicionar(area);
	}
	
	public void remover(Area area) {
		dao.remove(area);
	}
	
	public void atualizar(Area area) {
		dao.altera(area);
	}
	
	public Area buscaPorId(Integer id) {
		return dao.busca(id);
	}
	
	public List<Area> listaTodos() {
		return dao.listaTodos();
	}
}
