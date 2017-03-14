package leetcode.insertDeleteGetRandomO;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * 
 * 
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * 
 * 
 * 
 * Example:
 * 
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * 
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * 
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * 
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * 
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * 
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * 
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * 
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 * 
 * 

 * Source: https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
import java.util.concurrent.ThreadLocalRandom;
class RandomizedSet {
    List<Integer> values = new ArrayList<>();
    Map<Integer, Integer> indices = new HashMap<>();

      public boolean insert(int val) {
        if (!indices.containsKey(val)) {
            Integer oldIndex = indices.put(val, values.size());
            values.add(val);
            return true;
        } else return false;
    }

    public boolean remove(int val) {
        Integer index = indices.remove(val);
        if (index != null) {
            Integer lastVal = values.remove(values.size() - 1);
            if (lastVal != val) {
                values.set(index, lastVal);
                indices.put(lastVal, index);
            }
            return true;
        } else return false;
    }

    public int getRandom() {
        return values.get(ThreadLocalRandom.current().nextInt(values.size()));
    }
}
