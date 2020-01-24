package com.hexaware.MLP173.model;
import com.hexaware.MLP173.factory.VendorFactory;
import com.hexaware.MLP173.persistence.VendorDAO;
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

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class VendorTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testEquals() {
    Vendor vendor3 = null;
    Vendor vendor1 = new Vendor(1, "Aman", "Password", "abc@xyz.com", "6207701328", "Chennai");
    Vendor vendor2 = new Vendor(1, "Aman", "Password", "abc@xyz.com", "6207701328", "Chennai");
    //Vendor m2 = new Vendor();
    assertTrue(vendor1.equals(vendor2));
    assertFalse(vendor1.equals(vendor3));
    Menu m2 = new Menu();
    assertFalse(vendor1.equals(m2));
    Vendor m1 = new Vendor();
    assertFalse(m1.equals(vendor1));
    assertEquals(vendor1.hashCode(), vendor2.hashCode());
  }
  /**
   * Tests the toString() methods of the Customer class.
   * @throws ParseException for date format validation.
   */
  @Test
  public final void testToString() throws ParseException {
    Vendor vendor1 = new Vendor(1, "Aman", "Password", "abc@xyz.com", "6207701328", "Chennai");
    String result = String.format("%16s %15s %25s %20s %20s",
        vendor1.getVenId(), vendor1.getVenName(), vendor1.getVenEmail(), vendor1.getVenMobile(), vendor1.getVenAddress());
    assertEquals(result, vendor1.toString());
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testVendor() {
    Vendor m = new Vendor();
    assertNotNull(m);
    Vendor ven = new Vendor(1, "Aman", "Password", "abc@xyz.com", "6207701328", "Chennai");
    assertEquals(1, ven.getVenId());
    assertEquals("Aman", ven.getVenName());
    assertEquals("Password", ven.getVenPassword());
    assertEquals("abc@xyz.com", ven.getVenEmail());
    assertEquals("6207701328", ven.getVenMobile());
    assertEquals("Chennai", ven.getVenAddress());
    m.setVenId(1);
    m.setVenName("Aman");
    m.setVenPassword("Password");
    m.setVenEmail("abc@xyz.com");
    m.setVenMobile("6207701328");
    m.setVenAddress("Chennai");
    assertEquals(1, m.getVenId());
    assertEquals("Aman", m.getVenName());
    assertEquals("Password", m.getVenPassword());
    assertEquals("abc@xyz.com", m.getVenEmail());
    assertEquals("6207701328", m.getVenMobile());
    assertEquals("Chennai", m.getVenAddress());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
   public final void testListAllEmpty(@Mocked final VendorDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Vendor>();
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor[] me = VendorFactory.showVendor();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class.
   * @throws ParseException for handling Dateformat errors.
   */
  @Test
  public final void testListAllSome(@Mocked final VendorDAO dao) throws ParseException {
    final Vendor m2 = new Vendor(1, "Aman", "Password", "abc@xyz.com", "6207701328", "Chennai");
    final Vendor m3 = new Vendor(1, "Aman", "Password", "abc@xyz.com", "6207701328", "Chennai");
    final ArrayList<Vendor> mn = new ArrayList<Vendor>();
    new Expectations() {
      {
        mn.add(m2);
        mn.add(m3);
        dao.show(); result = mn;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor[] mn1 = VendorFactory.showVendor();
    assertEquals(2, mn1.length);
    assertEquals(1, mn1[0].getVenId());
    assertEquals(1, mn1[1].getVenId());
    assertEquals("Aman", mn1[0].getVenName());
    assertEquals("Aman", mn1[1].getVenName());
    assertEquals("Password", mn1[0].getVenPassword());
    assertEquals("Password", mn1[1].getVenPassword());
    assertEquals("abc@xyz.com", mn1[0].getVenEmail());
    assertEquals("abc@xyz.com", mn1[1].getVenEmail());
    assertEquals("6207701328", mn1[0].getVenMobile());
    assertEquals("6207701328", mn1[1].getVenMobile());
    assertEquals("Chennai", mn1[0].getVenAddress());
    assertEquals("Chennai", mn1[1].getVenAddress());
  }
}

