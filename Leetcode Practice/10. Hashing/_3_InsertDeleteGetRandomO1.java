/*
    380. Insert Delete GetRandom O(1)
    (Medium)

    Implement the RandomizedSet class:

    RandomizedSet() Initializes the RandomizedSet object.
    bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
    bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
    int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). 
    Each element must have the same probability of being returned.
    You must implement the functions of the class such that each function works in average O(1) time complexity.
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


class RandomizedSet {
    private Map<Integer,Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastIndex = list.size() - 1;

            int temp = list.get(index);
            list.set(index,list.get(lastIndex));
            list.set(lastIndex,temp);

            map.put(list.get(index),index);
            list.removeLast();

            map.remove(val);
            return true;
        } 
        return false;
        
    }
    
    public int getRandom() {
        int randomNum = random.nextInt(list.size());
        return list.get(randomNum);
    }
}


public class _3_InsertDeleteGetRandomO1 {
    public static void main(String[] args) {
        
    }
}