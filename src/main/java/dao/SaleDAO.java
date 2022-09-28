package dao;

import domain.Sale;

/** SaleDAO.java
 *  INFO202 - Milestone2
 * 
 *  DAO interface for Sale objects.
 *@author Zac Seales - 6687905
 */
public interface SaleDAO {
    
    /** Saves a Sale state to record purchases that have been finalized.
     *@param sale - the sale being made (customer, items, and costs).
     */
    void save(Sale sale);

}
