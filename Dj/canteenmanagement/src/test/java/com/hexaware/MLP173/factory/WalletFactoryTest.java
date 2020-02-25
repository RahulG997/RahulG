package com.hexaware.MLP173.factory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
// import com.hexaware.MLP175.factory.WalletFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.hexaware.MLP173.model.Wallet;
import com.hexaware.MLP173.persistence.WalletDAO;
import com.hexaware.MLP173.model.WalType;

import mockit.Expectations;
//import java.text.ParseException;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
//import static org.junit.Assert.assertEquals;

/**
 * Test class for Wallet.
 */
@RunWith(JMockit.class)
public class WalletFactoryTest {
   /**
   * tests for constructor.
   */
  @Test
  public final void testConstructor() {
    assertNotNull(new WalletFactory());
    assertNotNull(WalletFactory.dao());
  }
    /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testshow(@Mocked final WalletDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Wallet>();
      }
    };
    new MockUp<WalletFactory>() {
      @Mock
      WalletDAO dao() {
        return dao;
      }
    };
    Wallet[] me = WalletFactory.showWallet();
    assertEquals(0, me.length);
  }
//     /**
//   * Tests that a list with some pending vendor is handled correctly.
//   * @param dao mocking the dao class.
//   * @throws ParseException for handling Dateformat errors.
//   */
//   @Test
//   public final void testshowwalletbycusid(@Mocked final WalletDAO dao) throws ParseException {

// }
 /**
   * Tests that a list Employ Search by customer id.
   * @param dao mocking the dao class.
   */
  @Test
  public final void testwalletId(@Mocked final WalletDAO dao) {
    final Wallet w1 = new Wallet(1, 1, 1200, WalType.PAYTM);
    final Wallet w2 = new Wallet(2, 2, 1200, WalType.CREDITCARD);
    final Wallet w3 = new Wallet(3, 3, 1800, WalType.DEBITCARD);
    final Wallet w4 = new Wallet(4, 1, 1000, WalType.PAYTM);
    final ArrayList<Wallet> list1 = new ArrayList<Wallet>();
    list1.add(w1);
    list1.add(w2);
    final ArrayList<Wallet> list2 = new ArrayList<Wallet>();
    list2.add(w3);
    list2.add(w4);
    new Expectations() {
      {
        dao.showByWalletId(1); result = list1;
        dao.showByWalletId(2); result = list2;
      }
    };
    new MockUp<WalletFactory>() {
      @Mock
      WalletDAO dao() {
        return dao;
      }
    };
    Wallet[] e1 = WalletFactory.showWallet(1);
    Wallet[] e2 = WalletFactory.showWallet(2);
    assertEquals(2, e1.length);
    assertEquals(2, e2.length);
  }
}
