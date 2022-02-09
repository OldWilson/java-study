package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPoolDemo extends Thread{
    // 仓库
    private BlockingQueue<Runnable> taskQueue;

    // 工作线程
    List<Worker> workerList;

    private volatile boolean working = true;

    public ThreadPoolDemo(int poolSize, int queueSize) {
        taskQueue = new LinkedBlockingDeque<>(queueSize);
        workerList = new ArrayList<>();
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker(this);
            worker.start();
            workerList.add(worker);
        }
    }

    public boolean submit(Runnable task) {
        if (this.working) {
            return taskQueue.offer(task);
        } else {
            return false;
        }
    }

    public void shutdown() {
        /**
         * 1. 不能接收新任务
         * 2. 执行完以提交的任务，再关闭线程池
         */
        this.working = false;

        for (Thread thread : workerList) {
            Thread.State state = thread.getState();
            if (state.equals(State.BLOCKED) || state.equals(State.WAITING) || state.equals(State.TIMED_WAITING)) {
                thread.interrupt(); // 中断线程的阻塞、等待状态，它会给线程一个被中断的标识
            }
        }
    }

    private static class Worker extends Thread {
        ThreadPoolDemo poolDemo;

        public Worker(ThreadPoolDemo poolDemo) {
            this.poolDemo = poolDemo;
        }

        @Override
        public void run() {
            while(poolDemo.working || !poolDemo.taskQueue.isEmpty()) {
                Runnable task = null;
                try {
                    if (poolDemo.working) {
                        task = poolDemo.taskQueue.take();
                    } else {
                        task = poolDemo.taskQueue.poll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    task.run();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolDemo poolDemo = new ThreadPoolDemo(3, 6);
        for (int i = 0; i < 5; i++) {
            poolDemo.submit(() -> {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 执行完任务");
            });
        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        poolDemo.shutdown();
    }

}
