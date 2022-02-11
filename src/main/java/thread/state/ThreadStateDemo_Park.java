package thread.state;

import java.util.concurrent.locks.LockSupport;

public class ThreadStateDemo_Park {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(LockSupport::park);

        t1.start();
        Thread.sleep(2000L);
        System.out.println("t1被park后的状态：" + t1.getState());
        LockSupport.unpark(t1);
    }
}
