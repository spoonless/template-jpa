package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestHibernate {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager em = emf.createEntityManager();
		
		try {
			run(em);
		} finally {
			em.close();
			emf.close();
		}
	}

	private static void run(EntityManager em) {
		System.out.println(em.createNativeQuery("select count(1) from Person").getSingleResult());
	}

}
