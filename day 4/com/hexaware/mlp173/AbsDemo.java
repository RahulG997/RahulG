package com.hexaware.mlp173;

/**
 * Program to Abstract class Demo
 * @author Rahul
 */

 abstract class Training
    {
     abstract void name();
     abstract void email();
    }
    class Keerthi extends Training
    {
        @Override
        public void name()
        {
            System.out.println("Name is Keerthi...");
        }
        public void email()
        {
            System.out.println("Email krtt@gmail.com");
        }
    }
    class Rahul extends Training
    {
        @Override
        public void name()
        {
            System.out.println("Name is Rahul...");
        }
        @Override
        public void email()
        {
            System.out.println("Email RahulG@gmail.com");
        }
    }

 public class AbsDemo 
    {
        public static void main(String[] args)
        {
            Training[] arr=new Training[]
            {
                new Rahul(),new Keerthi()
            };
            for(Training t : arr)
            {
                t.name();
                t.email();
            }
        }
    }
