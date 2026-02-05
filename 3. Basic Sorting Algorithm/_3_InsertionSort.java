public class _3_InsertionSort {
    
    public static void InsertionSort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int currentValue = arr[i];
            int previousIndex = i-1;
            while (previousIndex >= 0 && currentValue < arr[previousIndex]) {
                arr[previousIndex + 1] = arr[previousIndex];  // Shift the larger element right
                previousIndex--;
            }
            arr[previousIndex+1] = currentValue;
        }
    }

    public static void InsertionSort2(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int currentValue = arr[i];
            int previousIndex = i-1;
            while(previousIndex >= 0 && currentValue < arr[previousIndex]){
                arr[previousIndex+1] = arr[previousIndex];
                previousIndex--;
            }
            arr[previousIndex+1] = currentValue;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2,6,7,8,2,1,1,2,3,4,5,6,5,4,4,3};

        InsertionSort2(arr);
        for(int element:arr){
            System.out.print(element+" ");
        }

    }
}
