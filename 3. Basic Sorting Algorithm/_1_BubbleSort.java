public class _1_BubbleSort {
    public static void BubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i < n-1;i++){
            for(int j = 0;j < n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void BubbleSort2(int[] arr){
        int n = arr.length;
        for(int i = n-2;i >= 0;i--){
            for(int j = 0;j <= i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] Array = {10,2,3,5,6,8,9,4,7,1};

        System.out.print("Array elements before bubble sort:");
        printArray(Array);

        BubbleSort2(Array);
        System.out.print("Array elements After bubble sort:");
        printArray(Array);
    }
}
