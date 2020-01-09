package com.hexaware.mlp173;
import java.util.Objects;
/**
* Program to Abstract class Demo.
* @author Prasanna.
*/
abstract class Employ {
    int empno;
    String name;
    double basic;
    /**
 * @param argEmpno to initialize employ No.
 * @param argName to initialize employ name.
 * @param argBasic to initialize employ basic.
 * used to get details through constructor.
 */
  public Employ(int argEmpno, String argName,
        double argBasic) {
    this.empno = argEmpno;
    this.name = argName;
    this.basic = argBasic;
  }
   @Override
  public String toString() {
      return "Empno " +empno+ " Name " +name+ 
               " Salary " +basic;
  }
   @Override
    public int hashCode() {
    return Objects.hash(empno, name, basic);
  }
}
class Sougata extends Employ {
    Sougata(int empno, String name, double basic) {
        super(empno, name, basic);
    }
}

class Chandana extends Employ {
    Chandana(int empno, String name, double basic) {
        super(empno, name, basic);
    }
}
public class AbsCon {
    public static void main(String[] args) {
        Employ[] arr = new Employ[] {
            new Sougata(1, "Sougata", 85244),
            new Chandana(3, "Chandana",81144)
        };
        for(Employ e : arr) {
            System.out.println(e);
        }
    }
}