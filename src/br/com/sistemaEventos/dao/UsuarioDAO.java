package br.com.sistemaEventos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.sistemaEventos.model.Usuario;
import br.com.sistemaEventos.util.JPAUtil;

public class UsuarioDAO {

	DAO<Usuario> dao = new DAO<Usuario>(Usuario.class);

	public void adicionar(Usuario usuario) {
		dao.adicionar(usuario);
	}

	public void remover(Usuario usuario) {
		dao.remove(usuario);
	}

	public void atualizar(Usuario usuario) {
		dao.altera(usuario);
	}

	public Usuario buscaPorId(Integer id) {
		return dao.busca(id);
	}

	public List<Usuario> listaTodos() {
		return dao.listaTodos();
	}

	public boolean existe(String cpf, String senha) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = em
				.createQuery("select u from Usuario u where u.pessoa.cpf=:pCpf and senha=md5(:pSenha)", Usuario.class);
		query.setParameter("pCpf", cpf);
		query.setParameter("Senha", senha);
		try {
			Usuario usuario = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Nenhum resultado encontrado!");
			em.close();
			return false;
		}
		em.close();
		return true;
	}
}
