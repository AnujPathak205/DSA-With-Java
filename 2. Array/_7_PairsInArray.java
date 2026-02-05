public class _7_PairsInArray {
    public static void printPairsOfArray(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1;j < arr.length;j++){
                System.out.print("(" + arr[i] + "," + arr[j]+")  ");
            }
            System.out.println();
        }
    }

    public static void printAllPairs(int[] arr){
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr.length;j++){
                System.out.print("(" + arr[i] + "," + arr[j]+")  ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] =  {1,2,3,4};

        printPairsOfArray(arr);
        System.out.println();

        printAllPairs(arr);
    }
}
