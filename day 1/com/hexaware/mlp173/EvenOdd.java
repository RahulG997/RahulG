package com.hexaware.mlp173;
public class EvenOdd
{
     public void check(int n)
     {
         if(n%2==0)
         {
            System.out.println("Even");
         }  
         else
         {
            System.out.println("Odd");

         }
         
     }

     public static void main(String[] args)
    {
    int n =Integer.parseInt(args[0]);
    EvenOdd obj=new EvenOdd();
    obj.check(n);
    }
}