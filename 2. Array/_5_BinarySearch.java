public class _5_BinarySearch {
    public static int BinarySearch(int[] arr,int target){
        int low = 0,high = arr.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target)return mid;
            if(arr[mid] > target)high = mid-1;
            if(arr[mid] < target)low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,3,4,6,8,12,33,45};
        int target = 0;
        int result = BinarySearch(array, target);

        if(result != -1){
            System.out.println("Element found at index:"+result);
        }else{
            System.out.println("NOT FOUND.");
        }

    }
}
