package com.hexaware.MLP173.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP173.model.Vendor;
import com.hexaware.MLP173.factory.VendorFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/vendor")
public class VendorRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor[] listVendor() {
    final Vendor[] vendor = VendorFactory.showVendor();
    return vendor;
  }
  /**
   * Returns Menu details.
   * @param venName to get name.
   * @return the menu details
   */
  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor venName(@PathParam("name") final String venName) {
    final Vendor vendor = VendorFactory.findByVendorName(venName);
    return vendor;
  }
  /**
   * Returns Menu details.
   * @param user to get name.
   * @param password to get name.
   * @return the menu details
   */
  @GET
  @Path("/{user}/{password}")
  @Produces(MediaType.APPLICATION_JSON)
  public final int vendorID(@PathParam("user") final String user, @PathParam("password") final String password) {
    final int count = VendorFactory.validateVendor(user, password);
    return count;
  }
}


