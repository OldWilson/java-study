package coding.java8plus;

import org.junit.Test;

import java.time.*;

public class Local {

    @Test
    public void test_date() {
        var date = LocalDate.of(2021, 4, 15);
        System.out.println("date: " + date);

        var time = LocalTime.of(15, 25, 30);
        System.out.println("time: " + time);

        var dateTime = LocalDateTime.of(date, time);
        System.out.println("dateTime: " + dateTime);

        var zonDT = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Shanghai"));
        System.out.println("zonDT: " + zonDT);
    }
}
