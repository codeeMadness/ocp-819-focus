package Chapter8.Concurrency.cConcurrencyAPI;

import java.util.concurrent.*;

public class SchedulingTasks {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";
        //The first task is scheduled 10 seconds in the future, whereas the second task is scheduled 8 minutes in the future.
        ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        ScheduledFuture<?> r2 = service.schedule(task2, 8, TimeUnit.MINUTES);
    }
}
