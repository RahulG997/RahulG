package com.hexaware.model;
import java.util.Objects;

/**
* Program to Employ Model Class.
* @author Prasanna.
*/
public class Employee {
    private int empno;
    private String name;
    private double basic;

 /**
 * @param argEmpno to initialize employ No.
 * @param argName to initialize employ name.
 * @param argBasic to initialize employ basic.
 * used to get details through constructor.
 */
  public Employee(int argEmpno, String argName,
        double argBasic) {
    this.empno = argEmpno;
    this.name = argName;
    this.basic = argBasic;
  }
   @Override
    public int hashCode() {
    return Objects.hash(empno, name, basic);
  }

  @Override
  public boolean equals(Object ob) {
      Employee employ = (Employee)ob;
      if(this.basic == employ.basic) {
          return true;
      } else {
          return false;
      }
  }

  @Override
  public String toString() {
      return "Empno " +empno+ " Name " +name+ 
               " Salary " +basic;
  }
}