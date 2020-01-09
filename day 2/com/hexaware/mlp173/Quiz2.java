package com.hexaware.mlp173;
/**
 * *Program to Method Overloading.
 * @author Rahul
 */
public class Quiz2
{
    public void show(Object x)
    {
        System.out.println("Object " +x);
    }
    public void show(double x)
    {
        System.out.println("Double " +x);
    }
    public static void main(String[] args)
    {
    int a=12;
    Quiz2 obj=new Quiz2();
    obj.show(a);
}}