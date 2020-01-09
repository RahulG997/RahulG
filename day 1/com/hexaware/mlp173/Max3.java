package com.hexaware.mlp173;

public class Max3
{
    public void check(int num1,int num2,int num3)
    {
    if (num1 >= num2 && num1 >= num3)
    System.out.println( num1 + " is the maximum number.");
 else if (num2 >= num1 && num2 >= num3)
    System.out.println( num2 + " is the maximum number.");
 else
    System.out.println( num3 + " is the maximum number.");
    }
    
    public static void main(String[] args)
    {
    int num1 =Integer.parseInt(args[0]);
    int num2 =Integer.parseInt(args[1]);
    int num3 =Integer.parseInt(args[2]);
    Max3 obj=new Max3();
    obj.check(num1,num2,num3);
    }
}

