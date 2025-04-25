package syntax;



public class Syntax {
   public static void main(String[] args) {
        System.out.println("hi");

        Plant p1=new Plant("red", 11);
       Plant p2=new Plant("red", 11);
       System.out.println(p1);
       System.out.println(p1.equals(p2));//true
       System.out.println(p1==p2); //f
       System.out.println(p1.color()==p2.color());
    }


}
record Plant(String color, Integer height){}