public class _6_Sudoku_problem{
    public static void printSudoku(int[][] sudoku){
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(j == 2 || j == 5){
                    System.out.print(sudoku[i][j]+"|");
                }else{
                    System.out.print(sudoku[i][j]+" ");
                }
            }

            System.out.println();
            if(i == 2 || i == 5){
                System.out.println("-----------------");
            }
        }
    }

    public static boolean isSafe(int[][] sudoku,int x,int y,int element){
        //chk in row and column
        for(int i = 0;i < 9;i++){
            if(sudoku[x][i] == element || sudoku[i][y] == element){
                return false;
            }
        }

        //chk in grid
        int sr = (x/3)*3;
        int sc = (y/3)*3;

        for(int i = sr;i < sr+3;i++){
            for(int j = sc;j < sc+3;j++){
                if(sudoku[i][j] == element){
                    return false;
                }
            }
        }


        
        return true;
        
    }


    //Wrong
    public static void SolvingSudokuProblem(int[][] sudoku){
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(sudoku[i][j] == 0){
                    for(int k = 1;k <= 9;k++){
                        if(isSafe(sudoku, i, j, k)){
                            sudoku[i][j] = k;
                            break;
                        }
                    }
                
                }

            }
        }
    }

    //Right
    public static boolean SolvingSudokuProblem2(int[][] sudoku,int row,int col){
        
        if(row == 9){
            return true;
        }

        int nextRow = row,nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0){
            return SolvingSudokuProblem2(sudoku,nextRow,nextCol);
        }

        for(int digit = 1;digit <= 9;digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(SolvingSudokuProblem2(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
        
    }

    public static void main(String[] args) {
        int[][] sudoku = {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
        };

        if(SolvingSudokuProblem2(sudoku,0,0)){
            printSudoku(sudoku);
        }else{
            System.out.println("not solved");
        }

    }
}