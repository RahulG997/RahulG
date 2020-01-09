package com.hexaware.mlp173;
import com.hexaware.model.Student;
/**
 * *Program to Boxing And Unboxing.
 * @author Rahul
 */

 public class BoxStudent
 {
     public void show(Object ob)
     {
         // int x=(Integer)ob;
         Student s=(Student)ob;
         System.out.println(s);
     }
     public static void main(String[] args)
     {
         Student st=new Student();
         st.sno=1;
         st.sname="Sougata";
         st.cgp=9.3;
         st.city="CHENNAI";
         BoxStudent obj=new BoxStudent();
         obj.show(st);
        
        }
     }
 