package br.com.sistemaEventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaEventos.dao.PerfilDAO;
import br.com.sistemaEventos.model.Perfil;


@ManagedBean
@ViewScoped
public class PerfilMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Perfil> perfis;
	private Perfil perfil = new Perfil();
	private PerfilDAO dao = new PerfilDAO();
	
	public List<Perfil> getPerfis() {
		if(perfis==null){
			perfis = dao.listaTodos();
		}
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String gravar() {
		dao.adicionar(perfil);
		perfis.add(perfil);
		perfil = new Perfil();
		return null;
	}
	
	public void deletar(Perfil perfil){
		dao.remover(perfil);
		perfis.remove(perfil);
	}
	
	public void alterar(){
		dao.atualizar(perfil);
		perfil = new Perfil();
	}
}
