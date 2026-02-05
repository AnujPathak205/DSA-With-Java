public class _7_OptimizedBubbleSort {
    public static void modifiedBubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            boolean isSorted = true;
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted == true)break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        modifiedBubbleSort(arr);

        for(int element:arr){
            System.out.print(element + " ");
        }
    }
}
