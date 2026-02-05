public class _1_MergeSort {
    public static void MergeSort(int[] arr,int si,int ei){
        if(si >= ei)return;

        int mid = si + (ei - si)/2;

        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr,int si,int mid,int ei){
        int[] temp = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei){
            temp[k++] = (arr[i]<arr[j])? arr[i++]:arr[j++];
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= ei){
            temp[k++] = arr[j++];
        }

        for(i = si,j = 0;j < temp.length;i++,j++){
            arr[i] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] array = {1,4,7,2,3,5};
        
        MergeSort(array, 0, array.length-1);
        for(int e:array){
            System.out.println(e);
        }
       

    }
}
