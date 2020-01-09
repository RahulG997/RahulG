package com.hexaware.model;
/**
 * *Program to Constructor.
 * @author Rahul
 */
public class Employee
{
    int empno;
    String name;
    double basic;
    /**
     * Default Constructor
     */
    public Employee()
    {

    }
    /**
     * @param argEmpno to initialize employ No.
     * @param argName to initialize employ No.
     * @param argBasic to initialize employ No.
     */
    public Employee (int argEmpno,String argName,double argBasic)
    {
        this.empno = argEmpno;
        this.name = argName;
        this.basic = argBasic;
 
    }

    @Override
    public String toString()
    {
        return "Empno " +empno+ " Name " +name+ " Basic " +basic;
    }
}