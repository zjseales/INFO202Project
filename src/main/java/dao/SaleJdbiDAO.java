package dao;

import domain.Sale;
import domain.SaleItem;
import java.time.LocalDateTime;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;

/** SaleJdbiDAO.java
 *  INFO202 - Milestone2
 * 
 *  
 *@author Zac Seales - 6687905
 */
public interface SaleJdbiDAO extends SaleDAO {

    @SqlUpdate("INSERT INTO SALE(Sale_Date, Customer_ID, Status) VALUES (:date, :customer.customerId, :status) " )
    @GetGeneratedKeys
    Integer insertSale(@BindBean Sale sale);

    @SqlUpdate("INSERT INTO SALE_ITEM(Sale_ID, Product_ID, Quantity, Price) VALUES (:saleId, :product.productId, :quantityPurchased, :product.listPrice * :quantityPurchased)")
    void insertSaleItem(@BindBean SaleItem item, @Bind("saleId") Integer saleId);

    @SqlUpdate("MERGE INTO PRODUCT(Product_ID, Name, Description, Category, ListPrice, Quantity_In_Stock) "
            +  "KEY (Product_ID) VALUES (:product.productId, :product.name, :product.description, :product.category, "
            +  ":product.listPrice, :product.quantityInStock - :quantityPurchased)")
    void updateStockLevel(@BindBean SaleItem item);

    @Override
    @Transaction
    default void save(Sale sale) {
        // save current date
        sale.setDate(LocalDateTime.now());

        // set sale status
        sale.setStatus("NEW ORDER");

        // call the insertSale method, and get the generated sale ID.
        Integer saleId = insertSale(sale);
        sale.setSaleId(saleId);

        // loop through the sale's items.
        for (SaleItem item : sale.getItems()) {
            insertSaleItem(item, saleId);
            updateStockLevel(item);
        }

    }
}
