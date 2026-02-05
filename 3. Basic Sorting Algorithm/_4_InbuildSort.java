
import java.util.Arrays;
import java.util.Collections;

public class _4_InbuildSort{
    public static void main(String[] args) {
        int[] arr = {5,2,3,1,4};
        Arrays.sort(arr,0,3);

        for(int element:arr){
            System.out.print(element+" ");
        }

        System.out.println();

        Integer[] arr2 = {1,3,2,5,4};
        Arrays.sort(arr2,Collections.reverseOrder());

        for(Integer element:arr2){
            System.out.print(element+" ");
        }

        System.out.println();


    }
}