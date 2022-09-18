package dao;

import domain.Product;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author Zac Seales
 */
public interface ProductJdbiDAO extends ProductDAO {
    
    @Override
    @SqlUpdate("MERGE INTO PRODUCT(Product_ID, Name, "
        + "Description, Category, ListPrice, Quantity_In_Stock) KEY (Product_ID)"
        + " VALUES (:productId, :name, :description, :category, :listPrice, "
        + ":quantityInStock)")
    public void saveProduct(@BindBean Product product);

    @Override
    @SqlUpdate("DELETE FROM PRODUCT WHERE Product_ID = :productId")
    public void removeProduct(@BindBean Product product);

    @Override
    @SqlQuery("SELECT * FROM PRODUCT ORDER BY Product_ID")
    @RegisterBeanMapper(Product.class)
    public Collection<Product> getProducts();

    @Override
    @SqlQuery("SELECT DISTINCT CATEGORY FROM PRODUCT")
    public Collection<String> getCategories();

    @Override
    @SqlQuery("SELECT * FROM PRODUCT WHERE Product_ID = :id")
    @RegisterBeanMapper(Product.class)
    public Product searchById(@Bind("id")String id);

    @Override
    @SqlQuery("SELECT * FROM PRODUCT WHERE CATEGORY = :category")
    @RegisterBeanMapper(Product.class)
    public Collection<Product> filterByCategory(@Bind("category") String category);
    
}
