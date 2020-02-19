package com.hexaware.MLP173.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP173.model.Customer;
import com.hexaware.MLP173.factory.CustomerFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns customer details.
   * @return the customer details.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer[] listCustomer() {
    final Customer[] customer = CustomerFactory.showCustomer();
    return customer;
  }
  /**
   * Returns customer details.
   * @param customerName to get name.
   * @return the menu details
   */
  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer customerName(@PathParam("name") final String customerName) {
    final Customer customer =  CustomerFactory.findByCustomerName(customerName);
    return customer;
  }
  /**
   * Returns customer details.
   * @param user to get name.
   * @param password to get name.
   * @return the customer details
   */
  @GET
  @Path("/{user}/{password}")
  @Produces(MediaType.APPLICATION_JSON)
  public final int cusID(@PathParam("user") final String user, @PathParam("password") final String password) {
    final int count = CustomerFactory.validateCustomer(user, password);
    return count;
  }
}
