package com.hexaware.mlp173;
/**
 * *Program to Boxing And Unboxing.
 * @author Rahul
 */

 public class BoxTest
 {
     public void show(Object ob)
     {
        String type=ob.getClass().getSimpleName(); //getClass() show datatype of object
        //String type=ob.getClass().getName();
         System.out.println(type);
     }
     public static void main(String[] args)
     {
         int a=12;
         double b=12.5;
         String name="hexaware";
         BoxTest obj = new BoxTest();
         obj.show(a);
         obj.show(name);
         obj.show(b);

     }
 }


