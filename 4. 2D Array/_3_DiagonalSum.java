public class _3_DiagonalSum {
    public static int DiagonalSum(int[][] matrix){
        if(matrix.length != matrix[0].length)return -1;
        int n = matrix.length;

        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += matrix[i][i];
            if(i != n-i-1) sum += matrix[i][n-i-1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0,1,2},
            {3,4,5},
            {6,7,8}
        };

        int[][] matrix2 = {
                          {1,1,1,1},
                          {2,1,3,2}
        };

        System.out.println(DiagonalSum(matrix));
        System.out.println(DiagonalSum(matrix2));
    }
}
