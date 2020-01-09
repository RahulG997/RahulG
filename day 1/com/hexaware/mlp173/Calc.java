package com.hexaware.mlp173;
public class Calc
{
    public void  add(int a,int b)
    {
        int c=a-b;
        System.out.println("Sum is "+c);
    }
    public static void main(String[]args)
    {
        int a,b;
        a=Integer.parseInt(args[0]);
        b=Integer.parseInt(args[1]);
        Calc obj=new Calc();
        obj.add(a,b);
    }
}