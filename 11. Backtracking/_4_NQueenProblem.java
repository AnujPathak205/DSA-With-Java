
public class _4_NQueenProblem {

    public static int count = 0;

    public static void printBoard(char[][] board){
        for(char row[]:board){
            for(char element:row){
                System.out.print    (element+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //my solution -> wrong
    public static void NQueenProblem(char[][] board){
        int n = board.length;
        for(int i  = 0;i < n;i++){
            for(int j = 0; j < n;j++){
                board[i][j] = '#';
            }
        }

        for(int y = 0;y < n;y++){
            for(int x = 0;x < n;x++){
                // if(x == 0 && y == 0){
                //     continue;
                // }
                if(board[x][y] != '-'){
                                    printBoard(board);

                    board[x][y] = 'Q';
                    //right
                    for(int i = y+1;i < n;i++){
                        board[x][i] = '-';
                    }
                    //up
                    for(int i = x+1;i < n;i++){
                        board[i][y] = '-';
                    }
                    //down
                    for(int i = x-1;i >= 0;i--){
                        board[i][y] = '-';
                    }
                    int i = x+1,j = y+1;
                    while(i < n && j < n){
                        board[i][j] = '-';
                        i++;
                        j++;
                    }
                    int k = x-1;
                    int l = y+1;
                    while(k >= 0 && l < n){
                        board[k][l] = '-';
                        k--;
                        l++;
                    }


                    break;
                    
                }
            }
        }

    }

    //my solution -> correct
    public static void NQueenProblem2(char[][] board,int c) {
        int n = board.length;

        if(c == n){
            count++;
            System.out.println("________"+count+"________\n");
            printBoard(board);
            return;
        }


        char[][] newBoard = new char[n][n];

        

        for(int i = 0;i < n;i++){
            if(board[i][c] != '-'){

            for(int p = 0;p < n;p++){
            System.arraycopy(board[p], 0, newBoard[p], 0, n);
            }

                board[i][c] = 'Q';

                //vertical down
                for(int j = i+1;j < n;j++){
                    board[j][c] = '-';
                }

                //vertical up
                for(int j = i-1;j >= 0;j--){
                    board[j][c] = '-';
                }

                //horizontal right
                for(int j = c+1;j < n;j++){
                    board[i][j] = '-';
                }

                //diagonal right down
                int k = i+1;
                int l = c+1;
                while(k < n && l < n){
                    board[k][l] = '-';
                    k++;
                    l++;
                }

                //diagonal right up
                k = i-1;
                l = c+1;
                while(k >= 0 && l < n){
                    board[k][l] = '-';
                    k--;
                    l++;
                }

                NQueenProblem2(board, c+1);


                for(int p = 0;p < n;p++){
                    System.arraycopy(newBoard[p], 0,board[p] , 0, n);
                }


            }
        }

        
         
        
    }

    //apna college solution

    public static void NQueenProblem3(char[][] board,int row){
        int n = board.length;

        if(row == n){
            System.out.println("______"+(++count)+"_______\n");
            printBoard(board);
            return;
        }

        for(int i = 0;i < n;i++){
            if(isSafe(board,row,i)){
                board[row][i] = 'Q';
                NQueenProblem3(board, row+1);
                board[row][i] = '.';
            }
        }
    }


    public static boolean isSafe(char[][] board,int row,int col){
        int n = board.length;

        //vertical up chk
        for(int i = row-1;i >= 0;i--){
            if(board[i][col] == 'Q')return false;
        }

        //diagonal left up
        for(int i = row-1,j = col-1; i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q')return false;
        }

        //diagonal right up
        for(int i = row-1,j = col+1; i>=0 && j<n;i--,j++){
            if(board[i][j] == 'Q')return false;
        }

        return true;
    }

    static int totalNQueensSol;

    public static void countNQueensSolutions(char[][] board,int row){
        int n = board.length;

        if(row == n){
            totalNQueensSol++;
        }

        for(int i = 0;i < n;i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                countNQueensSolutions(board, row+1);
                board[row][i] = '.';
            }
        }
    }

    public static int totalNQueensSolutions(char[][] board){
        totalNQueensSol = 0;
        countNQueensSolutions(board, 0);
        return totalNQueensSol;
    }

    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
       
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                board[i][j] = '.';
            }
        }

        NQueenProblem3(board, 0);
        // System.out.println(totalNQueensSolutions(board));


    }
}
