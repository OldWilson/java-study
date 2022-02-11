package thread.state;

public class ThreadStateDemo_Synchronized {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized(ThreadStateDemo_Synchronized.class) {
                System.out.println(" t1 抢到锁");
            }
        });

        synchronized (ThreadStateDemo_Synchronized.class) {
            t1.start();
            Thread.sleep(1000L);
            System.out.println(" t1抢不到锁时的状态：" + t1.getState());
        }
    }
}
