package coding.java8plus;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResource {

    @Test
    public void test() throws IOException {
        var fin = new FileInputStream("word");
        try (fin) {
            fin.read();
        }
    }
}
