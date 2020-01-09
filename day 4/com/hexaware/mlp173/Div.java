
package com.hexaware.mlp173;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Div
{
    public static void main(String[] args)
{
    int a,b,c;
    System.out.println("Enter 2 no");
    Scanner sc = new Scanner(System.in);
    try
    {
        a=sc.nextInt();
        b=sc.nextInt();
        c=a/b;
        System.out.println("DIvision "+c);
    }
    catch(InputMismatchException e)
    {
        System.out.println("Wrong input");
    }
    catch(ArithmeticException e)
    {
        System.out.println("Division by 0 not p");
    }
    catch(Exception e)
    {
    e.printStackTrace();
    }
    
    finally{
        System.out.println("End");
    }
}}
