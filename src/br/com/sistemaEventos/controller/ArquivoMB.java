package br.com.sistemaEventos.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import br.com.sistemaEventos.dao.ArquivoDAO;
import br.com.sistemaEventos.dao.EventoDAO;
import br.com.sistemaEventos.model.Arquivo;
import br.com.sistemaEventos.model.Evento;

@ManagedBean
@ViewScoped
public class ArquivoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Arquivo> arquivos;
	private Arquivo arquivo = new Arquivo();
	private ArquivoDAO dao = new ArquivoDAO();
	private Integer idEvento;
	private List<Evento> eventos;

	public List<Arquivo> getArquivos() {
		if (arquivos == null) {
			arquivos = dao.listaTodos();
		}
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public String gravar() {
		arquivo.setEvento(new EventoDAO().buscaPorId(idEvento));
		dao.adicionar(arquivo);
		arquivos.add(arquivo);
		arquivo = new Arquivo();
		return null;
	}

	public void deletar(Arquivo arquivo) {
		dao.remover(arquivo);
		arquivos.remove(arquivo);
	}

	public void alterar() {
		dao.atualizar(arquivo);
		arquivo = new Arquivo();
	}
	
	public void fileUpload(FileUploadEvent event) {
		System.out.println("Upload do arquivo " +event.getFile().getFileName()+ "realizado com sucesso!");
	}
}
