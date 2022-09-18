package dao;

import domain.Customer;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/** CustomerJdbiDAO.java
 *  INFO202 - Milestone1
 * 
 *  A DAO for the persistent Jdbi database framework.
 *@author Zac Seales - seaza886
 */
public interface CustomerJdbiDAO extends CustomerDAO {
    
    @Override
    @SqlUpdate("INSERT INTO CUSTOMER(FirstName, Surname, Username,"
            + " Password, Email_Address, Shipping_Address) VALUES "
            + " (:firstName, :surname, :username, :password, :emailAddress, "
            + ":shippingAddress)")
    public void save(@BindBean Customer c);
    
    @Override
    @SqlUpdate("DELETE FROM CUSTOMER WHERE Username = :username")
    public void delete(@BindBean Customer c);
    
    @Override
    @SqlQuery("SELECT * FROM CUSTOMER WHERE Username = :username")
    @RegisterBeanMapper(Customer.class)
    public Customer getByUsername(@Bind("username") String username);
    
    @Override
    @SqlQuery("SELECT EXISTS (SELECT * FROM CUSTOMER WHERE Username "
            + "= :username AND Password = :password)")
    public boolean isValidLogin(@Bind("username") String username, @Bind("password") String password);
    
}
