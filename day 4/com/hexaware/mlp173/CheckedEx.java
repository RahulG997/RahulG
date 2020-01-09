package com.hexaware.mlp173;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

 /**
* Program to Abstract class Demo.
* @author Rahul.
*/

 public class CheckedEx
 {
     public void check() throws FileNotFoundException
     {
         FileInputStream fin = new
         FileInputStream("d:hello.txt");
     }
     public static void main(String[] args)
     {
         CheckedEx obj=new CheckedEx();
         try
         {
            obj.check();
         }
         catch(FileNotFoundException e)
         {
             System.out.println("File not exits");
         }
         
     }
 }