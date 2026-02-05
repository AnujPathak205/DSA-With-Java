
import java.util.Scanner;

public class _1_StringBuilder {
    
    public static void main(String[] args) {

       Scanner s = new Scanner(System.in);
       StringBuilder SB = new StringBuilder();
       System.out.println(SB);

       StringBuilder sbb = new StringBuilder();
       sbb.append("AnujKumarPathak");
       sbb.insert(4, ",");
       System.out.println(sbb);

       sbb.insert(10, ",");
       System.out.println(sbb);

       sbb.delete(4,10);
       System.out.println(sbb);

       StringBuilder ssbb = new StringBuilder();
       ssbb.append("Anuj Kumar Pathak");
       //ssbb.delete(5,11);
       ssbb.replace(5,10,"Bhai");
       System.out.println(ssbb);

       ssbb.reverse();
       System.out.println(ssbb);

    }
}
