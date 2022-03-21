package thread.sychronized;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerCustomerModel {
    final static int MAX = 10;
    LinkedList<Integer> queue = new LinkedList<>();

    ReentrantLock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition empty = lock.newCondition();

    int readData() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 100));
        return (int) Math.floor(Math.random());
    }

    // Producer
    public void readDb() throws InterruptedException {
//        synchronized (queue) {
        lock.lock();
        if (queue.size() == MAX) {
//            queue.wait();
//            System.out.println("Producer await before status: " + Thread.currentThread().getName() + " -- " + Thread.currentThread().getState());
            full.await();
//            System.out.println("Producer await after status: " + Thread.currentThread().getName() + " -- " + Thread.currentThread().getState());
            return;
        }
        var data = readData();
        if (queue.size() >= 1) {
//            queue.notifyAll();
//            System.out.println("Producer signalAll before status: " + Thread.currentThread().getName() + " -- " + Thread.currentThread().getState());
            empty.signalAll();
//            System.out.println("Producer signalAll after status: " + Thread.currentThread().getName() + " -- " + Thread.currentThread().getState());
        }
        queue.add(data);
        System.out.println("Producer 线程" + Thread.currentThread().getName() + " queue-size: " + queue.size());
        lock.unlock();
//        }
    }

    // Comsumer
    public void calculate() throws InterruptedException {
//        synchronized (queue) {
        lock.lock();
        if (queue.size() == 0) {
//                queue.wait();
//            System.out.println("Comsumer await before status: " + Thread.currentThread().getName() + " -- " + Thread.currentThread().getState());
            empty.await();
//            System.out.println("Comsumer await after status: " + Thread.currentThread().getName() + " -- " + Thread.currentThread().getState());
            return;
        }
        if (queue.size() < MAX) {
//                queue.notifyAll();
//            System.out.println("Comsumer signalAll before status: " + Thread.currentThread().getName() + " -- " + Thread.currentThread().getState());
            full.signalAll();
//            System.out.println("Comsumer signalAll after status: " + Thread.currentThread().getName() + " -- " + Thread.currentThread().getState());
        }
        var data = queue.remove();
        System.out.println("queue-size: " + queue.size());
        lock.unlock();
//        }
    }

    public static void main(String[] args) {
        var p = new ProducerCustomerModel();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    try {
//                        System.out.println("readDb前 线程" + Thread.currentThread().getName() +"的状态：" + Thread.currentThread().getState());
                        p.readDb();
//                        System.out.println("readDb后 线程" + Thread.currentThread().getName() +"的状态：" + Thread.currentThread().getState());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    p.calculate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
