package web;

import dao.CustomerDAO;
import domain.Customer;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 * CustomerModule.java
 *
 * @author Zac Seales - 6687905
 */
public class CustomerModule extends Jooby {

    public CustomerModule(CustomerDAO dao) {
		  
	// retrieve customer by username
	get("/api/customers/{username}", ctx -> {
			   
            String username = ctx.path("username").value();
			  
            Customer customer = dao.getByUsername(username);
			  
            // n404 error if no customer found
            if(customer == null) {
                return ctx.send(StatusCode.NOT_FOUND);
            } else {
                return customer;
            }
			  
        });
        
        // Create a new Customer and save to the dao
        // (New account registration)
        post("/api/register/", ctx -> {
            Customer customer = ctx.body().to(Customer.class);
            dao.save(customer);
            return ctx.send(StatusCode.CREATED);
        });
        
    }//end constructor
    
}//end CustomerModule class
