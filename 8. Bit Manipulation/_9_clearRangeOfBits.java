public class _9_clearRangeOfBits {
    public static int clearRangeOfBits(int n,int i,int j){
        int a = (~0) << j+1;
        int b = (1 << i) - 1;
        return (a|b) & n;
    }

    public static void main(String[] args) {
        System.out.println(clearRangeOfBits(101, 2, 4));
    }
}
