
public class _13_binaryStringProblem {
    static int count = 0;
    
    public static void printBinary(int n,String str){
        if(n == 0){
            System.out.println((count++)+"  "+str);
            return;
        }

        printBinary(n-1, str+'0');
        printBinary(n-1, str+'1');

    }

    public static void printBinaryWithoutCon1(int n,int lastPlace,String str){

        if(n == 0){
            System.out.println(str);
            return;
        }
    
       printBinaryWithoutCon1(n-1, 0, str+'0');
       if(lastPlace == 0){
        printBinaryWithoutCon1(n-1, 1, str+'1');
       }
        
    }
    
    public static void main(String[] args){
        printBinary(3,  "");
    }
}
 