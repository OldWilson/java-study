package thread.state;

public class ThreadStateDemo_Join {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println(" t2 中执行 t1.join(5000L)...");
                t1.join(5000L);
                System.out.println(" t2 中执行t1.join()...");
                t1.join();
                System.out.println(" t2 执行完");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000L);
        System.out.println("t2的状态： " + t2.getState());

        Thread.sleep(5000L);
        System.out.println("t2的状态： " + t2.getState());
    }
}
