package com.hexaware.MLP173.factory;
import com.hexaware.MLP173.model.Customer;
import com.hexaware.MLP173.persistence.CustomerDAO;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
import java.text.ParseException;
import org.junit.Test;
//import org.junit.Before;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import static org.junit.Assert.assertNull;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import java.util.Date;
import java.text.SimpleDateFormat;
import mockit.integration.junit4.JMockit;
/**
 * Test class for vendorFactory.
 */
@RunWith(JMockit.class)
public class CustomerFactoryTest {
  /**
   * tests for constructor.
   */
  @Test
  public final void testConstructor() {
    assertNotNull(new CustomerFactory());
    assertNotNull(CustomerFactory.dao());
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
  /**
   * Tests that a list with some is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException for handling date parse errors.
   */
  @Test
  public final void testfindByCustomerId(@Mocked final CustomerDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final String dt = new String("2020-03-18");
    final Date odt = sdf.parse(dt);
    final Customer m2 = new Customer(1, "Aman", "Password", "abc@xyz.com", "6207701328", odt, "Chennai");
    final Customer m3 = new Customer(2, "Raj", "Password1", "abc@xyz.com1", "6207701329", odt, "Cbe");
    new Expectations() {
      {
        dao.findByCustomerName("Aman"); result = m2;
        dao.findByCustomerName("Raj"); result = m3;
        dao.findByCustomerName("Sarbani"); result = null;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer customer1 = CustomerFactory.findByCustomerName("Aman");
    assertNotNull(customer1);
    Customer customer2 = CustomerFactory.findByCustomerName("Raj");
    assertNotNull(customer2);
    Customer customer3 = CustomerFactory.findByCustomerName("Sarbani");
    assertNull(customer3);
  }
  /**
   * Tests that a list Employ Search by customer id.
   * @param dao mocking the dao class.
   */
  @Test
  public final void testAuthenticate(@Mocked final CustomerDAO dao)  {
    new Expectations() {
      {
        dao.authenticate("Sarbani", "Mukharji"); result = 1;
        dao.authenticate("Rahul", "Guchhait"); result = 1;
        dao.authenticate("Niharika", "Hexaware"); result = 0;
        // dao.findByCustomerName("Arjun"); result = null;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    assertEquals(1, CustomerFactory.validateCustomer("Sarbani", "Mukharji"));
    assertEquals(1, CustomerFactory.validateCustomer("Rahul", "Guchhait"));
    assertEquals(0, CustomerFactory.validateCustomer("Niharika", "Hexaware"));
  }
  /**
   * Tests that a list Employ Search by customer id.
   * @param dao mocking the dao class.
   */
  @Test
  public final void testValidateCustomer(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.authenticate("Aman", "aman@123"); result = 1;
        dao.authenticate("Raj", "raj@123"); result = 1;
        dao.authenticate("arjun", "arjun123"); result = 0;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    assertEquals(1, CustomerFactory.validateCustomer("Aman", "aman@123"));
    assertEquals(1, CustomerFactory.validateCustomer("Raj", "raj@123"));
    assertEquals(0, CustomerFactory.validateCustomer("arjun", "arjun123"));
  }
}

