package br.com.sistemaEventos.dao;

import java.util.List;

import br.com.sistemaEventos.model.Cidade;

public class CidadeDAO {

	DAO<Cidade> dao = new DAO<Cidade>(Cidade.class);
	
	public void adicionar(Cidade cidade) {
		dao.adicionar(cidade);
	}
	
	public void remover(Cidade cidade) {
		dao.remove(cidade);
	}
	
	public void atualizar(Cidade cidade) {
		dao.altera(cidade);
	}
	
	public Cidade buscaPorId(Integer id) {
		return dao.busca(id);
	}
	
	public List<Cidade> listaTodos() {
		return dao.listaTodos();
	}
}
