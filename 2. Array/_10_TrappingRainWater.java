//Trapped Water Problem.(Problem 2.1)
public class _10_TrappingRainWater{

    public static int TrappedRainWater(int[] arr){
        if(arr == null||arr.length == 0)return 0;

        int n = arr.length;
        int LeftMax[] = new int[n];
        int RightMax[] = new int[n];

        LeftMax[0] = arr[0];
        for(int i = 1;i < n;i++){
            LeftMax[i] = Math.max(arr[i], LeftMax[i-1]);
        }

        RightMax[n-1] = arr[n-1];
        for(int i = n-2;i >=0;i--){
            RightMax[i] = Math.max(arr[i], RightMax[i+1]);
        }

        int TrappedWater = 0;
        for(int i = 1;i < n-1;i++){
            int WaterLevel = Math.min(LeftMax[i], RightMax[i]);
            TrappedWater += Math.max(0,(WaterLevel-arr[i]));
        }
        
        return TrappedWater;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,0,6,3,2,5};
        System.out.println(TrappedRainWater(arr));
    }
}