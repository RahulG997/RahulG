package com.hexaware.MLP173.factory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
// import static org.junit.Assert.assertNull;
import com.hexaware.MLP173.model.FoodStatus;
import com.hexaware.MLP173.model.Menu;
import com.hexaware.MLP173.persistence.MenuDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.Mock;
import mockit.Mocked;
import java.util.ArrayList;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
//import com.hexaware.MLP173.factory.MenuFactory;


/**
 * Test class for MenuFactory.
 */
@RunWith(JMockit.class)
public class MenuFactoryTest {
   /**
   * tests for constructor.
   */
  @Test
  public final void testConstructor() {
    assertNotNull(new MenuFactory());
    assertNotNull(MenuFactory.dao());
  }
  /**
   * tests that empty menu list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Menu>();
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] me = MenuFactory.showMenu();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(1, "Dosa", "South-Indian", 120.00, FoodStatus.AVAILABLE, "4.0");
    final Menu m101 = new Menu(2, "Biryani", "North-Indian", 220.00, FoodStatus.NOTAVAILABLE, "4.5");
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.show();
        result = mn;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showMenu();
    assertEquals(2, mn1.length);
    assertEquals(1, mn1[0].getFoodId());
    assertEquals(2, mn1[1].getFoodId());
  }
//   /**
//   * Tests that a list with some employees is handled correctly.
//   * @param dao mocking the dao class
//   */
//   @Test
//  public final void testSearchById(@Mocked final MenuDAO dao) {
//     final Menu m2 = new Menu(1, "Dosa", "South-Indian", 120.00, FoodStatus.AVAILABLE, "4.0");
//     final Menu m3 = new Menu(2, "Biryani", "North-Indian", 220.00, FoodStatus.NOTAVAILABLE, "4.5");
//     new Expectations() {
//       {
//         dao.show(1); result = m2;
//         dao.show(2); result = m3;
//         dao.show(3); result = null;
//       }
//     };
//     new MockUp<MenuFactory>() {
//       @Mock
//       MenuDAO dao() {
//         return dao;
//       }
//     };
//     assertEquals(1, MenuFactory.showMenu(1));
//     assertEquals(2, MenuFactory.showMenu(2));
//     // assertEquals(null,MenuFactory.showMenu(3));
//   }
}
