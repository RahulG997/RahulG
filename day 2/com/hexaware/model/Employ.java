package com.hexaware.model;
/**
 * *Program to Boxing And Unboxing.
 * @author Rahul
 */
public class Employ
{
    public int empno;
    public String name;
    public double basic;
    public String gender;

@Override
    public String toString()
    {
        return String.format("%10s %10s %10s %10s", empno,name,basic,gender);
    }
}