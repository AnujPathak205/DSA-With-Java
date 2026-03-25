// Question 1 : Given an array nums of size n, returnthe majority element. (MEDIUM)
//  Themajorityelement istheelementthatappearsmorethan⌊n/2⌋times.Youmayassume
//  that the majority element always exists in the array.
//  Sample Input 1: nums = [3,2,3]
//  Sample Output 1: 3
//  Sample Input 2: nums = [2,2,1,1,1,2,2]
//  Sample Output 2: 2\\

public class _4_MajorityElementInArray {
    public static int MajorityElement(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int element:arr){
            largest = Math.max(largest,element);
        }

        int[] countArray = new int[largest+1];

        for(int element:arr){
            countArray[element]++;
        }

        int MajorityCount = Integer.MIN_VALUE;
        int Majority_Element = 0;
        for(int i = 0;i < countArray.length;i++){
            if(countArray[i]>MajorityCount){
                MajorityCount = countArray[i];
                Majority_Element = i;
            }
        }
        return (arr.length/2 < MajorityCount)? Majority_Element:-1;
    }

    //- Brute Force Approach:O(n^2)
    public static int MajorityElement2(int arr[]){
        int n = arr.length;
        int majority_Count = n/2;

        for(int i = 0;i < n;i++){
            int count = 0;
            for(int j = 0;j < n;j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > majority_Count){
                return arr[i];
            }
        }
        return -1;

    }

    public static int countInRange(int[] arr,int num,int lo,int hi){
        int count = 0;
        for(int i = lo;i <= hi;i++){
            if(arr[i] == num){
                count++;
            }
        }
        return count;
    }

    //using divide and conquer:O(nlogn)
    public static int MajorityElement3(int[] arr,int lo,int hi){
        if(lo == hi){
            return arr[lo];
        }

        int mid = lo + (hi-lo)/2;
        int left = MajorityElement3(arr, lo, mid);
        int right = MajorityElement3(arr, mid+1, hi);

        if(left == right){
            return left;
        }

        int leftCount = countInRange(arr, left, lo, hi);
        int rightCount = countInRange(arr, right, lo, hi);

        return (leftCount > rightCount)? left:right;

    }




    public static void main(String[] args) {
        int[] arr = {1,2,1,1,1,3,3,4,4,4,3,3,4,3,4,4,4,4,4,4,4,4,4,4,4};
        System.out.println(MajorityElement3(arr,0,arr.length-1));
    }
}
