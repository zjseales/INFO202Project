package dao;

import domain.Customer;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/** CustomerCollectionsDAO.java
 * 
 *  A collection-based data-access object for Customer details.
 *@author Zac Seales
 */
public class CustomerCollectionsDAO implements CustomerDAO {
    //TreeMap that holds all Customers
    private static final Map<String, Customer> customers = new TreeMap<>();
    
    @Override
    public void save(Customer c) {
        customers.put(c.getUsername(), c);
    }
    
    @Override
    public void delete(Customer c) {
        customers.remove(c.getUsername());
    }
    
    @Override
    public Customer getByUsername(String username) {
        return customers.get(username);
    }
    
    @Override
    public boolean isValidLogin(String username, String password) {
        Customer c = getByUsername(username);
        if (c == null) {
            return false;
        } else if (c.getPassword().equals(password)) {
            return true;
        }
        return false;
		  
		//  return customers.containsKey(username) && customers.get(username).getPassword().equals(password);
		  
    }
}
