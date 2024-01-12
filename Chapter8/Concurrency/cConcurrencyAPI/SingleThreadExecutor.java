package Chapter8.Concurrency.cConcurrencyAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public class ZooInfo {
        public void main(String[] args) {
            ExecutorService service = null;

            Runnable task1 = () -> System.out.println("Printing zoo inventory");
            Runnable task2 = () -> {
                for(int i = 0; i < 3; i++)
                    System.out.println("Printing record: "+i);
            };

            try {
                //single-thread executor, results are guaranteed to be executed sequentially
                service = Executors.newSingleThreadExecutor();
                System.out.println("begin"); //thread main
                service.execute(task1); //thread service
                service.execute(task2); //thread service
                service.execute(task1); //thread service
                System.out.println("end"); //thread main

                /**
                 * begin
                 * Printing zoo inventory
                 * Printing record: 0
                 * Printing record: 1
                 * end
                 * Printing record: 2
                 * Printing zoo inventory
                 * */

            } finally {
                //the ExecutorService interface does not extend the AutoCloseable interface, so you cannot use a try-with-resources statement
                //use shutDown instead
                if(service != null) service.shutdown();
            }
        }
    }
}
