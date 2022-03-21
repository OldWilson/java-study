package thread.sychronized;


import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    final static int MAX = 10;
    LinkedList<Integer> queue = new LinkedList<>();

    Semaphore empty = new Semaphore(MAX);
    Semaphore full = new Semaphore(0);

    int readData() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 100));
        return (int) Math.floor(Math.random());
    }

    // Producer
    public void readDb() throws InterruptedException {
        System.out.println("empty available: " + empty.availablePermits());
        empty.acquire();
        synchronized (queue) {
            var data = readData();
            queue.add(data);
            System.out.println("线程" + Thread.currentThread().getName() + " queue-size: " + queue.size());
        }
        full.release();
    }

    // Comsumer
    public void calculate() throws InterruptedException {
        System.out.println("full available: " + full.availablePermits());
        full.acquire();
        synchronized (queue) {
            var data = queue.remove();
            System.out.println("线程" + Thread.currentThread().getName() + " queue-size: " + queue.size());
        }
        empty.release();
    }

    public static void main(String[] args) {
        var p = new SemaphoreDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        p.readDb();
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
