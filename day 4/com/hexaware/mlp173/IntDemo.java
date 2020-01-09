package com.hexaware.mlp173;

import java.security.CodeSource;

interface Course
{
    void mysql();
    void java();
}
class Raj implements Course 
{
  
    public void mysql()
    {
        System.out.println("Mysql 8.0");
    }
    @Override
    public void java()
    {
        System.out.println("java 8 for mavericks");
    }
}
    class Madhu implements Course
    {
        public void mysql()
        {
            System.out.println("Mysql 8.0");
        }
        @Override
        public void java()
        {
            System.out.println("Java 8 for mavericks");
        }
}
    public class IntDemo
    {
         public static void main(String[] args) 
         {
            Course[] arr=new Course[]
            {
                new Raj(),
                new Madhu()
            };
            for(Course c : arr)
            {
                c.mysql();
                c.java();
            }
         }
    }


