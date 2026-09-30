/*
    381. Insert Delete GetRandom O(1) - Duplicates allowed
    (Hard)

    RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also reporting a random element.

    Implement the RandomizedCollection class:

    RandomizedCollection() Initializes the empty RandomizedCollection object.
    bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
    bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present, false otherwise. Note that if val has multiple 
    occurrences in the multiset, we only remove one of them.
    int getRandom() Returns a random element from the current multiset of elements. The probability of each element being returned is linearly related to
     the number of the same values the multiset contains.
    You must implement the functions of the class such that each function works on average O(1) time complexity.

    Note: The test cases are generated such that getRandom will only be called if there is at least one item in the RandomizedCollection.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

class RandomizedCollection {

    HashMap<Integer, Set<Integer>> map;
    List<Integer> list;
    private Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean ans = false;

        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
            ans = true;
        }

        map.get(val).add(list.size());
        list.add(val);

        return ans;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val).iterator().next();
        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        map.get(val).remove(idx);

        if (idx != lastIndex) {
            list.set(idx, lastVal);

            map.get(lastVal).remove(lastIndex);
            map.get(lastVal).add(idx);
        }

        list.remove(lastIndex);

        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        return true;
    }

    public int getRandom() {
        int randomNum = random.nextInt(list.size());
        return list.get(randomNum);
    }
}

public class _4_InsertDeleteGetRandomO1DuplicatesAllowed {

    public static void main(String[] args) {

    }
}
