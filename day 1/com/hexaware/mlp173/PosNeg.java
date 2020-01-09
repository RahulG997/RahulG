package com.hexaware.mlp173;

public class PosNeg
{
    public void check(int n)
    {
    if (n>=0)
        System.out.println("Positive");
    else
    System.out.println("Negetive");
    }
public static void main(String[] args)
    {
    int n =Integer.parseInt(args[0]);
    PosNeg obj=new PosNeg();
    obj.check(n);
    }
}