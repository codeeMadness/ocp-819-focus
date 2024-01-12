package Chapter8.Concurrency.cConcurrencyAPI;

import java.util.concurrent.*;

public class WaitingResults {
    public static class CheckResults {
        private static int counter = 0;

        public static void main(String[] unused) throws Exception {
            ExecutorService service = null;
            try {
                service = Executors.newSingleThreadExecutor();
                //Runnable
                Future<?> result = service.submit(() -> {
                    for (int i = 0; i < 500; i++) CheckResults.counter++;
                });
                result.get(10, TimeUnit.SECONDS);
                System.out.println("Reached!");
            } catch (TimeoutException e) {
                System.out.println("Not reached in time");
            } finally {
                if (service != null) service.shutdown();
            }

            if(service != null) {
                //The method waits the specified time to complete all tasks
                service.awaitTermination(1, TimeUnit.MINUTES);
                // Check whether all tasks are finished
                if(service.isTerminated()) System.out.println("Finished!");
                else System.out.println("At least one task is still running");
            }

        }
    }

    public static class AddData {
        public static void main(String[] args) throws Exception {
            ExecutorService service = null;
            try {
                service = Executors.newSingleThreadExecutor();
                //Callable
                Future<Integer> result = service.submit(() -> 30 + 11);
                System.out.println(result.get()); // 41
            } finally {
                if(service != null) service.shutdown();
            }
        }
    }
}
