package com.hexaware.mlp173;
/**
 * *Program to Boxing And Unboxing.
 * @author Rahul
 */
public class Test1
{
    public void check(Object ob)
    {
        if (ob==12)
        {
        System.out.println("Hiiiiiiiiiiii");

         }
    else
    {
        System.out.println("Byeeeeee");
    }
}

public static void main(String[]args)
{
    int a=12;
    Test1 obj=new Test1();
    obj.check(a);
}
}