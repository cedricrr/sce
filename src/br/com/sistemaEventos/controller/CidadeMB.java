package br.com.sistemaEventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaEventos.dao.CidadeDAO;
import br.com.sistemaEventos.dao.UfDAO;
import br.com.sistemaEventos.model.Cidade;
import br.com.sistemaEventos.model.Uf;

@ManagedBean
@ViewScoped
public class CidadeMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Cidade> cidades;
	private Cidade cidade = new Cidade();
	private CidadeDAO dao = new CidadeDAO();
	private Integer idUf;
	private List<Uf> ufs;

	public List<Cidade> getCidades() {
		if (cidades == null) {
			cidades = dao.listaTodos();
		}
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Integer getIdUf() {
		return idUf;
	}

	public void setIdUf(Integer idUf) {
		this.idUf = idUf;
	}

	public List<Uf> getUfs() {
		if(ufs==null) {
			ufs = new UfDAO().listaTodos();
		}
		return ufs;
	}

	public void setUfs(List<Uf> ufs) {
		this.ufs = ufs;
	}

	public String gravar() {
		cidade.setUf(new UfDAO().buscaPorId(idUf));
		dao.adicionar(cidade);
		cidades.add(cidade);
		cidade = new Cidade();
		return null;
	}

	public void deletar(Cidade cidade) {
		dao.remover(cidade);
		cidades.remove(cidade);
	}

	public void alterar() {
		dao.atualizar(cidade);
		cidade = new Cidade();
	}
}
