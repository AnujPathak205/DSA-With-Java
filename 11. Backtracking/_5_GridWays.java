public class _5_GridWays {
    public static void printBoard(char[][] board){
        for(char[] rows: board){
            for(char element: rows){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    public static int count = 0;

    public static void printAllGridWays(char[][] board,int row,int col){
        int m = board.length;
        int n = board[0].length;

        board[row][col] = '#';

        if(row == m-1 && col == n-1){
            System.out.println("_______"+(++count)+"_______");
            printBoard(board);
            board[row][col] = '.';
            return;
        }

        

        //Right Move
        if((col+1) < n ){
            printAllGridWays(board, row, col+1);
        }

        //Down Move
        if((row+1) < m ){
            printAllGridWays(board, row+1, col);
        }

        board[row][col] = '.';
    }

    //My Solution
    static int countOfGridWays = 0;
    public static void countingGridWays(int row,int col,int currRow,int currCol){
        if(currRow == row-1 && currCol == col-1){
            countOfGridWays++;
            return;
        }

        if((currCol+1) < col){
            countingGridWays(row, col, currRow, currCol+1);
        }

        if((currRow+1) < row){
            countingGridWays(row, col, currRow+1, currCol);
        }
    }

    public static int totalGridWays(int row,int col){
        countOfGridWays = 0;
        countingGridWays(row, col, 0, 0);
        return countOfGridWays;
    }

    //Apna college Solution:

    public static int totalGridWays2(int i,int j,int row,int col){
        if(i == row-1 && j == col-1){
            return 1;
        }else if(i == row || j == col){
            return 0;
        }else{
            int w1 = totalGridWays2(i+1, j, row, col);
            int w2 = totalGridWays2(i, j+1, row, col);
            return w1+w2;
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        char[][] board = new char[m][n];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                board[i][j] = '.';
            }
        }

        System.out.println(totalGridWays2(0,0,m,n));

    }
}
