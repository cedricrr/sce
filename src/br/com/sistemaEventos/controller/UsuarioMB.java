package br.com.sistemaEventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaEventos.dao.AreaDAO;
import br.com.sistemaEventos.dao.CidadeDAO;
import br.com.sistemaEventos.dao.PerfilDAO;
import br.com.sistemaEventos.dao.UsuarioDAO;
import br.com.sistemaEventos.model.Area;
import br.com.sistemaEventos.model.Perfil;
import br.com.sistemaEventos.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
	private Usuario usuario = new Usuario();
	private UsuarioDAO dao = new UsuarioDAO();
	private Integer idPerfil;
	private List<Perfil> perfis;
	private Integer idArea;
	private List<Area> areas;
	private Area area;

	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			usuarios = dao.listaTodos();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public List<Perfil> getPerfis() {
		if (perfis == null) {
			perfis = new PerfilDAO().listaTodos();
		}
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public List<Area> getAreas() {
		if (areas == null) {
			areas = new AreaDAO().listaTodos();
		}
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String gravar() {
		usuario.setPerfil(new PerfilDAO().buscaPorId(idPerfil));
		dao.adicionar(usuario);
		usuarios.add(usuario);
		usuario = new Usuario();
		return null;
	}

	public void deletar(Usuario usuario) {
		dao.remover(usuario);
		usuarios.remove(usuario);
	}

	public void alterar() {
		dao.atualizar(usuario);
		usuario = new Usuario();
	}
}
