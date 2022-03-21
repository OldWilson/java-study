package thread.sychronized;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        var lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        var obj = new Object();
        var t1 = new Thread(() -> {
            System.out.println("before-wait .... 1");
            try {
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("after-wait ... 1");
        });

        var t2 = new Thread(() -> {
            System.out.println("before-wait .... 2");
            try {
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("after-wait ... 2");
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
        lock.lock();
        condition.signalAll();
        lock.unlock();
    }
}
