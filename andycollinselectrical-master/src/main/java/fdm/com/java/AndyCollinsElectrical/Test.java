package fdm.com.java.AndyCollinsElectrical;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AndyCollinsElectrical");
		// will use to select or query
		EntityManager entityManager = emf.createEntityManager();
		// will use to update or alter table data (i.e. crud)
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		String jpql = "SELECT c FROM customerList c WHERE c.customerFirstName = :customerFirstName";
		TypedQuery<Customer> customerQuery = entityManager.createQuery(jpql, Customer.class);

	}

}
