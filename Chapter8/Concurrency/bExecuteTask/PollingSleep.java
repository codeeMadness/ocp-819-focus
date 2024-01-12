package Chapter8.Concurrency.bExecuteTask;

public class PollingSleep {
    public static class CheckResults {
        private static int counter = 0;
        public static void main(String[] args) throws InterruptedException{
            new Thread(() -> {
                for(int i = 0; i < 500; i++) CheckResults.counter++;
            }).start();
            //bad practice => infinitely print
//            while(CheckResults.counter < 100) {
//                System.out.println("Not reached yet");
//            }
            //good practice => infinitely print
            while(CheckResults.counter < 100) {
                System.out.println("Not reached yet");
                Thread.sleep(1000); //delay 1 second before next loop
            }
            System.out.println("Reached!");
        }
    }
}
