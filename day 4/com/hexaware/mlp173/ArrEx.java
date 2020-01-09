package com.hexaware.mlp173;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * program to ArrayExeception
 * @author Rahul
 */

public class ArrEx
{
    public static void main(String[] args)
    {
        int[] a={12,5}; 
     //   a[10]=67;  // ArrayIndexOutOfBoundException
    
        try
        {
            a[10]=67;
        }
       
    
    catch(ArrayIndexOutOfBoundsException e)
    {
        System.out.println("Array size small...:");
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}}