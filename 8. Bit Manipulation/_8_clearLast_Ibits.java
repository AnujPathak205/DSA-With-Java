public class _8_clearLast_Ibits {
    public static int clearLastIbits(int n,int i){
        int bitmask = (~0)<<i;
        return n & bitmask;
    }

    public static void main(String[] args) {
        System.out.println(clearLastIbits(13, 2));
    }
}
