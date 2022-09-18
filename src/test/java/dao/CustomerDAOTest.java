package dao;

import domain.Customer;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDAOTest {

	private CustomerDAO dao;

	private Customer c1;
	private Customer c2;
	private Customer c3;

	@BeforeAll
	public static void initialise() {
		JdbiDaoFactory.setJdbcUri("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
	}

	@BeforeEach
	public void setUp() {
		//dao = new CustomerCollectionsDAO();
		dao = JdbiDaoFactory.getCustomerDAO();

		c1 = new Customer("Customer", "One", "user1", "pass1", "C1_ADDRESS", "C1_EMAIL");
		c2 = new Customer("Customer", "Two", "user2", "pass2", "C2_ADDRESS", "C2_EMAIL");
		c3 = new Customer("Customer", "Three", "user3", "pass3", "C3_ADDRESS", "C3_EMAIL");

		dao.save(c1);
		dao.save(c2);

		// intentionally not saving c3
	}

	@AfterEach
	public void tearDown() {
		dao.delete(c1);
		dao.delete(c2);
		dao.delete(c3);
	}

	@Test
	public void testSave() {
		// make sure that c3 does not yet exist

		assertThat(dao.getByUsername(c3.getUsername()), is(nullValue()));
		assertThat(dao.getByUsername(c1.getUsername()).getUsername(), is(c1.getUsername()));
		assertThat(dao.getByUsername(c2.getUsername()).getUsername(), is(c2.getUsername()));

		// save c3
		dao.save(c3);

		// make sure that c3 now exists
		assertThat(dao.getByUsername(c3.getUsername()).getUsername(), is(c3.getUsername()));
	}

	@Test
	public void testDelete() {
		// make sure that c1 already exists
		assertThat(dao.getByUsername(c1.getUsername()).getPassword(), is(c1.getPassword()));

		// delete s1
		dao.delete(c1);

		// make sure that s1 no longer exists
		assertThat(dao.getByUsername(c1.getUsername()), is(nullValue()));
	}

	@Test
	public void testGetByUsername() {
		//ensure second customer exists and retrieves by username
		assertThat(dao.getByUsername(c2.getUsername()).getPassword(), is(c2.getPassword()));
	}

	@Test
	public void testIsValidLogin() {
		assertThat(dao.getByUsername(c2.getUsername()).getPassword(), is(c2.getPassword()));
		assertThat(c2.getPassword(), is("pass2"));
		assertThat(c2.getUsername(), is("user2"));

		assertThat(dao.isValidLogin(c2.getUsername(), c2.getPassword()), is(true));
		assertThat(dao.isValidLogin(c2.getUsername(), "incorrect"), is(false));
		assertThat(dao.isValidLogin("Incorrect", c2.getPassword()), is(false));
	}

}
