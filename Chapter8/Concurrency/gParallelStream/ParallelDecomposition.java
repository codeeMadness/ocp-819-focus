package Chapter8.Concurrency.gParallelStream;

import java.util.List;

public class ParallelDecomposition {
    private static int doWork(int input) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        return input;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        List.of(1,2,3,4,5)
                .stream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken = (System.currentTimeMillis()-start)/1000;
        System.out.println("Time: "+timeTaken+" seconds");
        //Output: 1 2 3 4 5
        //Time: 25 seconds

        long start2 = System.currentTimeMillis();
        List.of(1,2,3,4,5)
                .parallelStream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken2 = (System.currentTimeMillis()-start2)/1000;
        System.out.println("Time: "+timeTaken2+" seconds");
        //Output: 3 2 1 5 4
        //Time: 5 seconds
    }
}
