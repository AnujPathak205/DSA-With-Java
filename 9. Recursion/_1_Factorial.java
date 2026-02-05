public class _1_Factorial {
    public static int FactorialByIteration(int  n){
        int ans = 1;
        for(int i = 2;i <= n;i++){
            ans *= i;
        }
        return ans;
    }

    public static int FactorialByRecursion(int n){
        if(n == 1 || n == 0){//Base case.
            return 1;
        }else{
            return n*FactorialByRecursion(n-1);//Recursive case.
        }
    }

    public static void main(String[] args) {
        System.out.println(FactorialByIteration(5));
        System.out.println(FactorialByRecursion(5));

        System.out.println(FactorialByIteration(8));
        System.out.println(FactorialByRecursion(8));
    }
}
