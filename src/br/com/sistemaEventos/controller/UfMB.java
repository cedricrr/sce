package br.com.sistemaEventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaEventos.dao.UfDAO;
import br.com.sistemaEventos.model.Uf;


@ManagedBean
@ViewScoped
public class UfMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Uf> ufs;
	private Uf uf = new Uf();
	private UfDAO dao = new UfDAO();
	
	public List<Uf> getUfs() {
		if(ufs==null){
			ufs = dao.listaTodos();
		}
		return ufs;
	}

	public void setUfs(List<Uf> ufs) {
		this.ufs = ufs;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String gravar() {
		dao.adicionar(uf);
		ufs.add(uf);
		uf = new Uf();
		return null;
	}
	
	public void deletar(Uf uf){
		dao.remover(uf);
		ufs.remove(uf);
	}
	
	public void alterar(){
		dao.atualizar(uf);
		uf = new Uf();
	}
}
