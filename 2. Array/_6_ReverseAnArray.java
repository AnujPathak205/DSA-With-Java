public class _6_ReverseAnArray {
    public static void reverseArray(int[] arr){
        int first = 0,last = arr.length-1;
        while(first < last){
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
    }

    public static void reverseArray2(int arr[]){
        for(int i = 0;i < arr.length/2;i++){
             int temp = arr[i];
             arr[i] = arr[arr.length-1-i];
             arr[arr.length-1-i] = temp;
        }
    }

    public static void printArray(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("\nArray elements before reversing:");
        printArray(array);

        reverseArray2(array);

        System.out.println("\nArray elements after reversing:");
        printArray(array);

    }

}
