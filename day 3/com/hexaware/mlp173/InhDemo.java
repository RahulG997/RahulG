package com.hexaware.mlp173;
class First
{
    public void show()
    {
        System.out.println("Show method from first class");
    }
}
class Second extends First
{
    public void display()
    {
        System.out.println("Show method from class Second");

    }
}
public class InhDemo
{
    public static void main(String[] args)
    {
        Second obj = new Second();
        obj.show();
        obj.display();
    }
}