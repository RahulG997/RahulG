package com.hexaware.MLP173.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;

import com.hexaware.MLP173.model.Customer;
import com.hexaware.MLP173.model.Menu;
import com.hexaware.MLP173.model.OrderDetail;
import com.hexaware.MLP173.model.Wallet;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
/**
 * OrderDAO class used  for JDBC logic.
 * @author hexware
 */
public interface OrderDAO {
    /**
     * @param walType for walet Info.
     * @param cusId for read customer info.
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from WALLET WHERE Wal_Type=:walType AND CUS_ID=:cusId")
    @Mapper(WalletMapper.class)
    Wallet getWallentInfo(@Bind("walType") String walType, @Bind("cusId") int cusId);
   /**
     * @param ordId for Order details.
     * @return the all the Order single record.
     */
  @SqlQuery("Select * from ORDER_DETAIL WHERE ORDER_ID=:ordId")
    @Mapper(OrderMapper.class)
    OrderDetail findByOrderId(@Bind("ordId") int ordId);
   /**
     * @param foodId for menu details.
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from FOOD_ITEM WHERE FOOD_ID=:foodId")
    @Mapper(MenuMapper.class)
    Menu findByMenuId(@Bind("foodId") int foodId);
       /**
     * @param foodId for menu details.
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Customer WHERE CUS_ID=:cusId")
  @Mapper(CustomerMapper.class)
  Customer findByCusId(@Bind("cusId") int cusId);
    /**
     * @return the all the Order record.
     */
  @SqlQuery("Select * from ORDER_DETAIL")
    @Mapper(OrderMapper.class)
    List<OrderDetail> show();
     /**
     * @param cusId for pending orders.
     * @return the all the Pending Customer Orders.
     */
  @SqlQuery("Select * from ORDER_DETAIL WHERE CUS_ID=:cusId AND ORD_STATUS='PENDING'")
    @Mapper(OrderMapper.class)
    List<OrderDetail> pendingCustomer(@Bind("cusId") int cusId);
   /**
     * @param cusId for pending orders.
     * @return the all the Customer Orders.
     */
  @SqlQuery("Select * from ORDER_DETAIL WHERE CUS_ID=:cusId")
    @Mapper(OrderMapper.class)
    List<OrderDetail> customerHistory(@Bind("cusId") int cusId);
    /**
     * @param venId for pending orders.
     * @return the all the Pending Vendor Orders.
     */
  @SqlQuery("Select * from ORDER_DETAIL WHERE VEN_ID=:venId AND ORD_STATUS='PENDING'")
  @Mapper(OrderMapper.class)
  List<OrderDetail> pendingVendor(@Bind("venId") int venId);
 /**
   * @param venId for pending orders.
   * @return the all the Customer Orders.
   */
  @SqlQuery("Select * from ORDER_DETAIL WHERE VEN_ID=:venId")
  @Mapper(OrderMapper.class)
  List<OrderDetail> vendorHistory(@Bind("venId") int venId);


  /**
    * @param orderdetail to initialize order.
     * @return the showPrice.
     */
  @SqlUpdate("INSERT INTO ORDER_DETAIL(ORD_TIME, ORD_AMOUNT, ORD_STATUS, QTY_ORDER,"
      + "CUS_ID, FOOD_ID, VEN_ID, Wal_Type, ORD_COMMENTS) "
      + " VALUES(:ordTime, :ordAmount, :ordStatus, :qtyOrder, :cusId,"
      + ":foodId, :venId, :walType, :ordComments);")
    @GetGeneratedKeys
    int placeOrder(@BindBean OrderDetail orderdetail);
/**
 * @param walAmount for Updated Balance.
 * @param walType for Which walet to update.
 * @param cusId for which customer to update.
 * @return the showPrice.
 */
  @SqlUpdate("UPDATE WALLET SET WAL_AMOUNT=:walAmount WHERE Wal_Type=:walType AND CUS_ID=:cusId")
  int updateBalance(@Bind("walAmount") double walAmount, @Bind("walType") String walType,
        @Bind("cusId") int cusId);
 /**
  * @param refundAmount for refund canceled order.
  * @param walType for Which walet to refund.
  * @param cusId for which refund to update.
   * @return the refund status.
   */
  @SqlUpdate("UPDATE WALLET SET WAL_AMOUNT=WAL_AMOUNT+:refundAmount WHERE Wal_Type=:walType AND CUS_ID=:cusId")
  int refundAmount(@Bind("refundAmount") double refundAmount, @Bind("walType") String walType,
        @Bind("cusId") int cusId);
  /**
  * @param ordStatus for Status Update.
  * @param ordId for Order to Update.
  * @return the status.
  */

  @SqlUpdate("UPDATE ORDER_DETAIL SET ORD_STATUS=:ordStatus WHERE ORDER_ID=:ordId")
  int acceptOrReject(@Bind("ordStatus") String ordStatus, @Bind("ordId") int ordId);
}
