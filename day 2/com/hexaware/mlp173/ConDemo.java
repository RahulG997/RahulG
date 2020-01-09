package com.hexaware.mlp173;
/**
 * *Program to Constructor.
 * @author Rahul
 */
public class ConDemo
{
    static
    {
        System.out.println("Static Constructor...");
    }
    ConDemo()
    {
        System.out.println("General Constructor...");

    }
    public static void main(String[] args)
    {
        ConDemo obj= new ConDemo();
    }
}