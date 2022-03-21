package thread.sychronized;

public class sychronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        var obj = new Object();
        var t1 = new Thread(() -> {
            System.out.println("before-wait .... 1");
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after-wait ... 1");
        });

        var t2 = new Thread(() -> {
            System.out.println("before-wait .... 2");
            try {
                synchronized(obj) {
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after-wait ... 2");
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}
