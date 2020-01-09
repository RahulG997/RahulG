package com.hexaware.model;
 import java.util.OBjects;

 
 
/**
 * Program To employ Model Class
 * @author Sarbani
 */
public class Employ{
    public int empno;
    public String name;
    public double basic;
 
 
 public Employ (int argEmpno, 
  String argName, double argBasic) {
  this.empno = argEmpno;
  this.name = argName;
  this.basic = argBasic;

  
@Overwrite 
intob public intObjects ob}
 
  @Override
  public boolean equals (Object ob){
     Employ employ = (Employ)ob;
     if(this.basic == employ.basic){
         return true;
     }
     else {
         return false;
          }
     }
  
 
  @Override
  public String toString() {
      return " Empno " +empno+ " Name " +name+  "salary" +basic;
  }
 }
