public class _11_countSetBits {
    public static int NoOfsetBitsOf(int n){
        int count = 0;
        int i = 0;
        while(n > 0){
            if((n & 1) == 1){
                count++;
            }
            i++;
            n >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(NoOfsetBitsOf(13));
        System.out.println(NoOfsetBitsOf(15));
        System.out.println(NoOfsetBitsOf(32));
    }

}
