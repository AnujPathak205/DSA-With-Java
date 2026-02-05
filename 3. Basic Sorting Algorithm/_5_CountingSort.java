public class _5_CountingSort {
    public static void CountingSort(int[] arr){

        int largest = Integer.MIN_VALUE;
        for(int element:arr){
            largest = Math.max(largest, element);
        }

        int[] countArray = new int[largest+1]; 

        for(int i = 0;i < arr.length;i++){
            countArray[arr[i]]++;
        }
        int index = 0;
        for(int i = 0;i < countArray.length;i++){
            while(countArray[i] != 0){
                arr[index] = i;
                countArray[i]--;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,5,5,5,5};

        CountingSort(arr);

        for(int element:arr){
            System.out.print(element+" ");
        }
    }
}
