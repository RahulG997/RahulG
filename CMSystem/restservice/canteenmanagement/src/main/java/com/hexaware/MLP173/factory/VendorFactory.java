package com.hexaware.MLP173.factory;
import com.hexaware.MLP173.persistence.VendorDAO;
import com.hexaware.MLP173.persistence.DbConnection;
import java.util.List;
import com.hexaware.MLP173.model.Vendor;
/**
 * VendorFactory class used to fetch Vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  public static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Vendor object.
   */
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
  /**
    * retrive vendor info.
    * @return array of menu objects.
    * @param vendorName to accept customer name.
    */
  public static Vendor findByVendorName(final String vendorName) {
    Vendor vendor = dao().findByVendorName(vendorName);
    return vendor;
  }
      /**
       * call authenticate method for validate user.
       * @return the count.
       * @param user to initilize customer user.
       * @param password to initilize cust password
       */
  public static int validateVendor(final String user, final String password) {
    int count = dao().authenticate(user, password);
    return count;
  }
}





