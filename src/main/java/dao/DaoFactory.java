package dao;

/** DaoFactory.java
 *  INFO202 - Milestone1
 *
 *  Encapsulates the DAO dependencies to perform
 *  inversion of control and lower the overall coupling.
 *@author Zac Seales - 6687905
 */
public class DaoFactory {
    
    /** Returns the Customer DAO object.
     *@return The Customer DAO.
     */
    public static CustomerDAO getCustomerDAO() {
        return JdbiDaoFactory.getCustomerDAO();
        //return new CustomerCollectionsDAO();
    }
    
    /** Returns the ProductDAO object.
     *@return The Product DAO.
     */
    public static ProductDAO getProductDAO(){
        return JdbiDaoFactory.getProductDAO();
        //return new ProductCollectionsDAO();
    }
    
}
