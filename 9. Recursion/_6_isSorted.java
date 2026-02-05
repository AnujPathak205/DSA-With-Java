



public class _6_isSorted {
    public static boolean isSortedUsingRecursion(int[] arr,int i){
        if(i == arr.length-1)return true;

        if(arr[i] > arr[i+1])return false;

        return isSortedUsingRecursion(arr, i+1);
    }

    public static boolean isSortedUsingIteration(int[] arr){
        for(int i = 0;i < arr.length-1;i++){
            if(arr[i] > arr[i+1])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] Array = {1,2,3,4,4,5,7,8};
        int[] Array2= {1,2,3,4,3,2,1};

        System.out.println(isSortedUsingIteration(Array));
        System.out.println(isSortedUsingIteration(Array2));

        System.out.println(isSortedUsingRecursion(Array, 0));
        System.out.println(isSortedUsingRecursion(Array2,0));
    }


}
