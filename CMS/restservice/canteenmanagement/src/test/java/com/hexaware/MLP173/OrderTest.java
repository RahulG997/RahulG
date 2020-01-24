package com.hexaware.MLP173.model;
import com.hexaware.MLP173.factory.OrderFactory;
import com.hexaware.MLP173.persistence.OrderDAO;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;


/**
 * Test class for Order.
 */
@RunWith(JMockit.class)
public class OrderTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   *  @throws ParseException for date format validation.
   */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dt = new String("2020-03-18");
    Date odt = sdf.parse(dt);
    OrderDetail order3 = null;
    OrderDetail order1 = new OrderDetail(1, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    OrderDetail order2 = new OrderDetail(1, odt, 120.0, "Chennai", OrderStatus.CANCELLED, 1, 2, 1, 2, "CREDITCARD", "make it fast");
    assertTrue(order1.equals(order2));
    assertFalse(order1.equals(order3));
    Menu menu = new Menu();
    assertFalse(order1.equals(menu));
    OrderDetail o1 = new OrderDetail();
    assertFalse(order1.equals(o1));
    assertEquals(order1.hashCode(), order2.hashCode());
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   * @throws ParseException for date format validation.
   */
  @Test
  public final void testOrder() throws ParseException {
    OrderDetail o = new OrderDetail();
    assertNotNull(o);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dt = new String("2020-03-18");
    Date odt = sdf.parse(dt);
    OrderDetail order = new OrderDetail(1, odt, 100.0, "Kolkata", OrderStatus.ACCEPTED, 1, 2, 1, 2, "PAYTM", "make it fast");
    assertEquals(1, order.getOrdId());
    assertEquals(odt, order.getOrdTime());
    assertEquals(100.0, order.getOrdAmount(), 0);
    assertEquals("Kolkata", order.getOrdLocation());
    assertEquals(OrderStatus.ACCEPTED, order.getOrdStatus());
    assertEquals(1, order.getQtyOrder());
    assertEquals(2, order.getCusId());
    assertEquals(1, order.getFoodId());
    assertEquals(2, order.getVenId());
    assertEquals("PAYTM", order.getWalType());
    assertEquals("make it fast", order.getOrdComments());


    o.setOrdId(1);
    o.setOrdTime(odt);
    o.setOrdAmount(100.0);
    o.setOrdStatus(OrderStatus.ACCEPTED);
    o.setQtyOrder(1);
    o.setCusId(2);
    o.setFoodId(1);
    o.setVenId(2);
    o.setWalType("PAYTM");
    o.setOrdComments("make it fast");

    assertEquals(1, o.getOrdId());
    assertEquals(odt, o.getOrdTime());
    assertEquals(100.0, o.getOrdAmount(), 0);
    assertEquals(OrderStatus.ACCEPTED, o.getOrdStatus());
    assertEquals(1, o.getQtyOrder());
    assertEquals(2, o.getCusId());
    assertEquals(1, o.getFoodId());
    assertEquals(2, o.getVenId());
    assertEquals("PAYTM", o.getWalType());
    assertEquals("make it fast", o.getOrdComments());

  }
  /**
   * tests that empty employee list is handled correctly.
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
}
