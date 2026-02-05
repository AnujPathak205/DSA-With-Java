import java.util.HashMap;

public class _13_LargestSubarrayWith0Sum {
    //Using brute force approack : O(n^2)
    public static int largestSubarrayWith0Sum(int arr[]){
        int max = 0;
        for(int i = 0;i < arr.length;i++){
            int sum = 0;
            for(int j = i;j < arr.length;j++){
                sum += arr[j];
                if(sum == 0){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        
        return max;
    }

    //Hash Map approach: O(n)
    public static int largestSubarrayWith0Sum2(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        //(sum,idx)
        
        int sum = 0;
        int max = 0;
        for(int i = 0;i < arr.length;i++){
            sum += arr[i];

            if(sum == 0) max = i+1;

            if(map.containsKey(sum)){
                max = Math.max(max,i - map.get(sum));
                System.out.println(i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }


        return max;
    }

    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10};
        int[] arr2= {2,-2};
        System.out.println("ans: "+largestSubarrayWith0Sum2(arr));
    }
}
