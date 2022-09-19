package web;

import dao.CustomerDAO;
import dao.ProductDAO;
import domain.Customer;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 * SaleModule.java
 *
 * @author Zac Seales - 6687905
 */
public class SaleModule extends Jooby {

    public SaleModule() {
        
        // Create a new Customer and save to the dao
        // (New account registration)
        post("/api/sales/", ctx -> {
            // requires sales dao
            return ctx.send(StatusCode.CREATED);
        });
        
    }//end constructor
    
}//end SaleModule class
