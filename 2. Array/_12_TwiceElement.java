public class _12_TwiceElement {
    public static boolean isAnyElementTwice(int[] arr){
        for(int i = 0;i < arr.length;i++){
            for(int j = i+1;j < arr.length;j++){
                if(arr[i] == arr[j])return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] Array = {1,2,3,4,5,6,7,8,9,5};
        System.out.println(isAnyElementTwice(Array));
    }
}
