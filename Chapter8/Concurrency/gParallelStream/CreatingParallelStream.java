package Chapter8.Concurrency.gParallelStream;

import java.util.List;
import java.util.stream.Stream;

public class CreatingParallelStream {
    public static void main(String[] args) {
        //existing stream
        Stream<Integer> s1 = List.of(1,2).stream();
        Stream<Integer> s2 = s1.parallel();
        Stream<Integer> s3 = List.of(1,2).parallelStream();


    }
}
