
import java.util.Arrays;
import java.util.HashSet;

public class _11_Union_Intersaction {
    public static Integer[] union(int[] arr1,int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr1){
            set.add(i);
        }
        for(int i:arr2){
            set.add(i);
        }
        return set.stream().toArray(Integer[]::new);
    }

    public static Integer[] intersaction(int[] arr1,int[] arr2){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i:arr1){
            set1.add(i);
        }

        for(int i:arr2){
            if(set1.contains(i)){
                set2.add(i);
            }
        }

        return set2.stream().toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {4,5,6,7,8};

        Integer[] union = union(arr1, arr2);
        Integer[] intersaction = intersaction(arr1, arr2);

        Arrays.stream(union).map(i -> i+" ").forEach(System.out::print);System.out.println();
        Arrays.stream(intersaction).map(i -> i+" ").forEach(System.out::print);System.out.println();

    }
}
