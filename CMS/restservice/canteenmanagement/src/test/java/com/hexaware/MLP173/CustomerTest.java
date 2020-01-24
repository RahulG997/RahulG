package com.hexaware.MLP173.model;
import com.hexaware.MLP173.factory.CustomerFactory;
import com.hexaware.MLP173.persistence.CustomerDAO;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
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
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class CustomerTest {
  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the Customer class.
   * @throws ParseException for Date checking
   */
  public final void testEquals() throws ParseException {
    Customer m = new Customer();
    assertNotNull(m);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dt = "1997-03-19";
    Date dob = sdf.parse(dt);
    Customer customer3 = null;
    Customer customer1 = new Customer(1, "Sarbani", "Password", "abc@xyz.com", "6789453765", dob, "Kolkata");
    Customer customer2 = new Customer(1, "Sarbani", "Password", "abc@xyz.com", "6789453765", dob, "Kolkata");
    //Customer m2 = new Customer();
    assertTrue(customer1.equals(customer2));
    assertFalse(customer1.equals(customer3));
    Menu m2 = new Menu();
    assertFalse(customer1.equals(m2));
    Customer m1 = new Customer();
    assertFalse(m1.equals(customer1));
    assertEquals(customer1.hashCode(), customer3.hashCode());
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   * @throws ParseException for Date checking.
   */
  @Test
  public final void testToString() throws ParseException {
    Customer m = new Customer();
    assertNotNull(m);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dt = "1997-03-19";
    Date dob = sdf.parse(dt);
    Customer customer1 = new Customer(1, "Aman", "Password", "abc@xyz.com", "6789453765", dob, "Chennai");
    Customer customer2 = new Customer(1, "Aman", "Password", "abc@xyz.com", "6789453765", dob, "Chennai");
    assertEquals(customer1.hashCode(), customer2.hashCode());
    Customer customer4 = new Customer(3, "Aman", "Password", "abc@xyz.com", "6789453765", dob, "Chennai");
    Vendor vendor = new Vendor();
    assertEquals(customer1, customer2);
    Customer customer3 = null;
    assertFalse(customer1.equals(customer3));
    assertFalse(customer1.equals(vendor));
    assertFalse(customer1.equals(customer4));
    String result = String.format("%5s %15s %25s %20s %20s %20s %20s",
        customer1.getCusId(), customer1.getCusName(), customer1.getCusPassword(),
        customer1.getCusEmail(), customer1.getCusMobile(), customer1.getCusDob(),
        customer1.getCusAddress());
    assertEquals(result, customer1.toString());
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   *  @throws ParseException for Date checking.
   */
  @Test
  public final void testCustomer() throws ParseException {
    Customer m = new Customer();
    assertNotNull(m);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dt = "1997-03-19";
    Date dob = sdf.parse(dt);
    Customer cust = new Customer(1, "Aman", "Password", "abc@xyz.com", "6207701328", dob, "Chennai");
    assertEquals(1, cust.getCusId());
    assertEquals("Aman", cust.getCusName());
    assertEquals("Password", cust.getCusPassword());
    assertEquals("abc@xyz.com", cust.getCusEmail());
    assertEquals("6207701328", cust.getCusMobile());
    assertEquals(dob, cust.getCusDob());
    assertEquals("Chennai", cust.getCusAddress());

    m.setCusId(1);
    m.setCusName("Aman");
    m.setCusPassword("Password");
    m.setCusEmail("abc@xyz.com");
    m.setCusMobile("6207701328");
    m.setCusDob(dob);
    m.setCusAddress("Chennai");

    assertEquals(1, m.getCusId());
    assertEquals("Aman", m.getCusName());
    assertEquals("Password", m.getCusPassword());
    assertEquals("abc@xyz.com", m.getCusEmail());
    assertEquals("6207701328", m.getCusMobile());
    assertEquals(dob, m.getCusDob());
    assertEquals("Chennai", m.getCusAddress());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
   public final void testListAllEmpty(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Customer>();
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] me = CustomerFactory.showCustomer();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class.
   * @throws ParseException for handling Dateformat errors.
   */
  @Test
  public final void testListAllSome(@Mocked final CustomerDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final Customer m2 = new Customer(1, "Aman", "Password", "abc@xyz.com", "6207701328", odt, "Chennai");
    final Customer m3 = new Customer(1, "Aman", "Password", "abc@xyz.com", "6207701328", odt, "Chennai");
    final ArrayList<Customer> mn = new ArrayList<Customer>();
    new Expectations() {
      {
        mn.add(m2);
        mn.add(m3);
        dao.show(); result = mn;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] mn1 = CustomerFactory.showCustomer();
    assertEquals(2, mn1.length);
    assertEquals(1, mn1[0].getCusId());
    assertEquals(1, mn1[1].getCusId());
    assertEquals("Aman", mn1[0].getCusName());
    assertEquals("Aman", mn1[1].getCusName());
    assertEquals("Password", mn1[0].getCusPassword());
    assertEquals("Password", mn1[1].getCusPassword());
    assertEquals("abc@xyz.com", mn1[0].getCusEmail());
    assertEquals("abc@xyz.com", mn1[1].getCusEmail());
    assertEquals("6207701328", mn1[0].getCusMobile());
    assertEquals("6207701328", mn1[1].getCusMobile());
    assertEquals(odt, mn1[0].getCusDob());
    assertEquals(odt, mn1[1].getCusDob());
    assertEquals("Chennai", mn1[0].getCusAddress());
    assertEquals("Chennai", mn1[1].getCusAddress());
  }
}

