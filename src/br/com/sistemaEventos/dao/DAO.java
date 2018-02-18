package br.com.sistemaEventos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.sistemaEventos.util.JPAUtil;

public class DAO<C> {

	private Class<C> classe;

	public DAO(Class<C> c) {
		classe = c;
	}

	public void adicionar(C c) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	public void remove(C c) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

	public void altera(C c) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();
	}

	public C busca(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		C resultado = em.find(classe, id);
		em.close();
		return resultado;
	}

	public List<C> listaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<C> query = cb.createQuery(classe);
		Root<C> root = query.from(classe);
		query.select(root);
		List<C> lista = em.createQuery(query).getResultList();
		em.close();
		return lista;
	}
}
