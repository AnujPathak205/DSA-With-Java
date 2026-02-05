public class _4_SearchInSortedMatrix{

    public static boolean LinearSearch(int[][] matrix,int key){
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == key)return true;
            }
        }
        return false;
    }

    public static boolean StairCaseSearch(int[][] matrix,int key){
        int row = 0;
        int column = matrix[0].length-1;
        while(row < matrix.length && column >= 0 ){
            if(matrix[row][column] == key)return true;
            if(key > matrix[row][column])row++;
            else column--;
        }
        return false;
    } 

    public static void main(String[] args) {
        int[][] matrix = {
                            {1,2,3,6},
                            {2,3,4,99},
                            {7,8,9,111}
        };
        System.out.println(StairCaseSearch(matrix, 9));
        System.out.println(StairCaseSearch(matrix, 1));
        System.out.println(StairCaseSearch(matrix, 7));
        System.out.println(StairCaseSearch(matrix, 0));
        System.out.println(StairCaseSearch(matrix, 111));
    }
}