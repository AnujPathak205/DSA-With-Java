
import java.util.LinkedList;

class HashMap<K,V>{
    private class Node{
        K key;
        V value;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int N;
    private LinkedList<Node> buckets[];

    @SuppressWarnings("unchecked")
    public HashMap(){
        this.size = 0;
        this.N = 4;
        this.buckets = new LinkedList[4];
        for(int i = 0;i < 4;i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key){
        int hc = key.hashCode();
        return Math.abs(hc)%N;
    }

    private int searchInLL(K key,int bi){
        for(int i = 0;i < buckets[bi].size();i++){
            Node node = buckets[bi].get(i);
            if(node.key == key){
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash(){
        LinkedList<Node> oldBuckets[] = buckets;
        buckets = new LinkedList[N*2];
        N *= 2;
        for(int i = 0;i < N;i++){
            buckets[i] = new LinkedList<>();
        }

        //nodes -> add in new buckets
        for(int i = 0;i < oldBuckets.length;i++){
            while(!oldBuckets[i].isEmpty()){
                Node node = oldBuckets[i].remove();
                put(node.key, node.value);
            }
        }
    }

    public void put(K key,V value){
        int bi = hashFunction(key);//bucket index
        int di = searchInLL(key, bi);
        if(di != -1){
            Node node = buckets[bi].get(di);
            node.value = value;
        }else{
            buckets[bi].add(new Node(key, value));
            size++;
        }

        double lambda = (double)size/N;
        if(lambda > 2.0){
            rehash();
        }
    }

    public V remove(K key){
        int hc = hashFunction(key);
        int di = searchInLL(key, hc);
        if(di == -1){
            return null;
        }else{
            size--;
            return buckets[hc].remove(di).value;
        }
    }

    public V get(K key){
        int hc = hashFunction(key);
        int bi = searchInLL(key, hc);
        if(bi == -1)return null;
        else return buckets[hc].get(bi).value;
    }



    public boolean containsKey(K key){
        int hc = hashFunction(key);
        int di = searchInLL(key, hc);
        return di != -1;
    }

    public void printHashMap(){
        for(int i = 0;i < N;i++){
            for(int j = 0;j < buckets[i].size();j++){
                Node node = buckets[i].get(j);
                System.out.println("("+i+","+j+") "+node.key + " -> "+node.value);
            }
        }
    }

}

public class _2_ImplementationOfHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Anuj",18);
        hm.put("Amit",16);
        hm.put("Radha",100);
        hm.put("Mohan",99);
        hm.put("Kanha",92);
        hm.put("Ram",90);

        hm.printHashMap();

        Integer i = 45;
        System.out.println(i.hashCode());
    }
}
