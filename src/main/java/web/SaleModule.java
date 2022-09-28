package web;

import dao.SaleDAO;
import domain.Sale;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 * SaleModule.java
 *
 * @author Zac Seales - 6687905
 */
public class SaleModule extends Jooby {

    public SaleModule(SaleDAO dao) {
        
        // Create a new Sale Object and save it in the api interface.
        post("/api/sales/", ctx -> {
            Sale sale = ctx.body().to(Sale.class);
            dao.save(sale);
            return ctx.send(StatusCode.CREATED);
        });
        
    }//end constructor
    
}//end SaleModule class
