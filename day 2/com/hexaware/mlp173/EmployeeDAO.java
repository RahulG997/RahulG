package com.hexaware.mlp173;
import com.hexaware.model.Employee;
/**
 * *Program to Constructor.
 * @author Rahul
 */
public class EmployeeDAO
{
    public static void main(String[] args)
    {
        Employee employee = new Employee(1,"Rahul",5566978);
        System.out.println(employee);
    }
}