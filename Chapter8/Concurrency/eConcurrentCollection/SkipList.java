package Chapter8.Concurrency.eConcurrentCollection;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

public class SkipList {
    public static void main(String[] args) {

        //ConcurrentSkipListSet is sorted concurrent version of TreeSet
        Set<String> gardenAnimals = new ConcurrentSkipListSet<>();
        gardenAnimals.add("rabbit");
        gardenAnimals.add("gopher");
        System.out.println(gardenAnimals.stream()
                .collect(Collectors.joining(","))); // gopher,rabbit

        //ConcurrentSkipListMap is sorted concurrent version of TreeMap
        Map<String, String> rainForestAnimalDiet = new ConcurrentSkipListMap<>();
        rainForestAnimalDiet.put("koala", "bamboo");
        rainForestAnimalDiet.entrySet()
                .stream()
                .forEach((e) -> System.out.println(
                        e.getKey() + "-" + e.getValue())); // koala-bamboo
    }
}
