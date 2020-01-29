package com.hexaware.MLP173.model;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Vendor {
/**
 * venId to store venId.
 */
  private int venId;
  /**
 * VenAddress to store Item Name.
 */
  private String venName;
   /**
 * VenAddress to store Item details.
 */
  private String venPassword;
 /**
 * VenAddress to store Item price.
 */
  private String venEmail;
 /**
 * VenAddress to store Item Status.
 */
  private String venMobile;
 /**
 * VenAddress to store Item Rate.
 */
  private String venAddress;
  /**
   * Default Constructor.
   */
  public Vendor() {

  }
/**
 * @param argVenId to initialize food id.
 * @param argVenName to initialize food Name.
 * @param argVenPassword to initialize food price.
 * @param argVenEmail to initialize food Detail.
 * @param argVenMobile to initialize food Status.
 * @param argVenAddress to initialize food Rating.
 * used to get details through constructor.
 */
  public Vendor(final int argVenId, final String argVenName, final String argVenPassword,
        final String argVenEmail, final String argVenMobile, final String argVenAddress) {
    this.venId = argVenId;
    this.venName = argVenName;
    this.venPassword = argVenPassword;
    this.venEmail = argVenEmail;
    this.venMobile = argVenMobile;
    this.venAddress = argVenAddress;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(venId, vendor.venId)
        && Objects.equals(venName, vendor.venName)
        && Objects.equals(venPassword, vendor.venPassword)
        && Objects.equals(venEmail, vendor.venEmail)
        && Objects.equals(venMobile, vendor.venMobile)
        && Objects.equals(venAddress, vendor.venAddress)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(venId, venName, venPassword, venEmail, venMobile, venAddress);
  }
    /**
     * @return this venId
     */
  public final int getVenId() {
    return venId;
  }
    /**
     * @param argVenId gets the venId.
     */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
      /**
     * @return this VenName.
     */
  public final String getVenName() {
    return venName;
  }
      /**
       * @param argVenName gets the VenName.
       */
  public final void setVenName(final String argVenName) {
    this.venName = argVenName;
  }
     /**
     * @return this VenPassword.
     */
  public final String getVenPassword() {
    return venPassword;
  }
      /**
       * @param argVenPassword gets the VenPassword.
       */
  public final void setVenPassword(final String argVenPassword) {
    this.venPassword = argVenPassword;
  }
      /**
     * @return this VenEmail.
     */
  public final String getVenEmail() {
    return venEmail;
  }
      /**
       * @param argVenEmail gets the VenEmail.
       */
  public final void setVenEmail(final String argVenEmail) {
    this.venEmail = argVenEmail;
  }
       /**
     * @return this VenMobile.
     */
  public final String getVenMobile() {
    return venMobile;
  }
      /**
       * @param argVenMobile gets the VenMobile.
       */
  public final void setVenMobile(final String argVenMobile) {
    this.venMobile = argVenMobile;
  }

  /**
     * @return this VenAddress.
     */
  public final String getVenAddress() {
    return venAddress;
  }
      /**
       * @param argVenAddress gets the VenAddress.
       */
  public final void setVenAddress(final String argVenAddress) {
    this.venAddress = argVenAddress;
  }

  /*
  * toString() method to print details.
  */
  @Override
  public final String toString() {
    return String.format("%16s %15s %25s %20s %20s", venId, venName, venEmail, venMobile, venAddress);
  }
}
