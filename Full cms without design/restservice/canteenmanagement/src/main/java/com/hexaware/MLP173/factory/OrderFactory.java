package com.hexaware.MLP173.factory;
import com.hexaware.MLP173.persistence.OrderDAO;
import com.hexaware.MLP173.persistence.DbConnection;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.hexaware.MLP173.model.Customer;
import com.hexaware.MLP173.model.Freegift;
import com.hexaware.MLP173.model.Menu;
import com.hexaware.MLP173.model.OrderDetail;
import com.hexaware.MLP173.model.OrderStatus;
import com.hexaware.MLP173.model.Wallet;

/**
 * OrderFactory class used to fetch order data from database.
 * 
 * @author hexware
 */
public class OrderFactory {
  /**
   * Protected constructor.
   */
  protected OrderFactory() {

  }

  /**
   * Call the data base connection.
   * 
   * @return the connection object.
   */
  public static OrderDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderDAO.class);
  }

  /**
   * Call the data base connection.
   * 
   * @param menuId for accept menu Id
   * @return the array of menu object.
   */
  public static Menu showMenuItem(final int menuId) {
    Menu orderDetail = dao().findByMenuId(menuId);
    return orderDetail;
  }
   /**
   * Call the data base connection.
   * 
   * @param menuId for accept menu Id
   * @return the array of menu object.
   */
  public static Customer findbyCusId(final int cusId) {
    Customer orderDetail = dao().findByCusId(cusId);
    return orderDetail;
  }

  /**
   * Call the data base connection.
   * 
   * @param menuId for accept menu Id
   * @return the array of menu object.
   */
  public static int showCusorder(final int cusId,final Date ordTime) {
    int res = dao().cusOrder(cusId,ordTime);
    return res;
  }

  /**
   * Call the data base connection.
   * 
   * @param menuId for accept menu Id
   * @return the array of menu object.
   */
  public static int showCuscount(final int cusId) {
    int res1 = dao().cusCount(cusId);
    return res1;
  }

  /**
   * Show Customer Pending Orders.
   * 
   * @param freegift for pending orders.
   * @return the array of order object.
   */
  public static String freeExtraGift(final Freegift freegift) {
    dao().showGift(freegift);
    return "You are getting a gift";
  }

  /**
   * Call the data base connection.
   * 
   * @return the array of menu object.
   */
  public static OrderDetail[] showOrderDetail() {
    List<OrderDetail> orderDetail = dao().show();
    return orderDetail.toArray(new OrderDetail[orderDetail.size()]);
  }

  /**
   * show customer pending orders.
   * 
   * @param cusId for pending orders.
   * @return the array of order object.
   */
  public static OrderDetail[] showpendingCustomeOrderDetails(final int cusId) {
    List<OrderDetail> orderDetail = dao().pendingCustomer(cusId);
    return orderDetail.toArray(new OrderDetail[orderDetail.size()]);
  }

  /**
   * show customer pending orders.
   * 
   * @param venId for pending orders.
   * @return the array of order object.
   */
  public static OrderDetail[] showpendingVendorOrderDetails(final int venId) {
    List<OrderDetail> orderDetail = dao().pendingVendor(venId);
    return orderDetail.toArray(new OrderDetail[orderDetail.size()]);
  }

  /**
   * show customer pending orders.
   * 
   * @param cusId for pending orders.
   * @return the array of order object.
   */
  public static OrderDetail[] showCustomerHistory(final int cusId) {
    List<OrderDetail> orderDetail = dao().customerHistory(cusId);
    return orderDetail.toArray(new OrderDetail[orderDetail.size()]);
  }

  /**
   * show customer pending orders.
   * 
   * @param venId for pending orders.
   * @return the array of order object.
   */
  public static OrderDetail[] showVendorHistory(final int venId) {
    List<OrderDetail> orderDetail = dao().vendorHistory(venId);
    return orderDetail.toArray(new OrderDetail[orderDetail.size()]);
  }

  /**
   * Show Vendor Orders History.
   * 
   * @param orderId for accept or reject.
   * @param cusId   for accept or reject.
   * @param status  for changing status.
   * @return the array of order object.
   */
  public static String cancelOrder(final int orderId, final int cusId, final String status) {
    OrderDetail orderdetail = dao().findByOrderId(orderId);
    int customerId = orderdetail.getCusId();
    OrderStatus ordStatus = orderdetail.getOrdStatus();
    String result = "";
    if (orderdetail != null) {
      if (ordStatus == OrderStatus.PENDING) {
        if (customerId == cusId) {
          if (status.equals("YES")) {
            String st = "CANCELLED";
            dao().acceptOrReject(st, orderId);
            double billAmount = orderdetail.getOrdAmount();
            String type = orderdetail.getWalType();
            billAmount = billAmount - (billAmount / 10);
            dao().refundAmount(billAmount, type, cusId);
            result = "Order Cancelled Successfully...";
          }
        } else {
          result = "You are Unauthorized Customer";
        }
      } else {
        result = "You cannot cancel this order..";
      }
    } else {
      result = "Invalid OrderId...";
    }
    return result;
  }

  /**
   * Show Vendor Orders History.
   * 
   * @param orderId  for accept or reject.
   * @param vendorId for accept or reject.
   * @param status   for changing status.
   * @return the array of order object.
   */
  public static String acceptOrRejectOrder(final int orderId, final int vendorId, final String status) {
    OrderDetail orderdetail = dao().findByOrderId(orderId);
    String result = "";
    if (orderdetail != null) {
      if (orderdetail.getVenId() == vendorId) {
        if (status.equals("ACCEPTED")) {
          dao().acceptOrReject(status, orderId);
          result = "Order Accepted Successfully...";
        }
        if (status.equals("REJECTED")) {
          dao().acceptOrReject(status, orderId);
          String type = orderdetail.getWalType();
          int cusId = orderdetail.getCusId();
          double billAmount = orderdetail.getOrdAmount();
          dao().refundAmount(billAmount, type, cusId);
          result = "Order Rejected and Amount Refunded...";
        }
      } else {
        result = "You are Unauthorized Vendor for this order...";
      }
    } else {
      result = "Invalid OrderId...";
    }
    return result;
  }

  /**
   * Place order for customer.
   * 
   * @param orderdetail for accepting order details.
   * @return order status.
   * @throws ParseException
   */
  public static String placeOrder(final OrderDetail orderdetail) throws ParseException {
    String msg=" ";
    Menu menu = dao().findByMenuId(orderdetail.getFoodId());
    Wallet wallet = dao().getWallentInfo(orderdetail.getWalType(), orderdetail.getCusId());
    System.out.println("Wallet Amount " + wallet.getWalAmount());
    double walAmount = wallet.getWalAmount();
    double price = menu.getFoodPrice();
    Date today = new Date();
    System.out.println(orderdetail.getOrdTime());
    long diffTime = orderdetail.getOrdTime().getTime() - today.getTime();
    long diffDays = diffTime / (60 * 60 * 1000 * 24);
    double totalAmount = price * orderdetail.getQtyOrder();
    if (walAmount < totalAmount) {
      return "Insufficient Funds...";
    }  else if (diffDays < 0)  {
      return "Order Cannot placed yesterday...";
    } else {
      /**freegift */
      /**date check */
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

    String oeStartDateStr = "-03-08";
    String oeEndDateStr = "-03-18";

    Calendar cal = Calendar.getInstance();
    Integer year = cal.get(Calendar.YEAR);

    oeStartDateStr = year.toString().concat(oeStartDateStr);
    oeEndDateStr = year.toString().concat(oeEndDateStr);


     Date startDate = sdf1.parse(oeStartDateStr);
     Date endDate = sdf1.parse(oeEndDateStr);
     Date d = orderdetail.getOrdTime();
        
        String currDt = sdf1.format(d);


        if(d.after(startDate) && d.before(endDate) || currDt.equals(sdf1.format(startDate)) ||currDt.equals(sdf1.format(endDate))){
            
      int count1=0;
      int count2=0;
      count1 = OrderFactory.showCusorder(orderdetail.getCusId(),orderdetail.getOrdTime());
      count2 = OrderFactory.showCuscount(orderdetail.getCusId());
    
      if(count1>=2 && count2 == 0){
        Freegift freegift = new Freegift();
        freegift.setCusId(orderdetail.getCusId());
        freegift.setVenId(orderdetail.getVenId());
        freegift.setStatus(1);
        System.out.println(OrderFactory.freeExtraGift(freegift));
        msg = "Free gift applicable...Order Placed Successfully...";
      }
      else if(count2==1){
        msg="Offer used !...Order Placed successfully !";
      }
      else {
        msg ="To get gift place order worth 500 today...Order Placed Successfully... !";
      }
 
         }
         else{
             msg = "order placed successfully !";
         }
      double diff = walAmount - totalAmount;
      System.out.println("Price is  " + totalAmount);
      orderdetail.setOrdStatus(OrderStatus.PENDING);
      orderdetail.setOrdAmount(totalAmount);
      dao().placeOrder(orderdetail);
      dao().updateBalance(diff, orderdetail.getWalType(), orderdetail.getCusId());
      // if (totalAmount >= 500 && totalAmount <= 600) {
      //   System.out.println("You are getting complementory food...");
      //   Menu compl = OrderFactory.showMenuItem(7);
      //   // System.out.println(compl.getFoodName());
      //   System.out.println(compl);
      // }
      return msg;
    }
  }
}
