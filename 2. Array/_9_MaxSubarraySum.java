

public class _9_MaxSubarraySum {
    
    public static int MaxSubArraySum(int arr[]){
        int Max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
            for(int j = i;j < arr.length;j++){
                int start = i,end = j;
                int sum = 0;
                for(int k = start;k <= end;k++){
                    sum += arr[k];
                }
                if(sum > Max)Max = sum;
            }
        }
        return Max;
    }

    public static int MaxSubArraySum2(int[] arr){//B
        int Max = Integer.MIN_VALUE;
        int prefixArray[] = new int[arr.length];
        prefixArray[0] = arr[0]; 
        
        //Calculating prefix array.
        for(int i = 1;i < arr.length;i++){
            prefixArray[i] = prefixArray[i-1] + arr[i];
        }

        for(int i = 0;i < prefixArray.length;i++){
            int start = i;
            for(int j = start;j < prefixArray.length;j++){
                int end = j;
                int sum = start==0 ? prefixArray[end]: prefixArray[end]-prefixArray[start-1];
                Max = Math.max(sum,Max);//if(sum > Max)Max = sum;
            }
        }        
        return Max;
    }

    public static int MaxSubArraySum3_Kadans(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0;i < arr.length;i++){
            currSum += arr[i];
            if(currSum < 0)currSum = 0;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public int maxSubArraySum3_Kadans_BEST(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int Array[] = {1,2,-2,7,-9,10};
        System.out.println(MaxSubArraySum(Array));
        System.out.println(MaxSubArraySum2(Array));
        System.out.println(MaxSubArraySum3_Kadans(Array));
    }


}
