package br.com.sistemaEventos.model;

import java.util.Date;

public class Arquivo {

	private Evento evento;
	private String titulo;
	private Date publicacao;
	private boolean ativo;
	private byte arquivo;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public byte getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte arquivo) {
		this.arquivo = arquivo;
	}

}
