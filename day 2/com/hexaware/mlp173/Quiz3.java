package com.hexaware.mlp173;
/**
 * *Program to Method Overloading.
 * @author Rahul
 */
public class Quiz3
{
    public void show(Object x)
    {
        System.out.println("Object " +x);
    }
    public void show(double x)
    {
        System.out.println("Int " +x);
    }
    public static void main(String[] args)
    {
    boolean flag=true;;
    Quiz3 obj=new Quiz3();
    obj.show(flag);
}}