public class _8_lastOccuranceInArray {
    public static int lastOccurance(int[] arr,int target,int i){
       if(i == arr.length)return -1;
 
       int l = lastOccurance(arr, target, i+1);
       
       if(l != -1)return l;
       
       if(arr[i] == target)return i;
       
        return -1;
    }

    public static int exp(int base,int exponent){
        if(exponent == 0){
            return 1;
        }else{
            return base*exp(base,exponent-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,9,9,4,6,7,2,9};
        System.out.println(lastOccurance(arr, 9, 0));
        System.out.println(exp(5,4));
    }
}
