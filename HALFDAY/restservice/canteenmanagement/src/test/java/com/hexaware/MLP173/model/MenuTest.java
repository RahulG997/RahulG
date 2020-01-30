package com.hexaware.MLP173.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//import com.hexaware.MLP173.factory.MenuFactory;
//import com.hexaware.MLP173.model.Menu;
//import com.hexaware.MLP173.persistence.MenuDAO;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
// import mockit.Expectations;
// import mockit.Mock;
// import mockit.Mocked;
// import java.util.ArrayList;
// import mockit.MockUp;
import mockit.integration.junit4.JMockit;
//import static org.junit.Assert.assertTrue;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
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
  public final void testMenu() {
    Menu m = new Menu();
    assertNotNull(m);
    Menu menu = new Menu(1, "Dosa", "South-Indian", 120.00, FoodStatus.AVAILABLE, "4.0");
    assertEquals(1, menu.getFoodId());
    assertEquals("Dosa", menu.getFoodName());
    assertEquals("South-Indian", menu.getFoodDetail());
    assertEquals(120, menu.getFoodPrice(), 0);
    assertEquals(FoodStatus.AVAILABLE, menu.getFoodStatus());
    assertEquals("4.0", menu.getFoodRating());
    m.setFoodId(1);
    m.setFoodName("Dosa");
    m.setFoodDetail("South-Indian");
    m.setFoodPrice(120);
    m.setFoodStatus(FoodStatus.AVAILABLE);
    m.setFoodRating("4.0");
    assertEquals(1, menu.getFoodId());
    assertEquals("Dosa", menu.getFoodName());
    assertEquals("South-Indian", menu.getFoodDetail());
    assertEquals(120, menu.getFoodPrice(), 0);
    assertEquals(FoodStatus.AVAILABLE, menu.getFoodStatus());
    assertEquals("4.0", menu.getFoodRating());
  }
  /**
   * tests that empty menu list is handled correctly.
   * @param dao mocking the dao class
   */
  // @Test
  // public final void testListAllEmpty(@Mocked final MenuDAO dao) {
  //   new Expectations() {
  //     {
  //       dao.show(); result = new ArrayList<Menu>();
  //     }
  //   };
  //   new MockUp<MenuFactory>() {
  //     @Mock
  //     MenuDAO dao() {
  //       return dao;
  //     }
  //   };
  //   Menu[] me = MenuFactory.showMenu();
  //   assertEquals(0, me.length);
  // }
  // /**
  //  * Tests that a list with some employees is handled correctly.
  //  * @param dao mocking the dao class
  //  */
  // @Test
  // public final void testListAllSome(@Mocked final MenuDAO dao) {
  //   final Menu m100 = new Menu(1, "Dosa", "South-Indian", 120.00, FoodStatus.AVAILABLE, "4.0");
  //   final Menu m101 = new Menu(2, "Biryani", "North-Indian", 220.00, FoodStatus.NOTAVAILABLE, "4.5");
  //   final ArrayList<Menu> mn = new ArrayList<Menu>();
  //   new Expectations() {
  //     {
  //       mn.add(m100);
  //       mn.add(m101);
  //       dao.show();
  //       result = mn;
  //     }
  //   };
  //   new MockUp<MenuFactory>() {
  //     @Mock
  //     MenuDAO dao() {
  //       return dao;
  //     }
  //   };
  //   Menu[] mn1 = MenuFactory.showMenu();
  //   assertEquals(2, mn1.length);
  //   assertEquals(1, mn1[0].getFoodId());
  //   assertEquals(2, mn1[1].getFoodId());
  // }
}
