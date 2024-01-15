package Chapter8.Concurrency.dThreadSafeCode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFramework {

    //acquire a lock
    public static void printMessage(Lock lock) {
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }

    //indicating whether the lock was obtained
    public static void tryLock() {
        Lock lock = new ReentrantLock();
        new Thread(() -> printMessage(lock)).start();
        if(lock.tryLock()) {
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Unable to acquire lock, doing something else");
        }
    }

    public static void main(String[] args) {

    }
}
