package com.hexaware.mlp173;


 /**
* Program to Checked Exeception.
* @author Rahul.
*/
public class DbConnection
{
    public void check() throws ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
    }
   
 public static void main(String[] args) {

    
    }

}