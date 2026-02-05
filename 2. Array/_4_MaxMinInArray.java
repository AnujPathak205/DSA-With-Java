public class _4_MaxMinInArray {
    public static int MaxMin(int[] arr,char choice){
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;

        for(int i = 0;i < arr.length; i++){
            if(choice == 'M'){
                if(arr[i] > Max)Max = arr[i];
            }else{
                if(arr[i] < Min)Min = arr[i];
            }
        }
        if(choice == 'M')return Max;
        else return Min;
    }

    public static int Max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length; i++){
            if(arr[i] > max)max = arr[i];
        }
        return max;
    }

    public static int Min(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i <arr.length; i++){
            if(arr[i] < min)min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] Array = {1,3,2,4,6,5,8,7,55,44,33,6,55,7,6,5,444,43,3};

        System.out.println("Max in array:"+MaxMin(Array,'M'));
        System.out.println("Min in array:"+MaxMin(Array, 'm'));

        System.out.println("max:"+Max(Array));
        System.out.println("min:"+Min(Array));
    }
}
