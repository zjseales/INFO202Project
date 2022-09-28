package web;

import dao.CustomerDAO;
import dao.DaoFactory;
import dao.ProductDAO;
import dao.SaleDAO;
import domain.Product;
import io.jooby.Jooby;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;
import java.math.BigDecimal;

public class Server extends Jooby {
    
    private ProductDAO productDAO = DaoFactory.getProductDAO();
    private CustomerDAO customerDAO = DaoFactory.getCustomerDAO();
    private SaleDAO saleDAO = DaoFactory.getSaleDAO();

	public Server() {
		setServerOptions(new ServerOptions().setPort(8085));

		install(new GsonModule());
                
                mount(new ProductModule(productDAO));
                mount(new CustomerModule(customerDAO));
                mount(new SaleModule(saleDAO));
                
		mount(new StaticAssetModule());
	}

	public static void main(String[] args) {
            
		System.out.println("\nStarting Server.");
		new Server().start();
	}

}
