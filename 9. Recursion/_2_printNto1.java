
public class _2_printNto1 {
    public static void printNto1(int n){
        if(n == 1){
            System.out.print(1+"\n");
        }else{
            System.out.print(n+" ");
            printNto1(n-1);
        }
    }

    public static void printDec(int n){
        if(n == 1){
            System.out.print(n+"\n");
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void printInc(int n){
        
    }


    public static int exp(int base,int exponent){
        if(exponent == 0){
            return 1;
        }else{
            return base*exp(base,exponent-1);
        }
    }

    public static void main(String[] args) {
        printNto1(10);
        printDec(10);
        //System.out.println(exp(2, 6));
    }
}
