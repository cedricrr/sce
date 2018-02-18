package br.com.sistemaEventos.dao;

import java.util.List;

import br.com.sistemaEventos.model.Perfil;

public class PerfilDAO {

	DAO<Perfil> dao = new DAO<Perfil>(Perfil.class);
	
	public void adicionar(Perfil perfil) {
		dao.adicionar(perfil);
	}
	
	public void remover(Perfil perfil) {
		dao.remove(perfil);
	}
	
	public void atualizar(Perfil perfil) {
		dao.altera(perfil);
	}
	
	public Perfil buscaPorId(Integer id) {
		return dao.busca(id);
	}
	
	public List<Perfil> listaTodos() {
		return dao.listaTodos();
	}
}
