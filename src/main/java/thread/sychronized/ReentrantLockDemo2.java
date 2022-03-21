package thread.sychronized;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2 {

    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            try {
                lock.lock();
                System.out.println("我在等一个新信号: " + this.getName());
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("拿到一个信号: " + this.getName());
                lock.unlock();
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            lock.lock();
            System.out.println("我拿到锁: " + this.getName());
            condition.signalAll();
            System.out.println("我发出一个信号: " + this.getName());
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo2 lockDemo = new ReentrantLockDemo2();
        Producer producer = lockDemo.new Producer();
        Consumer consumer = lockDemo.new Consumer();

        consumer.start();
        producer.start();
    }
}
