package Chapter8.Concurrency.gParallelStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatefulOperations {
    // A stateful lambda expression is one whose result depends on any state that might change during the execution of a pipeline
    public List<Integer> addValues(IntStream source) {
        var data = Collections.synchronizedList(new ArrayList<Integer>());
        source.filter(s -> s % 2 == 0)
                .forEach(i -> { data.add(i); }); // STATEFUL: DON'T DO THIS!
        return data;
    }
    // A stateless lambda expression is one whose result does not depend on any state that might change during the execution of a pipeline
    public static List<Integer> addValues2(IntStream source) {
        return source.filter(s -> s % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}
