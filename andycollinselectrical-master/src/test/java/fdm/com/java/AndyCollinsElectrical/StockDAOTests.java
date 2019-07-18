package fdm.com.java.AndyCollinsElectrical;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class StockDAOTests {
	ArrayList<StockItem> stockList;
	StockItem stockItem;

	@Before
	public void setUp() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		String jpql = "DELETE FROM stockList s";
		entityManager.createQuery(jpql).executeUpdate();
		entityTransaction.commit();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		String jpql = "DELETE FROM stockList s";
		entityManager.createQuery(jpql).executeUpdate();
		entityTransaction.commit();
	}

	@Test
	public void test1() {

		assertEquals(expected, actual);
	}

	@Test
	public void test2() {

		assertEquals(expected, actual);
	}
}
