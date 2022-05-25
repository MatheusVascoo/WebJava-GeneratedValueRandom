package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidade.Jogo;
import util.JPAUtil;
//QUESTAO C
public class JogoDAO {
	private static int[] numeros = new int[10];
	
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
	
	public static int[] par(int id) {
		EntityManager em = JPAUtil.criarEntityManager();
		 for (int i = 1; i <= 10; i++){
			 TypedQuery<Integer> consulta = em.createQuery("select j.v"+i+" from Jogo j where j.id = :id order by id",Integer.class).setParameter("id",id);
		     numeros[i-1] = consulta.getSingleResult();
		 }
	     return numeros;
	}
}
