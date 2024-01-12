package Chapter8.Concurrency.cConcurrencyAPI;

import java.util.List;
import java.util.concurrent.*;

public class SubmitTaskCollections {
    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newSingleThreadExecutor();

        System.out.println("begin");
        Callable<String> task = () -> "result";

        List<Future<String>> list = service.invokeAll(List.of(task, task, task));
        for (Future<String> future : list) {
            System.out.println(future.get());
        }

        String data = service.invokeAny(List.of(task, task, task));
        System.out.println(data);

        System.out.println("end");
    }
}
