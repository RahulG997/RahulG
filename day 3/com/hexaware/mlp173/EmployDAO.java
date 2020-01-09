package com.hexaware.mlp173;
import com.hexaware.model.Employ;
 
public class EmployDAO {
    public static void main(String[] args) {
        Employ e1 = new Employ(1, "Aman", 4564);
        Employ e2 = new Employ(3, "Raj", 8989);
        System.out.println(e1==e2);
        System.out.println(e1.equals(e2));
    }
}
