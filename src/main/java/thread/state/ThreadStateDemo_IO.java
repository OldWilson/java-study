package thread.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ThreadStateDemo_IO {

    public static void main(String[] args) throws InterruptedException {
        Charset charset = StandardCharsets.UTF_8;
        Thread t1 = new Thread(() -> {
            try (ServerSocket ss = new ServerSocket(9000)) {
                while (true) {
                    System.out.println("t1即将接收连接。。。");
                    //
                    Socket socket = ss.accept();
                    System.out.println("t1接收到连接。。。");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), charset.name()));

                    String mess = null;
                    System.out.println("t1 将接收连接的数据。。。");
                    while((mess = reader.readLine()) != null) {
                        System.out.println(mess);
                    }
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        Thread.sleep(3000L);
        System.out.println("t1的状态：" + t1.getState());
        Thread.sleep(20000L);
        System.out.println("t1的状态：" + t1.getState());
    }
}
