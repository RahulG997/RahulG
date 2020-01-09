package com.hexaware.mlp173;
import com.hexaware.model.Employ;
/**
 * *Program to Boxing And Unboxing.
 * @author Rahul
 */

 public class EmpDAO
 {
     public static void main(String[] args)
     {
         Employ employ=new Employ();
         employ.empno=1;
         employ.name="Sougata";
         employ.basic=94333;
         employ.gender="Male";
         Employ e2 = new Employ();
         e2.empno=3;
         e2.name="Rahul";
         e2.basic=88234;
         e2.gender="Male";
         Employ e3=new Employ(); 
         e3.empno=4;
         e3.name="Sarbani";
         e3.basic=88434;
         e3.gender="Female";
         System.out.printf("%10s %10s %10s %10s","Empno","Name","Salary", "Gender\n");
        //  System.out.println(employ);
        //  System.out.println(e2);
        Employ[] arr={employ,e2,e3};
        for(Employ e : arr) {
            System.out.println(e);
        }
     }
 }