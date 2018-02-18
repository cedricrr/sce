package br.com.sistemaEventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaEventos.dao.AreaDAO;
import br.com.sistemaEventos.dao.CidadeDAO;
import br.com.sistemaEventos.model.Area;
import br.com.sistemaEventos.model.Cidade;

@ManagedBean
@ViewScoped
public class AreaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Area> areas;
	private Area area = new Area();
	private AreaDAO dao = new AreaDAO();
	private Integer idCidade;
	private List<Cidade> cidades;

	public List<Area> getAreas() {
		if (areas == null) {
			areas = dao.listaTodos();
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

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public List<Cidade> getCidades() {
		if (cidades == null) {
			cidades = new CidadeDAO().listaTodos();
		}
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public String gravar() {
		area.setCidade(new CidadeDAO().buscaPorId(idCidade));
		dao.adicionar(area);
		areas.add(area);
		area = new Area();
		return null;
	}

	public void deletar(Area area) {
		dao.remover(area);
		areas.remove(area);
	}

	public void alterar() {
		dao.atualizar(area);
		area = new Area();
	}
}
