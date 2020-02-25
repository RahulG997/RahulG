package com.hexaware.MLP173.factory;
import com.hexaware.MLP173.persistence.CustomerDAO;
import com.hexaware.MLP173.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP173.model.Customer;
/**
 * CustomerFactory class used to fetch Customer data from database.
 * @author hexware
 */
public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  protected CustomerFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  public static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Customer object.
   */
  public static Customer[] showCustomer() {
    List<Customer> customer = dao().show();
    return customer.toArray(new Customer[customer.size()]);
  }
    /**
    * retrive customer info.
    * @return array of menu objects.
    * @param customerName to accept customer name.
    */
  public static Customer findByCustomerName(final String customerName) {
    Customer customer = dao().findByCustomerName(customerName);
    return customer;
  }

    /**
     * call authenticate method for validate user.
     * @return the count.
     * @param user to initilize customer user.
     * @param password to initilize cust password
     */
  public static int validateCustomer(final String user, final String password) {
    int count = dao().authenticate(user, password);
    return count;
  }
}





