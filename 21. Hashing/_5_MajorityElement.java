import java.util.HashMap;

public class _5_MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,3,1,5,1};
        int n = nums.length;

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int element:nums){
            hm.put(element,1+hm.getOrDefault(element, 0));
        }


        for(Integer key : hm.keySet()){
            if(hm.get(key) > n/3){
                System.out.print(key);
            }
        }

    }
}
