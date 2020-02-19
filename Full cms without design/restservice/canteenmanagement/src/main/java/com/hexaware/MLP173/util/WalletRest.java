package com.hexaware.MLP173.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP173.model.Wallet;
import com.hexaware.MLP173.factory.WalletFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/wallet")
public class WalletRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Wallet[] listWallet() {
    final Wallet[] wallet = WalletFactory.showWallet();
    return wallet;
  }
  /**
   * Returns Wallet details.
   * @param cusId for customer id.
   * @return the menu details
   */
  @GET
  @Path("{cusId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Wallet[] listWallet(@PathParam("cusId") final int cusId) {
    final Wallet[] wallet = WalletFactory.showWallet(cusId);
    return wallet;
  }
}
