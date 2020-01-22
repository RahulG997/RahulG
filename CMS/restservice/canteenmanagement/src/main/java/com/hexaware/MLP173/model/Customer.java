package com.hexaware.MLP173.model;
import java.util.Objects;
import java.util.Date;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Customer {
/**
 * venId to store venId.
 */
  private int cusId;
  /**
 * VenAddress to store Item Name.
 */
  private String cusName;
   /**
 * VenAddress to store Item details.
 */
  private String cusPassword;
 /**
 * VenAddress to store Item price.
 */
  private String cusEmail;
 /**
 * VenAddress to store Item Status.
 */
  private String cusMobile;
  /**
 * CusDob to store Item Status.
 */
  private Date cusDob;
 /**
 * VenAddress to store Item Rate.
 */
  private String cusAddress;
  /**
   * Default Constructor.
   */
  public Customer() {

  }
/**
 * @param argCusId to initialize food id.
 * @param argCusName to initialize food Name.
 * @param argCusPassword to initialize food price.
 * @param argCusEmail to initialize food Detail.
 * @param argCusMobile to initialize food Status.
 * @param argCusDob to initialize Date Of Birth.
 * @param argCusAddress to initialize food Rating.
 * used to get details through constructor.
 */
  public Customer(final int argCusId, final String argCusName, final String argCusPassword,
        final String argCusEmail, final String argCusMobile, final Date argCusDob, final String argCusAddress) {
    this.cusId = argCusId;
    this.cusName = argCusName;
    this.cusPassword = argCusPassword;
    this.cusEmail = argCusEmail;
    this.cusMobile = argCusMobile;
    this.cusDob = argCusDob;
    this.cusAddress = argCusAddress;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer customer = (Customer) obj;
    if (Objects.equals(cusId, customer.cusId)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId);
  }
    /**
     * @return this venId
     */
  public final int getCusId() {
    return cusId;
  }
    /**
     * @param argCusId gets the venId.
     */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
    /**
     * @return this CusName.
     */
  public final String getCusName() {
    return cusName;
  }
    /**
    * @param argCusName gets the CusName.
    */
  public final void setCusName(final String argCusName) {
    this.cusName = argCusName;
  }
     /**
     * @return this CusPassword.
     */
  public final String getCusPassword() {
    return cusPassword;
  }
      /**
       * @param argCusPassword gets the CusPassword.
       */
  public final void setCusPassword(final String argCusPassword) {
    this.cusPassword = argCusPassword;
  }
      /**
     * @return this CusEmail.
     */
  public final String getCusEmail() {
    return cusEmail;
  }
      /**
       * @param argCusEmail gets the VenEmail.
       */
  public final void setCusEmail(final String argCusEmail) {
    this.cusEmail = argCusEmail;
  }
      /**
       * @return this CusMobile.
       */
  public final String getCusMobile() {
    return cusMobile;
  }
      /**
       * @param argCusMobile gets the CusDob.
       */
  public final void setCusMobile(final String argCusMobile) {
    this.cusMobile = argCusMobile;
  }
       /**
       * @return this CusDob.
       */
  public final Date getcusDob() {
    return cusDob;
  }
      /**
       * @param argCusDob gets the CusDob.
       */
  public final void setCusDob(final Date argCusDob) {
    this.cusDob = argCusDob;
  }

    /**
     * @return this CusAddress.
     */
  public final String getCusAddress() {
    return cusAddress;
  }
      /**
       * @param argCusAddress gets the VenAddress.
       */
  public final void setCusAddress(final String argCusAddress) {
    this.cusAddress = argCusAddress;
  }

  /*
  * toString() method to print details.
  */
  @Override
  public final String toString() {
    return String.format("%5s %15s %25s %20s %20s %20s", cusId, cusName, cusEmail, cusMobile, cusDob, cusAddress);
  }
}





