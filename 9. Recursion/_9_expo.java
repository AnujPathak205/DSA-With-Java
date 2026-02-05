public class _9_expo {
    public static long exp(int base,int exponent){//O(n)
        if(exponent == 0)return 1;
        return base*exp(base,exponent-1);
    }

    public static long exp2(int base,int exponent){//O()
        if(exponent == 0)return 1;

        long half = exp2(base, exponent/2);

        if(exponent%2 == 0){
            return half*half;
        }else{
            return base*half*half;
        }
    }

    
    public static void main(String[] args) {
        System.out.println(exp(5, 4));
        System.out.println(exp2(5, 4));

    }


}
