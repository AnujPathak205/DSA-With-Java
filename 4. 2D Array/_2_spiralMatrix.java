public class _2_spiralMatrix {
    public static void printSpiral(int[][] matrix){
        int startRow = 0;
        int endRow = matrix.length-1;
        int startColumn = 0;
        int endColumn = matrix[0].length-1;

        while(startColumn <= endColumn && startRow <= endRow){
                    //top
            for(int i = startColumn;i <= endColumn;i++){
                System.out.print(matrix[startRow][i]+" ");
            }
                    //Right
            for(int i = startRow+1;i <= endRow;i++){
                System.out.print(matrix[i][endColumn]+" ");               
            }
                    //bottom
            for(int i = endColumn-1;i >= startColumn;i--){
                if(startRow != endRow)System.out.print(matrix[endRow][i]+" ");
            }
                    //left
            for(int i = endRow-1;i >= startRow+1;i--){
                if(startColumn != endColumn)System.out.print(matrix[i][startColumn]+" ");
            }

            startRow++;
            startColumn++;
            endRow--;
            endColumn--;
        }
        System.out.println();
        
    }

    public static void main(String[] args) {
        int[][] matrix = {
                            {1,2,3,4},
                            {12,13,14,5},
                            {11,16,15,6},
                            {10,9,8,7}
        };

        int[][] matrix2 ={
                            {1,2,3,4,5},
                            {12,13,14,15,6},
                            {11,10,9,8,7}
        };

        int[][] matrix3 ={
                            {1,2,3},
                            {12,13,4},
                            {11,14,5},
                            {10,15,6},
                            {9,8,7}
        };

        printSpiral(matrix);
        printSpiral(matrix2);
        printSpiral(matrix3);
    }
}
