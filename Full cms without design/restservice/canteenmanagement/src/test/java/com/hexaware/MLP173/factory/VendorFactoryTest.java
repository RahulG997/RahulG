package com.hexaware.MLP173.factory;
import com.hexaware.MLP173.model.Vendor;
import com.hexaware.MLP173.persistence.VendorDAO;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
import org.junit.Test;
//import org.junit.Before;
import org.junit.runner.RunWith;
import java.util.ArrayList;
// import static org.junit.Assert.assertNull;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
/**
 * Test class for vendorFactory.
 */
@RunWith(JMockit.class)
public class VendorFactoryTest {
  /**
   * tests for constructor.
   */
  @Test
  public final void testConstructor() {
    assertNotNull(new VendorFactory());
    assertNotNull(VendorFactory.dao());
  }
  /**
   *  * tests that empty employee list is handled correctly.
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
   */
  @Test
  public final void testListAllSome(@Mocked final VendorDAO dao) {
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
/**
   * Tests that a list with some is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testfindByVendorId(@Mocked final VendorDAO dao) {
    final Vendor m2 = new Vendor(1, "Aman", "Password", "abc@xyz.com", "6207701328", "Chennai");
    final Vendor m3 = new Vendor(1, "Aman", "Password", "abc@xyz.com", "6207701328", "Chennai");
    new Expectations() {
      {
        dao.findByVendorName("Aman"); result = m2;
        dao.findByVendorName("Raj"); result = m3;
        dao.findByVendorName("Sarbani"); result = null;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor vendor1 = VendorFactory.findByVendorName("Aman");
    assertNotNull(vendor1);
    Vendor vendor2 = VendorFactory.findByVendorName("Raj");
    assertNotNull(vendor2);
    Vendor vendor3 = VendorFactory.findByVendorName("Sarbani");
    assertNull(vendor3);
  }
  /**
   * Tests that a list Employ Search by Vendor id.
   * @param dao mocking the dao class.
   */
  @Test
  public final void testAuthenticate(@Mocked final VendorDAO dao)  {
    new Expectations() {
      {
        dao.authenticate("Sarbani", "Mukharji"); result = 1;
        dao.authenticate("Rahul", "Guchhait"); result = 1;
        dao.authenticate("Niharika", "Hexaware"); result = 0;
        // dao.findByVendorName("Arjun"); result = null;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    assertEquals(1, VendorFactory.validateVendor("Sarbani", "Mukharji"));
    assertEquals(1, VendorFactory.validateVendor("Rahul", "Guchhait"));
    assertEquals(0, VendorFactory.validateVendor("Niharika", "Hexaware"));
  }
  /**
   * Tests that a list Employ Search by Vendor id.
   * @param dao mocking the dao class.
   */
  @Test
  public final void testValidateVendor(@Mocked final VendorDAO dao) {
    new Expectations() {
      {
        dao.authenticate("Aman", "aman@123"); result = 1;
        dao.authenticate("Raj", "raj@123"); result = 1;
        dao.authenticate("arjun", "arjun123"); result = 0;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    assertEquals(1, VendorFactory.validateVendor("Aman", "aman@123"));
    assertEquals(1, VendorFactory.validateVendor("Raj", "raj@123"));
    assertEquals(0, VendorFactory.validateVendor("arjun", "arjun123"));
  }
}
