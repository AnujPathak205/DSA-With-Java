
import java.util.ArrayList;
import java.util.HashSet;

public class _10_CountDistinctElement {
    //Brute force approach
    public static int distinctElementCount(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i:arr){
            boolean isPresent = false;
            for(int j:result){
                if(i == j){
                    isPresent = true;
                    break;
                }
            }
            if(!isPresent){
                result.add(i);
            }
        }
        return result.size();
    }

    //HashSet approach
    public static int distinctElementCount2(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr) set.add(i);
        return set.size();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,5,6,8,7,9,1,3,2,5,4};
        System.out.println(distinctElementCount(arr));
        System.out.println(distinctElementCount2(arr));

    }
}
