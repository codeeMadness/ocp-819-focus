package Chapter8.Concurrency.eConcurrentCollection;

import java.util.Collections;
import java.util.HashMap;

public class SynchronizedCollections {
    public static void main(String[] args) {
        var foodData = new HashMap<String, Object>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);

        //when to use? for read-only
        //if you are given an existing collection that is not a concurrent class and need to access it among
        //multiple threads
        var synFoodData = Collections.synchronizedMap(foodData);

        //This loop throws a ConcurrentModificationException, whereas our example that used ConcurrentHashMap did not.
        for(String key: synFoodData.keySet())
            synFoodData.remove(key);
    }
}
