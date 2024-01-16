package Chapter8.Concurrency.gParallelStream;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelReduction {
    public static void main(String[] args) {
        //reduce
        System.out.println(List.of('w', 'o', 'l', 'f')
                .parallelStream()
                .reduce("",
                        (s1,c) -> s1 + c,
                        (s2,s3) -> s2 + s3)); // wolf

        //We can omit a combiner parameter in these examples, as the accumulator
        //can be used when the intermediate data types are the same.
        System.out.println(List.of(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0, (a,b) -> (a - b))); // PROBLEMATIC ACCUMULATOR

        System.out.println(List.of("w","o","l","f")
                .parallelStream()
                .reduce("X", String::concat)); // XwXoXlXf


        //collect
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new,
                Set::add,
                Set::addAll);
        System.out.println(set); // [f, l, o, w]

        //parallel reduction on collection
        /**
         * The stream is parallel
         * The parameter of the collect() operation has the Characteristics.CONCURRENT characteristic
         * Either the stream is unordered or the collector has the characteristic Characteristics.UNORDERED.
         * */
        Stream<String> ohMy = Stream.of("lions","tigers","bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors.toConcurrentMap(String::length,
                        k -> k,
                        (s1, s2) -> s1 + "," + s2));
        System.out.println(map); // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap

        var ohMy2 = Stream.of("lions","tigers","bears").parallel();
        ConcurrentMap<Integer, List<String>> map2 = ohMy.collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}
    }
}
