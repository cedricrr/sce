package br.com.sistemaEventos.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import br.com.sistemaEventos.model.Evento;
import br.com.sistemaEventos.util.JPAUtil;

public class EventoDAO {

	DAO<Evento> dao = new DAO<Evento>(Evento.class);

	public void adicionar(Evento evento) {
		dao.adicionar(evento);
	}

	public void remover(Evento evento) {
		dao.remove(evento);
	}

	public void atualizar(Evento evento) {
		dao.altera(evento);
	}

	public Evento buscaPorId(Integer id) {
		return dao.busca(id);
	}

	public List<Evento> listaTodos() {
		return dao.listaTodos();
	}

	public List<Evento> listaNovos() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Evento> query = cb.createQuery(Evento.class);
		Root<Evento> root = query.from(Evento.class);

		Path<Date> dataInicInsc = root.<Date>get("inicioInscricao");

		query.where(cb.greaterThan(dataInicInsc, cb.currentDate()));

		TypedQuery<Evento> typedQuery = em.createQuery(query);
		List<Evento> lista = typedQuery.getResultList();
		em.close();
		return lista;
	}

	public List<Evento> listaInscAberta() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Evento> query = cb.createQuery(Evento.class);
		Root<Evento> root = query.from(Evento.class);

		Path<Date> dataInicInsc = root.<Date>get("inicioInscricao");
		Path<Date> dataEnceInsc = root.<Date>get("terminoInscricao");

		query.where(cb.between(cb.currentDate(), dataInicInsc, dataEnceInsc));
		
		TypedQuery<Evento> typedQuery = em.createQuery(query);
		List<Evento> lista = typedQuery.getResultList();
		em.close();
		return lista;
	}

	public List<Evento> listaInscEncerrada() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Evento> query = cb.createQuery(Evento.class);
		Root<Evento> root = query.from(Evento.class);

		Path<Date> dataEnceInsc = root.<Date>get("terminoInscricao");

		query.where(cb.greaterThan(cb.currentDate(), dataEnceInsc));

		TypedQuery<Evento> typedQuery = em.createQuery(query);
		List<Evento> lista = typedQuery.getResultList();
		em.close();
		return lista;
	}

}
