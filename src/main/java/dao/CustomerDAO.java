package dao;

import domain.Customer;
import java.util.Collection;

/** CustomerDAO.java
 *
 * A public interface for managing Customer objects.
 * @author Zac Seales 6689705
 */

public interface CustomerDAO {
    
    /** Stores the Customer parameter in the customer 
     *  TreeMap using the ID value as the hash key.
     *@param c - the customer being saved.
     */
    void save(Customer c);
    
    /** Removes the customer parameter from the TreeMap.
     *@param c - the customer being deleted.
     */
    void delete(Customer c);
    
    /** Returns the customer that corresponds to the 
     *  Customer username parameter.
     *@param username - the username value of the customer being retrieved.
     *@return - the Customer that corresponds to the username parameter.
     */
    Customer getByUsername(String username);
    
    /** Returns a boolean dependent on whether this username and password
     *  correspond to a valid customer login.
     *@param username - the username being checked
     *@param password - the corresponding password.
     *@return - true if parameters correspond to a valid customer login, else false.
     */
    boolean isValidLogin(String username, String password);
}
