package com.hexaware.mlp173;
/**
 * *Program to Boxing And Unboxing.
 * @author Rahul
 */
public class Boxing
{
    public static void main(String[] args)
    {
        int a=12;
        double b=12.5;
        String name="Welcome";

        /* Boxing */

        Object ob1 = a;
        Object ob2 = b;
        Object ob3 = name;
        
        /* Unboxing */

        int a1=(Integer)ob1;  /* Type casting*/
        double b1=(Double) ob2;
        String s1=(String)ob3;
        System.out.println(a1);
        System.out.println(b1);
        System.out.println(s1);

    }
}