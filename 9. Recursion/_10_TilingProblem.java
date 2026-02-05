public class _10_TilingProblem {
    public static int TilingProblem(int n){//board size:2*n
        //base case                        //tile size :2*1
        if(n == 0 || n == 1){
            return 1;
        }

        //Vertical
        int firstTileVertical = TilingProblem(n-1);

        //horizontal
        int firstTileHorizontal = TilingProblem(n-2);

        return firstTileVertical+firstTileHorizontal;

    }

    public static void main(String[] args) {
        System.out.println(TilingProblem(3));
    }
}
