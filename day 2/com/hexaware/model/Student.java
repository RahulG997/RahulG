package com.hexaware.model;

/**
 * *Program to Student model class.
 * @author Rahul
 */
public class Student
{
    public int sno;
    public String sname;
    public double cgp;
    public String city;

    
@Override
public String toString()
    {
    return String.format("%10s %10s %10s %10s", sno,sname,cgp,city);
    }


}