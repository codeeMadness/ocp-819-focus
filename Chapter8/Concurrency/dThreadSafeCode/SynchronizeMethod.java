package Chapter8.Concurrency.dThreadSafeCode;

public class SynchronizeMethod {

    private int sheepCount;
    //Correctly using the synchronized keyword can be quite challenging, especially if the data you are
    //trying to protect is available to dozens of methods
    
    private void incrementAndReport() {
        synchronized(this) {
            System.out.print((++sheepCount)+" ");
        }
    }
    private synchronized void incrementAndReport2() {
        System.out.print((++sheepCount)+" ");
    }
}
