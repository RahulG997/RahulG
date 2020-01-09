package com.hexaware.mlp173;
public class Circle
{
    
        public void calc(double radius)
        {
            double area,circ;
            area=Math.PI*radius*radius;
            circ=2*Math.PI*radius;
            System.out.println("Area of circle " +area);
            System.out.println("Circumference of circle " +circ);
          }

   public static void main(String[]args)
   {
       double radius=Double.parseDouble(args[0]);
       Circle obj=new Circle();
       obj.calc(radius);
   }
}
