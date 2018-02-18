package br.com.sistemaEventos.dao;

import java.util.List;

import br.com.sistemaEventos.model.Pessoa;

public class PessoaDAO {

	DAO<Pessoa> dao = new DAO<Pessoa>(Pessoa.class);
	
	public void adicionar(Pessoa pessoa) {
		dao.adicionar(pessoa);
	}
	
	public void remover(Pessoa pessoa) {
		dao.remove(pessoa);
	}
	
	public void atualizar(Pessoa pessoa) {
		dao.altera(pessoa);
	}
	
	public Pessoa buscaPorId(Integer id) {
		return dao.busca(id);
	}
	
	public List<Pessoa> listaTodos() {
		return dao.listaTodos();
	}
}
