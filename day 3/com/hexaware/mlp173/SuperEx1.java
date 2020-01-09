package com.hexaware.mlp173;
 

class Agent
{
    public void show()
    {
        System.out.println("Show From Agent Class...");
        }
}
class Nevash extends Agent
{
    public void show()
    {
        super.show();
        System.out.println("Show From Nevash Class");
    }
}
public class SuperEx1
{
    public static void main(String[] args)
    {
        new Nevash().show();
    }
    
}