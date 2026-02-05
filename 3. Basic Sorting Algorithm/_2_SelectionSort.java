public class _2_SelectionSort {
    public static void SelectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i < n-1;i++){
            int minIndex = i;
            for(int j = i;j < n;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //swaping 
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,2,4,6,0,9,7,8,10,11};
        
        SelectionSort(numbers);
        for(int element:numbers){
            System.out.print(element+" ");
        }
    }
}
