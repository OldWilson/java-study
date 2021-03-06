package thread.state;

import java.text.MessageFormat;

public class ThreadStateDemo_Wait {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println("t1将wait(3000L)");
                    obj.wait(3000L);
                    System.out.println("t1将wait()");
                    obj.wait();
                    System.out.println("t1 执行完");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        Thread.sleep(1000L);
        synchronized(obj) {
            System.out.println(MessageFormat.format("t1的状态：{0}", t1.getState()));
            obj.notifyAll();
            Thread.sleep(1000L);
            System.out.println(MessageFormat.format("t1的状态：{0}", t1.getState()));
        }

        Thread.sleep(3000L);
        System.out.println(MessageFormat.format("t1的状态：{0}", t1.getState()));

        Thread.sleep(1000L);
        synchronized(obj) {
            obj.notifyAll();
        }
        System.out.println("t1的状态：" + t1.getState());
        Thread.sleep(1000L);
        System.out.println("t1的状态：" + t1.getState());
    }
}
