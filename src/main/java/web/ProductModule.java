package web;

import dao.ProductDAO;
import domain.Product;
import io.jooby.Jooby;
import io.jooby.StatusCode;
import java.util.Collection;

/**
 * ProductModule.java
 *
 * @author Zac Seales - 6687905
 */
public class ProductModule extends Jooby {

    public ProductModule(ProductDAO dao) {
		  
	//retrieve all Products from the database.
        get("/api/products/", ctx -> dao.getProducts());
		  
	// retrieve Product by ID
        get("/api/products/{id}", ctx -> {
            String id = ctx.path("id").value();
            Product product = dao.searchById(id);  
            // 404 error if no product found
            if(product == null) {
                return ctx.send(StatusCode.NOT_FOUND);
            } else {
                return product;
            }			  
	});
        
        //retrieve all categories
        get("/api/categories/", ctx -> dao.getCategories());
        
        // retrieve products filtered by category
	get("/api/categories/{category}", ctx -> {
            
            String category = ctx.path("category").value();
            
            Collection<Product> products = dao.filterByCategory(category);
			  
            // 404 error if no products found
            if(products == null) {
                return ctx.send(StatusCode.NOT_FOUND);
            } else {
                return products;
            }
			  
        });
        
    }//end constructor
    
}//end ProductModule class
