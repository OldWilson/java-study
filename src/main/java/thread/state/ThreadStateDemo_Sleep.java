package thread.state;

public class ThreadStateDemo_Sleep {

    static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                while (running) {
                    Thread.onSpinWait();
                }

                System.out.println(" t1 running is false. t1 将sleep.");
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("new t1 t1的状态： " + t1.getState());

        t1.start();

        Thread.sleep(2000L);
        System.out.println("t1.start()后的状态： " + t1.getState());

        running = false;
        Thread.sleep(2000L);
        System.out.println("t1.sleep()后的状态： " + t1.getState());
    }
}
