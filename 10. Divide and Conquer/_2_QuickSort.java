public class _2_QuickSort{
    public static void QuickSort(int[] arr,int si,int ei){
        //base case
        if(si >= ei){
            return;
        }
        
        //partiton
        int pivotIndex = ei;
        int i = si;
        for(int j = si;j < ei;j++){
            if(arr[j] <= arr[pivotIndex]){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        pivotIndex = i;

        QuickSort(arr, si, pivotIndex-1);//left
        QuickSort(arr, pivotIndex+1, ei);//right
    }

    public static void main(String[] args) {
        int[] arr = {4,2,7,1,9,8,0,11,24,1,91,13,12,11,16,1111,1};
        QuickSort(arr, 0, arr.length-1);

        for(int element:arr){
            System.out.print(element+" ");
        }
    }
}