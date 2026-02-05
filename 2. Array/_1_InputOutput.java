
import java.util.Scanner;

public class _1_InputOutput{
    public static void main(String[] args) {
        int marks[] = new int[3];

        Scanner sc = new Scanner(System.in);

        // marks[0] = sc.nextInt();
        // marks[1] = sc.nextInt();
        // marks[2] = sc.nextInt();

        for(int i = 0;i < marks.length;i++){
            marks[i] = sc.nextInt();
        }

        System.out.println("Physics:"+marks[0]);
        System.out.println("Chemistry:"+marks[1]);
        System.out.println("Math:"+marks[2]);

       

        
    }
}