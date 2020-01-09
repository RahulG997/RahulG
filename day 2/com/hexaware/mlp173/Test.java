package com.hexaware.mlp173;
/**
 * *Program to Method Overloading.
 * @author Rahul
 */
public class Test
{
    public void show(int x)
    {
        System.out.println("Show w.r.t Integer "+x);
    }
    public void show(String x)
    {
        System.out.println("Show w.r.t String "+x);
    }
    public void show(boolean x)
    {
        System.out.println("Show w.r.t Boolean "+x);
    }
    public static void main(String[]args)
    {
        Test t=new Test();
        t.show(12);
        t.show("Hexaware");
        t.show(true);
    }
}