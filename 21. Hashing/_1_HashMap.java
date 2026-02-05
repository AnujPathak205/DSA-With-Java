import java.util.HashMap;


public class _1_HashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Anuj",18);
        hm.put("Amit",19);
        hm.put("Ashu",13);

        System.out.println(hm);

        System.out.println(hm.containsKey("Radha"));


        for (String name : hm.keySet()) {
            System.out.println("name: "+name+", marks:"+hm.get(name));
        }
    }
}
