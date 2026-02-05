
//  (indices) of a given element (Key) and print them. Use a recursive function to solve this
//  problem.
//  Sample Input : arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key = 2
//  Sample Output : 1 5 7 8

public class _14_allOccuranceInArray {
    public static void allOccurnceInArray(int arr[],int key,int idx){
        if(idx == arr.length){
            return;
        }
        if(arr[idx] == key){
            System.out.print(idx+" ");
        }
        allOccurnceInArray(arr, key, idx+1);
    }

    
    public static void main(String[] args) {
        int[] array = {1,3,2,9,3,5,4,9,0,9,11,22,43,9};
        allOccurnceInArray(array, 9, 0);
        
    }
}
