package com.hexaware.MLP173.integration.test;
import java.util.Objects;
import com.hexaware.MLP173.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 */
  private int foodId;
   /**
  *  Menu_Name for food name.
  */
  private String menuName;
  /**
 *  RATE OF FOOD IS STORED IN price.
 */
  private float price;
  /**
  *  vendorId  to store id  of vendor.
  */
  private int vendorId;
  /**
   * Default Constructor.
   */
  public Menu() {
  }
/**
 * @param argFoodId to initialize food id.
 * used to get details through constructor.
 */
  public Menu(final int argFoodId) {
    this.foodId = argFoodId;
  }
  /**
  * @param argFoodId to store foodid.
  * @param argFname to store name.
  * @param argPrice to store price.
  * @param argVendorId to store vendorid.
  */
  public Menu(final int argFoodId, final String argFname, final float argPrice, final int argVendorId) {
    this.foodId = argFoodId;
    this.menuName = argFname;
    this.price = argPrice;
    this.vendorId = argVendorId;
  }
  @Override
public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId)) {
      return true;
    }
    return false;
  }
  @Override
public final int hashCode() {
    return Objects.hash(foodId);
  }
/**
* @return this food ID.
*/
  public final int getFoodId() {
    return foodId;
  }
/**
* @param argFoodId gets the food id.
*/
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
/**
 *  @return this menu name.
 */
  public final String getMenuName() {
    return menuName;
  }
/**
 * @param fname gets the food name.
*/
  public final void setMenuName(final String fname) {
    this.menuName = fname;
  }
/**
 * @return this price.
 */
  public final float getPrice() {
    return price;
  }
/**
 * @param argPrice gets price.
*/
  public final void setPrice(final float argPrice) {
    this.price = argPrice;
  }
  /**
   * @return this vendorId.
   */
  public final int getVendorId() {
    return vendorId;
  }
  /**
   * @param argVendorId sets the vendorId.
   */
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }

  public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }

}

