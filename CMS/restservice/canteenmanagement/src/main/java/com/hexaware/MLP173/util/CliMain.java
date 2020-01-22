package com.hexaware.MLP173.util;

import java.util.Date;
import java.util.Scanner;
import java.io.Console;
import java.text.SimpleDateFormat;

import java.text.ParseException;
import com.hexaware.MLP173.factory.CustomerFactory;
import com.hexaware.MLP173.factory.OrderFactory;
import com.hexaware.MLP173.factory.VendorFactory;
import com.hexaware.MLP173.factory.MenuFactory;
import com.hexaware.MLP173.model.Menu;
import com.hexaware.MLP173.model.Customer;
import com.hexaware.MLP173.model.OrderDetail;
import com.hexaware.MLP173.model.Vendor;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Show Vendor");
    System.out.println("3. Customer Info");
    System.out.println("4. Pending Orders");
    System.out.println("5. Order History");
    System.out.println("6. Show Full Order");
    System.out.println("7. Accept And Reject");
    System.out.println("8. Place Order");
    System.out.println("9. Cancel Order");
    System.out.println("10. Exit");
    mainMenuDetails();
  }
/**
 * mainMenuDetails method  process the option selected from main menu.
 */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          showVendorInfo();
          break;
        case 3:
          showCustomerInfo();
          break;
        case 4:
          pendingOrders();
          break;
        case 5:
          orderHistory();
          break;
        case 6:
          showFullOrder();
          break;
        case 7:
          acceptReject();
          break;
        case 8:
          placeOrder();
          break;
        case 9:
          cancelOrder();
          break;
        case 10:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
  private void cancelOrder() {
    int ordId;
    int custId;
    String status;
    System.out.println("Enter Order Id  ");
    ordId = option.nextInt();
    System.out.println("Enter Customer Id  ");
    custId = option.nextInt();
    System.out.println("Cancel (yes/No)  ");
    status = option.next();
    if (status.toUpperCase().equals("YES")) {
      System.out.println(OrderFactory.cancelOrder(ordId, custId, status));
    }
  }
 /**
  * accept and reject.
  */
  private void acceptReject() {
    int ordId;
    int vendorId;
    String status;
    System.out.println("Enter Order Id  ");
    ordId = option.nextInt();
    System.out.println("Enter Vendor Id  ");
    vendorId = option.nextInt();
    System.out.println("ACCEPTED or REJECTED  ");
    status = option.next();
    System.out.println(OrderFactory.acceptOrRejectOrder(ordId, vendorId, status));
  }
  private void placeOrder() {
    OrderDetail orderdetail = new OrderDetail();
    System.out.println("Enter Customer ID ");
    orderdetail.setCusId(option.nextInt());
    System.out.println("Enter Menu Id  ");
    orderdetail.setFoodId(option.nextInt());
    System.out.println("Enter Vendor Id ");
    orderdetail.setVenId(option.nextInt());
    System.out.println("Enter Quantity ");
    orderdetail.setQtyOrder(option.nextInt());
    System.out.println("Enter Vallet Source ");
    String ws = option.next();
    orderdetail.setWalType(ws);
    System.out.println("Enter Order Date (yyyy-MM-dd)  ");
    String ord = option.next();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date dt = sdf.parse(ord);
      orderdetail.setOrdTime(dt);
    } catch (ParseException e) {
      System.out.println(e);
    }
    System.out.println("Enter Order Comments ");
    orderdetail.setOrdComments(option.next());
    System.out.println(OrderFactory.placeOrder(orderdetail));
  }
  private void showCustomerInfo() {
    String user;
    String password;
    System.out.println("Enter cutomer user name ");
    user = option.next();
    Console console = System.console();
    char[] pwd = console.readPassword("Enter password ");
    password = String.valueOf(pwd);
    int count = CustomerFactory.validateCustomer(user, password);
    System.out.println(count);
    if (count == 1) {
      Customer customerFound = CustomerFactory.findByCustomerName(user);
      System.out.println(customerFound);
    } else {
      System.out.println("Invalid Credentials...");
    }
  }
  private void showVendorInfo() {
    String user;
    String password;
    System.out.println("Enter vendor user name ");
    user = option.next();
    Console console = System.console();
    char[] pwd = console.readPassword("Enter password ");
    password = String.valueOf(pwd);
    System.out.println("----------------------------------------------------"
          + "----------------------------------------------");
    System.out.printf("%-15s %-20s %-20s %-15s %-15s", "Vendor Id", "Vendor Name",
        "Vendor E-mail", "Vendor Mobile", " Vendor Address");
    System.out.println();
    System.out.println("----------------------------------------------------"
          + "----------------------------------------------");
    int count = VendorFactory.validateVendor(user, password);
    if (count == 1) {
      Vendor vendorFound = VendorFactory.findByVendorName(user);
      System.out.println(vendorFound);
    } else {
      System.out.println("Invalid Credentials...");
    }
  }
  private void orderHistory() {
    System.out.println("Orders history:\n1. Customer\n2. Vendor");
    int choice = option.nextInt();
    int count = 0;
    if (choice == 1) {
      System.out.println("Enter customer Name");
      String username = option.next();
      Console console = System.console();
      char[] pwd = console.readPassword("Enter Customer password");
      String password = String.valueOf(pwd);
        //String password = option.next();
      try {
        count = CustomerFactory.validateCustomer(username, password);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        mainMenu();
      }
      if (count == 1) {
        Customer customer = CustomerFactory.findByCustomerName(username);
        int cusId = customer.getCusId();
        OrderDetail[] cusHistory = OrderFactory.showCustomerHistory(cusId);
        System.out.println("----------------------------------------------------"
            + "----------------------------------------------");
        System.out.printf("%5s %10s %10s %10s %10s %10s", "Order id", "Order Date",
            "Bill Amount", "Order Status", "Order Qty", "Customer ID");
        System.out.println();
        System.out.println("----------------------------------------------------"
            + "----------------------------------------------");
        for (OrderDetail orderdetail : cusHistory) {
          System.out.println(orderdetail);
          System.out.println();
        }
      } else {
        System.out.println("Invalid Credentials...");
      }
    } else {
      System.out.println("Enter Vendor Name For Order History");
      String username = option.next();
      Console console = System.console();
      char[] pwd = console.readPassword("Enter Vendor password For Order History");
      String password = String.valueOf(pwd);
        //String password = option.next();
      try {
        count = VendorFactory.validateVendor(username, password);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        mainMenu();
      }
      if (count == 1) {
        Vendor vendor = VendorFactory.findByVendorName(username);
        int venId = vendor.getVenId();
        OrderDetail[] venHistory = OrderFactory.showVendorHistory(venId);
        System.out.println("----------------------------------------------------"
            + "----------------------------------------------");
        System.out.printf("%5s %10s %10s %10s %10s %10s", "Order id", "Order Date",
            "Order Amount", "Order Status", "Order Qty", "Vendor ID");
        System.out.println();
        System.out.println("----------------------------------------------------"
            + "----------------------------------------------");
        for (OrderDetail orderdetail : venHistory) {
          System.out.println(orderdetail);
          System.out.println();
        }
      } else {
        System.out.println("Invalid Credentials...");
      }
    }
  }
  private void pendingOrders() {
    System.out.println("PENDING ORDERS:\n1. Customer Pending Orders\n2. Vendor Pending Orders");
    int choice = option.nextInt();
    int count = 0;
    if (choice == 1) {
      System.out.println("Enter UserName");
      String username = option.next();
      Console console = System.console();
      char[] pwd = console.readPassword("Enter password");
      String password = String.valueOf(pwd);
        //String password = option.next();
      try {
        count = CustomerFactory.validateCustomer(username, password);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        mainMenu();
      }
      if (count == 1) {
        Customer customer = CustomerFactory.findByCustomerName(username);
        int cusId = customer.getCusId();
        OrderDetail[] cusHistory = OrderFactory.showpendingCustomeOrderDetails(cusId);
        System.out.println("----------------------------------------------------"
            + "----------------------------------------------");
        System.out.printf("%5s %10s %10s %10s %10s %10s %10s %10s %10s", "Order id",
            "Order Time", "Order Amount", "Order Status", "Order Quantity", "Customer Id",
            "Food Id", "Vendor Id", "Wallet Type");
        System.out.println();
        System.out.println("----------------------------------------------------"
            + "----------------------------------------------");
        for (OrderDetail orderdetail : cusHistory) {
          System.out.println(orderdetail);
          System.out.println();
        }
      } else {
        System.out.println("Invalid Credentials...");
      }
    } else {
      System.out.println("Enter vendor Name to check pending ord");
      String username = option.next();
      Console console = System.console();
      char[] pwd = console.readPassword("Enter Vendor password to check pending ord");
      String password = String.valueOf(pwd);
    //String password = option.next();
      try {
        count = VendorFactory.validateVendor(username, password);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        mainMenu();
      }
      if (count == 1) {
        Vendor vendor = VendorFactory.findByVendorName(username);
        int venId = vendor.getVenId();
        OrderDetail[] venHistory = OrderFactory.showpendingVendorOrderDetails(venId);
        System.out.println("----------------------------------------------------"
            + "----------------------------------------------");
        System.out.printf("%5s %10s %10s %10s %10s %10s %10s %10s", "Order id",
            "Order Time", "Order Amount", "Order Status", "Order Quantity", "Customer Id",
            "Food Id", "Wallet Type");
        System.out.println();
        System.out.println("----------------------------------------------------"
            + "----------------------------------------------");
        for (OrderDetail orderdetail : venHistory) {
          System.out.println(orderdetail);
          System.out.println();
        }
      } else {
        System.out.println("Invalid Credentials...");
      }
    }
  }

/**
 * showFullMenu method  display the menu item stored in database.
 */
  private void showFullMenu() {
    Menu[] menu = MenuFactory.showMenu();
    System.out.println("----------------------------------------------------------"
            + "----------------------------------------------------");
    System.out.printf("%-15s %-25s %-15s %-15s %-15s %-15s", "Food id",
            "Food Name", "Food Price", "Food Status", "Food Detail", "Food Rating");
    System.out.println();
    System.out.println("----------------------------------------------------------"
            + "----------------------------------------------");
    for (Menu food : menu) {
      System.out.println(food);
      System.out.println();
    }
  }
  private void showFullOrder() {
    OrderDetail[] orderdetail = OrderFactory.showOrderDetail();
    System.out.println("-------------------------------------------------------------------"
        + "----------------------------------------------------"
        + "---------------------------");
    System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s", "Order id", "Order Time", "Order Amount",
            "Order Status", "Order Quantity", "Customer Id", "Food ID", "Vendor ID", "Wallet Type");
    System.out.println();
    System.out.println("----------------------------------------------------------"
            + "-------------------------------------------------------------"
            + "---------------------------");
    for (OrderDetail orderdetail2 : orderdetail) {
      System.out.println(orderdetail2);
      System.out.println();
    }
  }
/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}



