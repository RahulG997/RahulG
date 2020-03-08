package com.hexaware.MLP173.util;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP173.model.OrderDetail;
import com.hexaware.MLP173.factory.OrderFactory;
import javax.ws.rs.PathParam;

import java.text.ParseException;

import javax.ws.rs.Consumes;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/orderdetail")
public class OrderRest {
  /**
   * Returns Order details.
   * 
   * @return the Order details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderDetail[] listOrderDetail() {
    final OrderDetail[] orderdetail = OrderFactory.showOrderDetail();
    return orderdetail;
  }

  /**
   * Returns order details.
   * 
   * @return the order details
   * @param cusId for pending customers.
   */
  @GET
  @Path("/pendingcus/{cusId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderDetail[] orderdetailListbyId(@PathParam("cusId") final int cusId) {
    final OrderDetail[] orderdetail = OrderFactory.showpendingCustomeOrderDetails(cusId);
    if (orderdetail == null) {
      throw new NotFoundException("No such Customer ID: " + cusId);
    }
    return orderdetail;
  }

  /**
   * Returns Menu details.
   * 
   * @param venId to get name.
   * @return the menu details
   */
  @GET
  @Path("/pendingven/{venId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderDetail[] orderdetailTestById(@PathParam("venId") final int venId) {
    final OrderDetail[] orderdetail = OrderFactory.showpendingVendorOrderDetails(venId);
    if (orderdetail == null) {
      throw new NotFoundException("No such Vendor ID: " + venId);
    }
    return orderdetail;
  }

  /**
   * Returns Order details.
   * 
   * @return the Order details.
   * @param cusId for history of customer.
   */
  @GET
  @Path("/historycus/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderDetail[] orderdetailTest1ById(@PathParam("id") final int cusId) {
    final OrderDetail[] orderdetail = OrderFactory.showCustomerHistory(cusId);
    if (orderdetail == null) {
      throw new NotFoundException("No such customer ID: " + cusId);
    }
    return orderdetail;
  }

  /**
   * Returns Order details.
   * 
   * @return the Order details.
   * @param orderdetail for place order object.
   * @throws ParseException
   */
  @POST
  @Path("/placeOrder")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String placeOrder(final OrderDetail orderdetail) throws ParseException {
    String result = OrderFactory.placeOrder(orderdetail);
    return result;
  }

    /**
   * Returns Order details.
   * @return the Order details.
   * @param venId for pending vendors.
   */
  @GET
  @Path("/historyven/{id}")
  @Produces(MediaType.APPLICATION_JSON)
   public final OrderDetail[] orderTest2ById(@PathParam("id") final int venId) {
    final OrderDetail[] orderdetail = OrderFactory.showVendorHistory(venId);
    if (orderdetail == null) {
      throw new NotFoundException("No such Vendor ID: " + venId);
    }
    return orderdetail;
  }
    /**
   * Accept or Reject order.
   * @return the Order details.
   * @param orderId for place order object.
   * @param venId for vendor id.
   * @param status for status
   */
  @POST
  @Path("/acceptOrRejectOrder/{orderId}/{vendorId}/{status}")
  @Produces(MediaType.APPLICATION_JSON)
   public final String acceptOrRejectOrder(@PathParam("orderId") final int orderId,
        @PathParam("vendorId") final int venId, @PathParam("status") final String status) {
    String result = OrderFactory.acceptOrRejectOrder(orderId, venId, status);
    return result;
  }
      /**
   * cancel order.
   * @return the Order details.
   * @param orderId for place order object.
   * @param cusId for customer id.
   * @param status for status
   */
  @POST
  @Path("/cancelOrder/{orderId}/{custId}/{status}")
  @Produces(MediaType.APPLICATION_JSON)
   public final String cancelOrder(@PathParam("orderId") final int orderId,
        @PathParam("custId") final int cusId, @PathParam("status") final String status) {
    String result = OrderFactory.cancelOrder(orderId, cusId, status);
    return result;
  }
}
