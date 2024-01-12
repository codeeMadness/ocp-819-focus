package Chapter8.Concurrency.bExecuteTask;

public class ExecuteTask {
    /**
     * 2 ways of executing Task via Thread:
     * - Provide a Runnable object or lambda expression to the Thread constructor.
     * - Create a class that extends Thread and overrides the run() method.
     * */


    public static class PrintData implements Runnable {
        @Override public void run() { // Overrides method in Runnable
            for(int i = 0; i < 3; i++)
                System.out.println("Printing record: "+i);
        }
        public void main(String[] args) {
            //Provide a Runnable object or lambda expression to the Thread constructor
            (new Thread(new PrintData())).start();}
    }

    //Create a class that extends Thread and overrides the run() method.
    public static class ReadInventoryThread extends Thread {
        @Override public void run() { // Overrides method in Thread
            System.out.println("Printing zoo inventory");
        }
        public void main(String[] args) {
            (new ReadInventoryThread()).start();
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");
        //start thread
        (new ReadInventoryThread()).start();
        (new Thread(new PrintData())).start();
        (new ReadInventoryThread()).start();
        //not start thread
        (new ReadInventoryThread()).run();
        (new Thread(new PrintData())).run();
        (new ReadInventoryThread()).run();
        System.out.println("end");
    }
}
