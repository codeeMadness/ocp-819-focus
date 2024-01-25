package Chapter5.ArraysAndCollections.cSetAndMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetAndMap {
    public static void main(String[] args) {
         //Two common classes that implement Set
         //HashSet is the most common. TreeSet is used when sorting is important
         Set<Integer> set = new HashSet<>();
         System.out.println(set.add(66)); // true
         System.out.println(set.add(66)); // false
         System.out.println(set.size()); // 1
         set.remove(66);
         System.out.println(set.isEmpty()); //true

         Map<String, String> map = new HashMap<>();
         map.put("koala", "bamboo");
         String food = map.get("koala"); // bamboo
         String other = map.getOrDefault("ant", "leaf"); // leaf
         for (String key: map.keySet())
             System.out.println(key + " " + map.get(key)); // koala bamboo
    }
}
