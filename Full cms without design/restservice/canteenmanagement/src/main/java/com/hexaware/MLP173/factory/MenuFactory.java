package com.hexaware.MLP173.factory;

import com.hexaware.MLP173.persistence.MenuDAO;
import com.hexaware.MLP173.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP173.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  public static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().show();
    return menu.toArray(new Menu[menu.size()]);
  }
   /**
   * Call the data base connection.
   * @param menuId for reading menu details.
   * @return the array of menu object.
   */
  public static Menu showMenu(final int menuId) {
    Menu menu = dao().show(menuId);
    return menu;
  }
}
