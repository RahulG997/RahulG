package com.hexaware.MLP173.factory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.hexaware.MLP173.model.FoodStatus;
import com.hexaware.MLP173.model.Menu;
import com.hexaware.MLP173.model.OrderDetail;
import com.hexaware.MLP173.model.OrderStatus;
import com.hexaware.MLP173.model.WalType;
import com.hexaware.MLP173.model.Wallet;
import com.hexaware.MLP173.persistence.OrderDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.Mocked;
import java.util.ArrayList;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * Test class for OrderFactory.
 */
@RunWith(JMockit.class)
public class OrderFactoryTest {
  /**
   * tests that empty menu list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
    public final void testListAllEmpty(@Mocked final OrderDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<OrderDetail>();
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
       OrderDAO dao() {
        return dao;
      }
      };
    OrderDetail[] me = OrderFactory.showOrderDetail();
    assertEquals(0, me.length);
  }
   /**
    * Tests that a list with some employees is handled correctly.
    * @param dao mocking the dao class.
    * @throws ParseException for handling Dateformat errors.
    */
  @Test
   public final void testListAllSome(@Mocked final OrderDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final OrderDetail m2 = new OrderDetail(1, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail m3 = new OrderDetail(1, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> mn = new ArrayList<OrderDetail>();
    new Expectations() {
      {
        mn.add(m2);
        mn.add(m3);
        dao.show(); result = mn;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
       OrderDAO dao() {
        return dao;
      }
    };
    OrderDetail[] mn1 = OrderFactory.showOrderDetail();
    assertEquals(2, mn1.length);
    assertEquals(1, mn1[0].getOrdId());
    assertEquals(1, mn1[1].getOrdId());
    assertEquals(odt, mn1[0].getOrdTime());
    assertEquals(odt, mn1[1].getOrdTime());
    assertEquals(100, mn1[0].getOrdAmount(), 0);
    assertEquals(100, mn1[1].getOrdAmount(), 0);
    assertEquals(OrderStatus.ACCEPTED, mn1[0].getOrdStatus());
    assertEquals(OrderStatus.ACCEPTED, mn1[1].getOrdStatus());
    assertEquals(1, mn1[0].getQtyOrder());
    assertEquals(1, mn1[1].getQtyOrder());
    assertEquals(2, mn1[0].getCusId());
    assertEquals(2, mn1[1].getCusId());
    assertEquals(1, mn1[0].getFoodId());
    assertEquals(1, mn1[1].getFoodId());
    assertEquals(2, mn1[0].getVenId());
    assertEquals(2, mn1[1].getVenId());
    assertEquals("PAYTM", mn1[0].getWalType());
    assertEquals("make it fast", mn1[0].getOrdComments());
    assertEquals("PAYTM", mn1[1].getWalType());
    assertEquals("make it fast", mn1[1].getOrdComments());
  }
   /**
  * Tests that a list with some pending vendor is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException for handling Dateformat errors.
  */
  @Test
  public final void testVendorHistory(@Mocked final OrderDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final OrderDetail n1 = new OrderDetail(1, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail n2 = new OrderDetail(2, odt, 200.0, "Chennai", OrderStatus.PENDING, 1, 2, 1, 2, "DEBITCARD", "make it fast");
    final OrderDetail n3 = new OrderDetail(3, odt, 300.0, "Kolkata", OrderStatus.REJECTED, 1, 2, 1, 2, "DEBITCARD", "make it fast");
    final OrderDetail n4 = new OrderDetail(4, odt, 400.0, "Delhi", OrderStatus.ACCEPTED, 1, 2, 1, 2, "CREDITCARD", "make it fast");
    final OrderDetail n5 = new OrderDetail(5, odt, 500.0, "Pune", OrderStatus.REJECTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> vend204 = new ArrayList<OrderDetail>();
    vend204.add(n1);
    vend204.add(n2);
    vend204.add(n3);
    vend204.add(n4);
    vend204.add(n5);
    final OrderDetail n6 = new OrderDetail(6, odt, 600.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "NETBANKING", "make it fast");
    final OrderDetail n7 = new OrderDetail(7, odt, 700.0, "Delhi", OrderStatus.REJECTED, 1, 2, 1, 2, "NETBANKING", "make it fast");
    final OrderDetail n8 = new OrderDetail(8, odt, 800.0, "Chennai", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail n9 = new OrderDetail(9, odt, 900.0, "Pune", OrderStatus.REJECTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> vend202 = new ArrayList<OrderDetail>();
    vend202.add(n6);
    vend202.add(n7);
    vend202.add(n8);
    vend202.add(n9);
    new Expectations() {
        {
          dao.vendorHistory(202); result = vend202;
          dao.vendorHistory(204); result = vend204;
        }
      };
    new MockUp<OrderFactory>() {
        @Mock
        OrderDAO dao() {
          return dao;
        }
      };
    OrderDetail[] pending1 = OrderFactory.showVendorHistory(202);
    OrderDetail[] pending2 = OrderFactory.showVendorHistory(204);
    assertEquals(4, pending1.length);
    assertEquals(5, pending2.length);
  }
  /**
  * Tests that a list with some pending vendor is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException for handling Dateformat errors.
  */
  @Test
  public final void testCustomerHistory(@Mocked final OrderDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final OrderDetail c1 = new OrderDetail(1, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail c2 = new OrderDetail(2, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail c3 = new OrderDetail(3, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail c4 = new OrderDetail(4, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail c5 = new OrderDetail(5, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> cust100 = new ArrayList<OrderDetail>();
    cust100.add(c1);
    cust100.add(c2);
    cust100.add(c3);
    cust100.add(c4);
    cust100.add(c5);
    final OrderDetail c6 = new OrderDetail(6, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail c7 = new OrderDetail(7, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail c8 = new OrderDetail(8, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final OrderDetail c9 = new OrderDetail(9, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> cust101 = new ArrayList<OrderDetail>();
    cust101.add(c6);
    cust101.add(c7);
    cust101.add(c8);
    cust101.add(c9);
    new Expectations() {
        {
          dao.customerHistory(101); result = cust101;
          dao.customerHistory(100); result = cust100;
        }
      };
    new MockUp<OrderFactory>() {
        @Mock
        OrderDAO dao() {
          return dao;
        }
      };
    OrderDetail[] pending1 = OrderFactory.showCustomerHistory(101);
    OrderDetail[] pending2 = OrderFactory.showCustomerHistory(100);
    assertEquals(4, pending1.length);
    assertEquals(5, pending2.length);
  }
   /**
  * @param dao for mocking PlaceOrder Mock Test.
  * @throws ParseException for converting date to string.
   */
  @Test
  public final void testPlaceOrder(@Mocked final OrderDAO dao) throws ParseException {
    final Menu m2 = new Menu(11, "Dosa", "South-Indian", 120.00, FoodStatus.AVAILABLE, "4.0");
    final Menu m3 = new Menu(10, "Dosa", "South-Indian", 120.00, FoodStatus.AVAILABLE, "4.0");
    final Wallet w1 = new Wallet(1, 1, 500, WalType.CREDITCARD);
    final Wallet w2 = new Wallet(1, 1, 1200, WalType.CREDITCARD);
    final Wallet w3 = new Wallet(1, 1, 1200, WalType.CREDITCARD);
    final Wallet w4 = new Wallet(1, 1, 1200, WalType.CREDITCARD);
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String ord1 = new String("2020-03-18");
    final Date orDate1 = sdf.parse(ord1);
    final String ord2 = new String("2020-01-18");
    final Date orDate2 = sdf.parse(ord2);
    final String ord5 = new String("2020-02-27");
    final Date orDate5 = sdf.parse(ord5);

    final OrderDetail order1 = new OrderDetail();
    order1.setCusId(100);
    order1.setFoodId(10);
    order1.setVenId(1000);
    order1.setQtyOrder(1);
    order1.setWalType("PAYTM");
    order1.setOrdTime(orDate1);
    order1.setOrdComments("make it fast");

    final OrderDetail order2 = new OrderDetail();
    order2.setCusId(100);
    order2.setFoodId(10);
    order2.setVenId(1000);
    order2.setQtyOrder(2300);
    order2.setWalType("PAYTM");
    order2.setOrdTime(orDate1);
    order2.setOrdComments("Spicy");

    final OrderDetail order3 = new OrderDetail();
    order3.setCusId(100);
    order3.setFoodId(10);
    order3.setVenId(1000);
    order3.setQtyOrder(2);
    order3.setWalType("PAYTM");
    order3.setOrdTime(orDate2);
    order3.setOrdComments("Spicy");

    final OrderDetail order4 = new OrderDetail();
    order4.setCusId(100);
    order4.setFoodId(10);
    order4.setVenId(1000);
    order4.setQtyOrder(5);
    order4.setWalType("PAYTM");
    order4.setOrdTime(orDate1);
    order4.setOrdComments("Valo");

    final OrderDetail order5 = new OrderDetail();
    order4.setCusId(100);
    order4.setFoodId(11);
    order4.setVenId(1000);
    order4.setQtyOrder(1);
    order4.setWalType("PAYTM");
    order4.setOrdTime(orDate5);
    order4.setOrdComments("Valo");
    new Expectations() {
        {
          dao.findByMenuId(10); result = m2;
          // dao.findByCusId(1); result = m3;
        //   dao.findByMenuId(20); result = m3;
          dao.getWallentInfo("PAYTM", 100); result = w3;
        //   dao.getWallentInfo("NETBANKING", 100); result = w1;
        //   dao.getWallentInfo("PAYTM", 200); result = w4;
        //   dao.getWallentInfo("NETBANKING", 200); result = w2;
          dao.placeOrder(order1);
          dao.placeOrder(order2);
          dao.placeOrder(order3);
          dao.placeOrder(order4);
          dao.placeOrder(order5);
        }
      };
    new MockUp<OrderFactory>() {
        @Mock
        OrderDAO dao() {
          return dao;
        }
      };
    String result1 = OrderFactory.placeOrder(order1);
    assertEquals(result1, "Order Placed Successfully...");
    String result2 = OrderFactory.placeOrder(order2);
    assertEquals(result2, "Insufficient Funds...");
    String result3 = OrderFactory.placeOrder(order3);
    assertEquals(result3, "Order Cannot placed yesterday...");
    String result4 = OrderFactory.placeOrder(order4);
    assertEquals(result4, "Order Placed Successfully...");
    String result5 = OrderFactory.placeOrder(order5);
    assertEquals(result5, "Order Placed Successfully...");
  }
  /**
  * @param dao for mockingAcceptOrRejectOrde Mock Test.
  * @throws ParseException for converting date to string.
   */
  @Test
  public final void testAcceptOrRejectOrder(@Mocked final OrderDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final OrderDetail order1 = new OrderDetail(101, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    new Expectations() {
        {
          dao.findByOrderId(101); result = order1;
          dao.findByOrderId(102); result = null;
          dao.acceptOrReject("ACCEPTED", 101);
          dao.acceptOrReject("REJECTED", 101);
        }
      };
    new MockUp<OrderFactory>() {
        @Mock
        OrderDAO dao() {
          return dao;
        }
      };
    String result1 = OrderFactory.acceptOrRejectOrder(101, 2, "ACCEPTED");
    assertEquals(result1, "Order Accepted Successfully...");
    String result2 = OrderFactory.acceptOrRejectOrder(101, 2, "REJECTED");
    assertEquals(result2, "Order Rejected and Amount Refunded...");
    String result3 = OrderFactory.acceptOrRejectOrder(101, 301, "REJECTED");
    assertEquals(result3, "You are Unauthorized Vendor for this order...");
    String result4 = OrderFactory.acceptOrRejectOrder(102, 2, "REJECTED");
    assertEquals(result4, "Invalid OrderId...");
  }
  /**
  * Tests that a list with some pending vendor is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException for handling Dateformat errors.
  */
  @Test
  public final void testpendingVendor(@Mocked final OrderDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final OrderDetail v1 = new OrderDetail(6, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 10, 21, 11, 23, "PAYTM", "make it fast");
    final OrderDetail v2 = new OrderDetail(6, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 10, 21, 11, 23, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> vend200 = new ArrayList<OrderDetail>();
    vend200.add(v1);
    vend200.add(v2);
    final OrderDetail v3 = new OrderDetail(9, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 21, 22, 15, 27, "PAYTM", "make it fast");
    final OrderDetail v4 = new OrderDetail(10, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 21, 22, 15, 27, "PAYTM", "make it fast");
    final OrderDetail v5 = new OrderDetail(11, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 21, 22, 15, 27, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> vend201 = new ArrayList<OrderDetail>();
    vend201.add(v3);
    vend201.add(v4);
    vend201.add(v5);
    new Expectations() {
        {
          dao.pendingVendor(27); result = vend201;
          dao.pendingVendor(23); result = vend200;
        }
      };
    new MockUp<OrderFactory>() {
        @Mock
        OrderDAO dao() {
          return dao;
        }
      };
    OrderDetail[] pendvend1 = OrderFactory.showpendingVendorOrderDetails(27);
    OrderDetail[] pendvend2 = OrderFactory.showpendingVendorOrderDetails(23);
    assertEquals(3, pendvend1.length);
    assertEquals(2, pendvend2.length);
  }
  /**
  * Tests that a list with some pending customer is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException for handling Dateformat errors.
  */
  @Test
  public final void testpendingCustomer(@Mocked final OrderDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final OrderDetail m1 = new OrderDetail(1, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 21, 20, 15, 27, "PAYTM", "make it fast");
    final OrderDetail m2 = new OrderDetail(2, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 21, 20, 15, 27, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> cust100 = new ArrayList<OrderDetail>();
    cust100.add(m1);
    cust100.add(m2);
    final OrderDetail m3 = new OrderDetail(3, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 21, 22, 15, 27, "PAYTM", "make it fast");
    final OrderDetail m4 = new OrderDetail(4, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 25, 22, 15, 27, "PAYTM", "make it fast");
    final OrderDetail m5 = new OrderDetail(5, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 21, 22, 15, 27, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> cust101 = new ArrayList<OrderDetail>();
    cust101.add(m3);
    cust101.add(m4);
    cust101.add(m5);
    new Expectations() {
        {
          dao.pendingCustomer(22); result = cust101;
          dao.pendingCustomer(20); result = cust100;
        }
      };
    new MockUp<OrderFactory>() {
        @Mock
        OrderDAO dao() {
          return dao;
        }
      };
    OrderDetail[] pending1 = OrderFactory.showpendingCustomeOrderDetails(20);
    OrderDetail[] pending2 = OrderFactory.showpendingCustomeOrderDetails(22);
    assertEquals(2, pending1.length);
    assertEquals(3, pending2.length);
  }
  /**
  * @param dao for mocking cancleorder Mock Test.
  * @throws ParseException for converting date to string.
   */
  @Test
  public final void testCancelOrder(@Mocked final OrderDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final OrderDetail order1 = new OrderDetail(101, odt, 100.0, "Kolkata", OrderStatus.PENDING, 2, 2001, 1001, 3001, "PAYTM", "make it fast");
    final OrderDetail order2 = new OrderDetail(102, odt, 100.0, "Kolkata", OrderStatus.PENDING, 2, 2002, 1001, 3001, "PAYTM", "make it fast");
    final OrderDetail order3 = new OrderDetail(103, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 2, 2003, 1001, 3001, "PAYTM", "make it fast");
    final OrderDetail order4 = new OrderDetail(104, odt, 100.0, "Kolkata", OrderStatus.PENDING, 2, 2007, 1001, 3001, "PAYTM", "make it fast");

    new Expectations() {
        {
          dao.findByOrderId(101); result = order1;
          dao.acceptOrReject("CANCELLED", 101);
          dao.findByOrderId(102); result = order2;
          dao.findByOrderId(103); result = order3;
          // dao.findByOrderId(105); result = null;
        }
      };
    new MockUp<OrderFactory>() {
        @Mock
        OrderDAO dao() {
          return dao;
        }
      };
    String result6 = OrderFactory.cancelOrder(101, 2001, "YES");
    assertEquals(result6, "Order Cancelled Successfully...");
    String result7 = OrderFactory.cancelOrder(102, 2004, "YES");
    assertEquals(result7, "You are Unauthorized Customer");
    String result8 = OrderFactory.cancelOrder(103, 2003, "YES");
    assertEquals(result8, "You cannot cancel this order..");
    // String result9 = OrderFactory.cancelOrder(105, 2007, "YES");
    // assertEquals(result9, "You are Unauthorized to cancel this order ...");
  }
  /**
  * Tests that a list with some employees is handled correctly.
  * @param dao mocking the dao class.
  * @throws ParseException for handling Dateformat errors.
  */
  @Test
  public final void testListAllSome1(@Mocked final OrderDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final OrderDetail m2 = new OrderDetail(101, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 2, 2001, 1001, 3001, "PAYTM", "make it fast");
    final OrderDetail m3 = new OrderDetail(101, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 2, 2001, 1001, 3001, "PAYTM", "make it fast");
    final ArrayList<OrderDetail> mn = new ArrayList<OrderDetail>();
    new Expectations() {
      {
        mn.add(m2);
        mn.add(m3);
        dao.show(); result = mn;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      OrderDAO dao() {
        return dao;
      }
    };
    OrderDetail[] mn1 = OrderFactory.showOrderDetail();
    assertEquals(2, mn1.length);
    assertEquals(101, mn1[0].getOrdId());
    assertEquals(101, mn1[1].getOrdId());
    assertEquals(odt, mn1[0].getOrdTime());
    assertEquals(odt, mn1[1].getOrdTime());
    assertEquals(100, mn1[0].getOrdAmount(), 0);
    assertEquals(100, mn1[1].getOrdAmount(), 0);
    assertEquals(OrderStatus.ACCEPTED, mn1[0].getOrdStatus());
    assertEquals(OrderStatus.ACCEPTED, mn1[1].getOrdStatus());
    assertEquals(2, mn1[0].getQtyOrder());
    assertEquals(2, mn1[1].getQtyOrder());
    assertEquals(2001, mn1[0].getCusId());
    assertEquals(2001, mn1[1].getCusId());
    assertEquals(1001, mn1[0].getFoodId());
    assertEquals(1001, mn1[1].getFoodId());
    assertEquals(3001, mn1[0].getVenId());
    assertEquals(3001, mn1[1].getVenId());
    assertEquals("PAYTM", mn1[0].getWalType());
    assertEquals("make it fast", mn1[0].getOrdComments());
    assertEquals("PAYTM", mn1[1].getWalType());
    assertEquals("make it fast", mn1[1].getOrdComments());
  }
   /**
   * tests for constructor.
   */
  @Test
  public final void testConstructor() {
    assertNotNull(new OrderFactory());
    assertNotNull(OrderFactory.dao());
  }
}
