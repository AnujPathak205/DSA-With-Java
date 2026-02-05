public class _8_printSubarray {
    public static void printSubarray(int arr[]){
        for(int i = 0;i < arr.length;i++){
            for(int j = i;j < arr.length;j++){
                int start = i,end = j;
                for(int k = start;k <= end;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int array[] = {1,2,3};
        printSubarray(array);
    }
}
