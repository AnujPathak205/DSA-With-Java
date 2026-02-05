import java.util.Scanner;  

public class _1_InputOutput{

    public static boolean is_in_2D_Arrays(int matrix[][],int key){
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){
                if(matrix[i][j] == key){
                    System.out.println(key + " found at cell ("+(i+1)+","+(j+1)+")");
                    return true;
                }
            }
        }

        System.out.println(key + " NOT FOUND.");
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int rows = matrix.length;
        int colums = matrix[0].length;

        Scanner sc = new Scanner(System.in);

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < colums;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < colums;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int target;
        System.out.print("Enter a element to chk in array:");
        target = sc.nextInt();
        
        is_in_2D_Arrays(matrix, target);

    }
}