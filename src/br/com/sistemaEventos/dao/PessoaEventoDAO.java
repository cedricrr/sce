package br.com.sistemaEventos.dao;

import java.util.List;

import br.com.sistemaEventos.model.PessoaEvento;

public class PessoaEventoDAO {

	DAO<PessoaEvento> dao = new DAO<PessoaEvento>(PessoaEvento.class);
	
	public void adicionar(PessoaEvento pessoaEvento) {
		dao.adicionar(pessoaEvento);
	}
	
	public void remover(PessoaEvento pessoaEvento) {
		dao.remove(pessoaEvento);
	}
	
	public void atualizar(PessoaEvento pessoaEvento) {
		dao.altera(pessoaEvento);
	}
	
	public PessoaEvento buscaPorId(Integer id) {
		return dao.busca(id);
	}
	
	public List<PessoaEvento> listaTodos() {
		return dao.listaTodos();
	}
}
