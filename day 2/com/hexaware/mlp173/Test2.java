package com.hexaware.mlp173;
/**
 * *Program to Boxing And Unboxing.
 * @author Rahul
 */
public class Test2
{
    public void check(Object ob)
    {
        if(ob=="XYZ")
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
    String a="XYZ";
    Test2 obj=new Test2();
    obj.check(a);
}
}