package com.hexaware.mlp173;
 /**  * P:rogram to check possitive or negative.  * @author Nevash.  */ 
 public class Menu {     
     public void show(int choice) 
     {        
          switch (choice)
          {             
              case 1 :             
                System.out.println("Hi i am Nevash");                            
                case 2 : System.out.println("Hi i am Kesav");                         
                case 3 : System.out.println("Hi i am Sanjeev");                           
                case 4 : System.out.println("Hi i am Guru");             
                default :System.out.println("Invalid Choice");    
            
            }  
           }    
            public static void main(String[] args) 
            {         
                int choice=1;         
                Menu obj = new Menu();         
                obj.show(choice);       
            }          
        }