public class _12_FastExponentiation{
    public static int normalExponentiation(int a,int b){//O(n)
        int result = 1;
        for(int i = 1;i <= b;i++){
            result *= a;
        }
        return result;
    }

    public static int fastExponentiation(int a,int b){//O(log n)
        int ans = 1;
        while(b > 0){
            if((b & 1) == 1){
                ans *= a;
            }
            a *= a;
            b >>= 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(normalExponentiation(5, 3));
        System.out.println(normalExponentiation(2, 6));
        System.out.println(normalExponentiation(10, 0));

        System.out.println();

        System.out.println(fastExponentiation(5, 3));
        System.out.println(fastExponentiation(2, 6));
        System.out.println(fastExponentiation(10, 0));
    }
}