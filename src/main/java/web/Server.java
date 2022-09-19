package web;

import dao.CustomerDAO;
import dao.DaoFactory;
import dao.ProductCollectionsDAO;
import dao.ProductDAO;
import domain.Product;
import io.jooby.Jooby;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;
import java.math.BigDecimal;

public class Server extends Jooby {
    
    private ProductDAO productDAO = DaoFactory.getProductDAO();
    private CustomerDAO customerDAO = DaoFactory.getCustomerDAO();

	public Server() {
		setServerOptions(new ServerOptions().setPort(8085));

		install(new GsonModule());
                
                mount(new ProductModule(productDAO));
                mount(new CustomerModule(customerDAO));
                
		mount(new StaticAssetModule());
	}

	public static void main(String[] args) {
            // some dummy data for testing with
            ProductDAO dao = DaoFactory.getProductDAO();
            dao.saveProduct(new Product("WD420", "Product 1", "The First Product", "generic", new BigDecimal("3.20"), new BigDecimal(46)));
            dao.saveProduct(new Product("XXX32", "Product 2", "The Second Product", "generic", new BigDecimal("4.30"), new BigDecimal(37)));
            dao.saveProduct(new Product("77713", "Product 3", "The Third Product", "generic", new BigDecimal("5.60"), new BigDecimal(12)));
            dao.saveProduct(new Product("abc45", "Ball", "A sphere of air.", "Sports", new BigDecimal("59.99"), new BigDecimal(114)));

            
		System.out.println("\nStarting Server.");
		new Server().start();
	}

}
