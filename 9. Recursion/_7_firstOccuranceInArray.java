

public class _7_firstOccuranceInArray {
    public static int firstOccuranceInArray(int arr[],int target,int i){    
         if(i == arr.length)return -1;

         if(arr[i] == target)return i;

         return firstOccuranceInArray(arr, target, i+1);
    }



   

    public static void main(String[] args) {
        int[] arr = {1,44,5,6,55,43,23,3,3,3,3,3};
        int[] arr2= {1,2,3,5,4,33,2,5,7,6,9};
        System.out.println(firstOccuranceInArray(arr, 3, 0));
        System.out.println(firstOccuranceInArray(arr2, 9, 0));



    }
}
