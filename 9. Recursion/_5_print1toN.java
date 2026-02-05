public class _5_print1toN {
    public static void printInc(int n){
        if(n == 1){
            System.out.print(1+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int fibonacciNo(int n){
        if(n <= 1){
            return n;
        }else{
            return fibonacciNo(n-1)+fibonacciNo(n-2);
        }
    }

    public static void fibonacciSequence(int n){
        int t1 = 0;
        int t2 = 1;
        System.out.print(0+" "+1+" ");
        for(int i = 0;i < n;i++){
            int nextTerm = t1+t2;
            System.out.print(nextTerm+" ");
            t1 = t2;
            t2 = nextTerm;

        }
    }


    public static void main(String[] args) {
        // printInc(10);
        // System.out.println();

        // for(int i = 0;i <= 10;i++){
        //     System.out.println(i+"  "+fibonacciNo(i));
        // }

        fibonacciSequence(10);
    }
}
