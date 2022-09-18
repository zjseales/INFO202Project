package dao;

import domain.Product;
import java.math.BigDecimal;
import java.util.Collection;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Zac Seales - 6687905
 */
public class ProductDAOTest {

	private Product p1;
	private Product p2;
	private Product p3;
	private Product p4;
	private Product p5;

	private ProductDAO dao;

	@BeforeAll
	public static void initialise() {
		JdbiDaoFactory.setJdbcUri("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
	}

	@BeforeEach
	public void setUp() {

//        dao = new ProductCollectionsDAO();
		dao = JdbiDaoFactory.getProductDAO();

		//initialize some products
		p1 = new Product("1234", "Product One", "The first Product.", "generic",
			 new BigDecimal(2.3), new BigDecimal(7));
		p2 = new Product("1235", "Product Two", "The second Product.", "generic",
			 new BigDecimal(2.5), new BigDecimal(11));
		p3 = new Product("1236", "Product Three", "The third product.", "generic",
			 new BigDecimal(2.95), new BigDecimal(56));
		p4 = new Product("1237", "Fishing Rod", "A fishing rod.", "sports",
			 new BigDecimal(77.8), new BigDecimal(56));
		p5 = new Product("4567", "Basketball", "A bouncy sphere.", "sports",
			 new BigDecimal(37.2), new BigDecimal(26));

		//add all except 1 to the dao
		dao.saveProduct(p2);
		dao.saveProduct(p3);
		dao.saveProduct(p4);
		dao.saveProduct(p5);
	}

	@AfterEach
	public void tearDown() {
		dao.removeProduct(p1);
		dao.removeProduct(p2);
		dao.removeProduct(p3);
		dao.removeProduct(p4);
		dao.removeProduct(p5);
	}

	@Test
	public void testFilterByCategory() {
		//check the whole array size
		assertThat(dao.getProducts().size(), greaterThan(3));

		//check the filtered array size
		assertThat(dao.filterByCategory("generic").size(), greaterThan(1));
		assertThat(dao.filterByCategory("sports").size(), greaterThan(1));
	}

	@Test
	public void testGetCategories() {
		//ensure all categories are retrieved
		assertThat(dao.searchById(p2.getProductId()), is(p2));
		assertThat(dao.searchById(p3.getProductId()), is(p3));
		assertThat(dao.searchById(p4.getProductId()), is(p4));
		assertThat(dao.searchById(p5.getProductId()), is(p5));

		assertThat(dao.getCategories().size(), greaterThan(1));

	}

	@Test
	public void testGetProducts() {
		//ensure 4 products exist
		assertThat(dao.searchById(p1.getProductId()), is(nullValue()));
		assertThat(dao.searchById(p2.getProductId()), is(p2));
		assertThat(dao.searchById(p3.getProductId()), is(p3));
		assertThat(dao.searchById(p4.getProductId()), is(p4));
		assertThat(dao.searchById(p5.getProductId()), is(p5));

		assertThat(dao.getProducts().size(), greaterThan(3));
	}

	@Test
	public void testRemoveProduct() {
		//check the values exist
		assertThat(dao.searchById(p2.getProductId()), is(p2));
		assertThat(dao.searchById(p3.getProductId()), is(p3));
		assertThat(dao.searchById(p4.getProductId()), is(p4));
		assertThat(dao.searchById(p5.getProductId()), is(p5));

		dao.removeProduct(p2);
		dao.removeProduct(p3);
		dao.removeProduct(p4);
		dao.removeProduct(p5);

		//check the values were removed
		assertThat(dao.searchById(p2.getProductId()), is(nullValue()));
		assertThat(dao.searchById(p3.getProductId()), is(nullValue()));
		assertThat(dao.searchById(p4.getProductId()), is(nullValue()));
		assertThat(dao.searchById(p5.getProductId()), is(nullValue()));
	}

	@Test
	public void testSaveProduct() {
		//check that all values are expected
		assertThat(dao.searchById(p1.getProductId()), is(nullValue()));
		assertThat(dao.searchById(p2.getProductId()), is(p2));
		assertThat(dao.searchById(p3.getProductId()), is(p3));
		assertThat(dao.searchById(p4.getProductId()), is(p4));
		assertThat(dao.searchById(p5.getProductId()), is(p5));

		dao.saveProduct(p1);
		// check that the product saved
		assertThat(dao.searchById(p1.getProductId()), is(p1));
	}

	@Test
	public void testSearchById() {
		//check the products are returned when searched by id
		assertThat(dao.searchById(p2.getProductId()), is(p2));
		assertThat(dao.searchById(p3.getProductId()), is(p3));
		assertThat(dao.searchById(p4.getProductId()), is(p4));
		assertThat(dao.searchById(p5.getProductId()), is(p5));

	}

}
