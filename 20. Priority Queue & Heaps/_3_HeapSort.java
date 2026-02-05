
import java.util.Arrays;

public class _3_HeapSort {
    public static void heafify(int arr[],int i,int size){
        int left = 2*i+1;
        int right= 2*i+2;

        int maxIdx = i;

        if(left < size && arr[maxIdx] < arr[left]){
            maxIdx = left;
        }

        if(right < size && arr[maxIdx] < arr[right]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heafify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]){
        //step 1: build max heap
        int n = arr.length;
        for(int i = n/2 - 1;i >= 0;i--){
            heafify(arr,i,n);
        }

        //step 2: push largest at end
        for(int i = n-1;i > 0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heafify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,4,5,6,7,8,12,11,13,22,19,18};

        Arrays.stream(arr).mapToObj(n -> n+" ").forEach(System.out::print);System.out.println();

        heapSort(arr);

        Arrays.stream(arr).mapToObj(n -> n+" ").forEach(System.out::print);System.out.println();

    }
}
