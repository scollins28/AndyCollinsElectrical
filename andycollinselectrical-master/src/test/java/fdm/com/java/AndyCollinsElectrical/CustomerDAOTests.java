package fdm.com.java.AndyCollinsElectrical;

import static org.junit.Assert.*;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class CustomerDAOTests {

	ArrayList<Customer> customers;
	Customer customer;
	CustomerDAO customerDAO;

	@Before
	public void setUp() throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AndyCollinsElectrical");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		String jpql = "DELETE FROM customerList c";
		entityManager.createQuery(jpql).executeUpdate();
		entityTransaction.commit();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AndyCollinsElectrical");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		String jpql = "DELETE FROM customerList c";
		entityManager.createQuery(jpql).executeUpdate();
		entityTransaction.commit();
	}

	@Test
	public void getAllCustomersReturnsAnEmptyArrayListWhenTheCustomersDatabaseIsEmpty() {
		List<Customer> customers = CustomerDAO.getAll();
		assertEquals(0, customers.size());
	}

	@Test
	public void getAllCustomersReturnsAnArrayListOfOneWhenTheCustomersDatabaseHasOneCustomer() {
		Customer customer = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", -1);

		try {
			CustomerDAO.addCustomer(customer);
			System.out.println("Succeeded");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("FAILED");
			e1.printStackTrace();
		}

		List<Customer> customers = CustomerDAO.getAll();
		assertEquals(1, customers.size());
	}

	@Test
	public void getAllCustomersReturnsAnArrayListOfOneWhenTheCustomersDatabaseHasTwoCustomers() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Customer> customers = CustomerDAO.getAll();
		System.out.println(customers.size());

		assertEquals(2, customers.size());
	}

	@Test
	public void getCustomerByIdReturnsCustomerTwoWhenCustomersTwoPassedIn() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerToTest = new Customer();

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			customerToTest = CustomerDAO.getCustomerById(2);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals("Lidiia", customerToTest.getCustomerFirstName());
	}

	@Test
	public void getCustomerByIdReturnsNothingWhenCustomerOneGreaterThanDatabaseSizePassedIn() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerThree = new Customer(3, "Dimitry", "Budarin", "5 York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07123456789", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFour = new Customer(4, "Egle", "Vaitmonaite", "5 York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07987654321", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFive = new Customer(5, "Amadea", "Pal", "Somewhere near", "Elephant and Castle", "", "London",
				"??? ????", "07456789123", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerToTest = new Customer();

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			CustomerDAO.addCustomer(customerThree);
			CustomerDAO.addCustomer(customerFour);
			CustomerDAO.addCustomer(customerFive);
			customerToTest = CustomerDAO.getCustomerById(5);
			customerToTest.getCustomerId();

		} catch (NullPointerException | SQLException e) {
			assertTrue(!e.equals(null));
		}
	}

	@Test
	public void getCustomerByFirstNameReturnsCustomerFiveWhenCustomerFirstNamePassedInToADatabaseOfFive() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerThree = new Customer(3, "Dimitry", "Budarin", "5 York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07123456789", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFour = new Customer(4, "Egle", "Vaitmonaite", "5 York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07987654321", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFive = new Customer(5, "Amadea", "Pal", "Somewhere near", "Elephant and Castle", "", "London",
				"??? ????", "07456789123", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		List<Customer> customers = null;

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			CustomerDAO.addCustomer(customerThree);
			CustomerDAO.addCustomer(customerFour);
			CustomerDAO.addCustomer(customerFive);
			customers = CustomerDAO.getCustomerByFirstName("Amadea");
		} catch (NullPointerException | SQLException e) {
			assertTrue(e.equals(null));
		}
		assertEquals("Amadea", customers.get(0).getCustomerFirstName());
	}
	
	@Test
	public void getCustomerByLastNameReturnsCustomerOneWhenCustomerLastNamePassedInToADatabaseOfFive() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerThree = new Customer(3, "Dimitry", "Budarin", "5 York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07123456789", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFour = new Customer(4, "Egle", "Vaitmonaite", "5 York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07987654321", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFive = new Customer(5, "Amadea", "Pal", "Somewhere near", "Elephant and Castle", "", "London",
				"??? ????", "07456789123", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		List<Customer> customers = null;

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			CustomerDAO.addCustomer(customerThree);
			CustomerDAO.addCustomer(customerFour);
			CustomerDAO.addCustomer(customerFive);
			customers = CustomerDAO.getCustomerByLastName("Collins");
		} catch (NullPointerException | SQLException e) {
			System.out.println("NPE thrown");
			assertTrue(e.equals(null));
		}
		assertEquals("Collins", customers.get(0).getCustomerLastName());
	}
	
	@Test
	public void getCustomerByAddressLineOneReturnsThreeCustomersWhenCustomerYorkPassedInToADatabaseOfFive() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerThree = new Customer(3, "Dimitry", "Budarin", "5 York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07123456789", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFour = new Customer(4, "Egle", "Vaitmonaite", "York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07987654321", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFive = new Customer(5, "Amadea", "Pal", "Somewhere near", "Elephant and Castle", "", "London",
				"??? ????", "07456789123", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		List<Customer> customers = null;

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			CustomerDAO.addCustomer(customerThree);
			CustomerDAO.addCustomer(customerFour);
			CustomerDAO.addCustomer(customerFive);
			customers = CustomerDAO.getCustomerByAddressOne("York");
		} catch (NullPointerException | SQLException e) {
			assertTrue(e.equals(null));
		}
		assertEquals(3, customers.size());
	}
	
	@Test
	public void getCustomerByAddressLineTwoReturnsOneCustomerWhenCustomerElePassedInToADatabaseOfFive() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerThree = new Customer(3, "Dimitry", "Budarin", "5 York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07123456789", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFour = new Customer(4, "Egle", "Vaitmonaite", "York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07987654321", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFive = new Customer(5, "Amadea", "Pal", "Somewhere near", "Elephant and Castle", "", "London",
				"??? ????", "07456789123", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		List<Customer> customers = null;

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			CustomerDAO.addCustomer(customerThree);
			CustomerDAO.addCustomer(customerFour);
			CustomerDAO.addCustomer(customerFive);
			customers = CustomerDAO.getCustomerByAddressTwo("Ele");
		} catch (NullPointerException | SQLException e) {
			assertTrue(e.equals(null));
		}
		assertEquals(1, customers.size());
	}
	
	@Test
	public void getCustomerByAddressLineThreeReturnstTwoCustomersWhenCustomerhamPassedInToADatabaseOfFive() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "Newham", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerThree = new Customer(3, "Dimitry", "Budarin", "5 York House", "4 De Quincey Mews", "Newham",
				"London", "E16 1SU", "07123456789", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFour = new Customer(4, "Egle", "Vaitmonaite", "York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07987654321", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFive = new Customer(5, "Amadea", "Pal", "Somewhere near", "Elephant and Castle", "", "London",
				"??? ????", "07456789123", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		List<Customer> customers = null;

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			CustomerDAO.addCustomer(customerThree);
			CustomerDAO.addCustomer(customerFour);
			CustomerDAO.addCustomer(customerFive);
			customers = CustomerDAO.getCustomerByAddressThree("ham");
		} catch (NullPointerException | SQLException e) {
			assertTrue(e.equals(null));
		}
		assertEquals(2, customers.size());
	}
	
	@Test
	public void getCustomerByCityReturnstFiveCustomersWhenLondonPassedInToADatabaseOfFive() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "Newham", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerThree = new Customer(3, "Dimitry", "Budarin", "5 York House", "4 De Quincey Mews", "Newham",
				"London", "E16 1SU", "07123456789", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFour = new Customer(4, "Egle", "Vaitmonaite", "York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07987654321", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFive = new Customer(5, "Amadea", "Pal", "Somewhere near", "Elephant and Castle", "", "London",
				"??? ????", "07456789123", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		List<Customer> customers = null;

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			CustomerDAO.addCustomer(customerThree);
			CustomerDAO.addCustomer(customerFour);
			CustomerDAO.addCustomer(customerFive);
			customers = CustomerDAO.getCustomerByCity("London");
		} catch (NullPointerException | SQLException e) {
			assertTrue(e.equals(null));
		}
		assertEquals(5, customers.size());
	}
	
	
	@Test
	public void deleteCustomerReturnstTrueWhenCustomerId2PassedIn() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "Newham", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerThree = new Customer(3, "Dimitry", "Budarin", "5 York House", "4 De Quincey Mews", "Newham",
				"London", "E16 1SU", "07123456789", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFour = new Customer(4, "Egle", "Vaitmonaite", "York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07987654321", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFive = new Customer(5, "Amadea", "Pal", "Somewhere near", "Elephant and Castle", "", "London",
				"??? ????", "07456789123", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		boolean successfulDelete = false;

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			CustomerDAO.addCustomer(customerThree);
			CustomerDAO.addCustomer(customerFour);
			CustomerDAO.addCustomer(customerFive);
			successfulDelete = CustomerDAO.deleteCustomer(2);
		} catch (NullPointerException | SQLException e) {
			assertTrue(e.equals(null));
		}
		assertEquals(true, successfulDelete);
	}
	
	@Test
	public void updateCustomerReturnsTrueWhenUpdatedCustomerPassedIn() {
		Customer customerOne = new Customer(1, "Steve", "Collins", "5 York House", "4 De Quincey Mews", "Newham", "London",
				"E16 1SU", "07899985583", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerTwo = new Customer(2, "Lidiia", "Pyshna", "6A Minet Gardens", "", "", "London", "NW10 8AS",
				"07581796163", "", "lidiiapyshna@yahoo.co.uk", "My ex made it", 0);
		Customer customerThree = new Customer(3, "Dimitry", "Budarin", "5 York House", "4 De Quincey Mews", "Newham",
				"London", "E16 1SU", "07123456789", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFour = new Customer(4, "Egle", "Vaitmonaite", "York House", "4 De Quincey Mews", "",
				"London", "E16 1SU", "07987654321", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		Customer customerFive = new Customer(5, "Amadea", "Pal", "Somewhere near", "Elephant and Castle", "", "London",
				"??? ????", "07456789123", "", "s.collins90@hotmail.co.uk", "I made the damn thing", 0);
		boolean successfulUpdate = false;

		try {
			CustomerDAO.addCustomer(customerOne);
			CustomerDAO.addCustomer(customerTwo);
			CustomerDAO.addCustomer(customerThree);
			CustomerDAO.addCustomer(customerFour);
			CustomerDAO.addCustomer(customerFive);
			Customer tempCustomer = CustomerDAO.getCustomerById(5);
			tempCustomer.setAddressLineThree("CrickleWood");
			successfulUpdate = CustomerDAO.updateCustomer(tempCustomer);
		} catch (NullPointerException | SQLException e) {
			assertTrue(e.equals(null));
		}
		assertEquals(true, successfulUpdate);
	}
}
