package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogo;
import util.JPAUtil;

public class JogoDAO {
	public static void salvar(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(jogo);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(jogo);
		em.getTransaction().commit();
		em.close();
	}
	public static void excluir(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();//begin transaction
		em.remove(em.contains(jogo) ? jogo : em.merge(jogo));
		em.getTransaction().commit();//commit
		em.close();
	}
	public static List<Jogo> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select j from Jogo j order by id");
		List<Jogo> lista = q.getResultList();
		em.close();
		return lista;
	}

}
