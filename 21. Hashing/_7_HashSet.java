
import java.util.HashSet;
import java.util.Iterator;

public class _7_HashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(26);
        set.add(4);
        set.add(5);
        set.add(1);
        set.add(23);

        System.out.println(set);

        Iterator<Integer> it = set.iterator();

        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }

        System.out.println();

        for(int i : set){
            System.out.print(i+" ");
        }

        System.out.println();
    }
}