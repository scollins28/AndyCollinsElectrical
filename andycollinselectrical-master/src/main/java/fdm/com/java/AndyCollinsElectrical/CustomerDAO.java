package fdm.com.java.AndyCollinsElectrical;

import java.sql.SQLException;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public abstract class CustomerDAO {
	// name of project is constructor arg in Entity Manager
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AndyCollinsElectrical");
	// will use to select or query
	static EntityManager entityManager = emf.createEntityManager();
	// will use to update or alter table data (i.e. crud)
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static boolean addCustomer(Customer customer) throws SQLException {
		if (customer.getCustomerId() > 0) {
			entityTransaction.begin();

			entityManager.persist(customer);

			entityTransaction.commit();

			return true;
		}
		return false;
	}

	public static List<Customer> getAll() {
		String jpql = "SELECT c FROM customerList c";
		TypedQuery<Customer> customerQuery = entityManager.createQuery(jpql, Customer.class);
		List<Customer> customers = customerQuery.getResultList();
		return customers;
	}

	public static Customer getCustomerById(int id) throws SQLException {
		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}

	public static List<Customer> getCustomerByFirstName(String firstName) throws SQLException {
		String jpql = "SELECT c FROM customerList c WHERE c.customerFirstName = :wildcard";
		TypedQuery<Customer> customerQuery = entityManager.createQuery(jpql, Customer.class);
		customerQuery.setParameter("wildcard", firstName);
		List<Customer> customers = customerQuery.getResultList();
		return customers;
	}

	public static List<Customer> getCustomerByLastName(String lastName) throws SQLException {
		String jpql = "SELECT c FROM customerList c WHERE c.customerLastName = :wildcard";
		TypedQuery<Customer> customerQuery = entityManager.createQuery(jpql, Customer.class);
		customerQuery.setParameter("wildcard", lastName);
		List<Customer> customers = customerQuery.getResultList();
		return customers;
	}

	public static List<Customer> getCustomerByAddressOne(String addressOne) throws SQLException {
		String jpql = "SELECT c FROM customerList c WHERE c.addressLineOne LIKE :wildcard";
		TypedQuery<Customer> customerQuery = entityManager.createQuery(jpql, Customer.class);
		customerQuery.setParameter("wildcard", "%" + addressOne + "%");
		List<Customer> customers = customerQuery.getResultList();
		return customers;
	}

	public static List<Customer> getCustomerByAddressTwo(String addressTwo) throws SQLException {
		String jpql = "SELECT c FROM customerList c WHERE c.addressLineTwo LIKE :wildcard";
		TypedQuery<Customer> customerQuery = entityManager.createQuery(jpql, Customer.class);
		customerQuery.setParameter("wildcard", "%" + addressTwo + "%");
		List<Customer> customers = customerQuery.getResultList();
		return customers;
	}

	public static List<Customer> getCustomerByAddressThree(String addressThree) throws SQLException {
		String jpql = "SELECT c FROM customerList c WHERE c.addressLineThree LIKE :wildcard";
		TypedQuery<Customer> customerQuery = entityManager.createQuery(jpql, Customer.class);
		customerQuery.setParameter("wildcard", "%" + addressThree + "%");
		List<Customer> customers = customerQuery.getResultList();
		return customers;
	}

	public static List<Customer> getCustomerByCity(String city) throws SQLException {
		String jpql = "SELECT c FROM customerList c WHERE c.city LIKE :wildcard";
		TypedQuery<Customer> customerQuery = entityManager.createQuery(jpql, Customer.class);
		customerQuery.setParameter("wildcard", city);
		List<Customer> customers = customerQuery.getResultList();
		return customers;
	}

	public static boolean deleteCustomer(int id) throws SQLException {
		Customer customerToDelete = entityManager.find(Customer.class, id);
		if (customerToDelete != null) {
			entityTransaction.begin();
			entityManager.remove(customerToDelete);
			entityTransaction.commit();
			System.out.println("One gone");
			return true;
		}
		return false;
	}

	public static boolean updateCustomer(Customer customer) {
		int customerIdToFind = customer.getCustomerId();
		Customer customerInCustomers = entityManager.find(Customer.class, customerIdToFind);

		if (customerInCustomers != null) {
			entityTransaction.begin();
			entityManager.merge(customer);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
