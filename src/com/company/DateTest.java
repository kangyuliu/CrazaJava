package com.company;

import javax.net.ssl.SSLContext;
import java.awt.desktop.SystemSleepEvent;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args)throws Exception{
        var date1 = new Date();
        var date2 = new Date(System.currentTimeMillis() + 100);
        System.out.println(date2);
        System.out.println(date1);
        System.out.println(date1.getTime());
        System.out.println(date1.before(date2));
        System.out.println(date2.after(date1));
        var calendar = Calendar.getInstance();
        var date = calendar.getTime();
        calendar.setTime(date);
        System.out.println(date);

        //year
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.getMaximum(Calendar.YEAR));
        System.out.println(calendar.getMaximum(Calendar.MONTH));
        System.out.println(calendar.getMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(2019,12,31,0,0,0);
        System.out.println(calendar);

        Clock clock = Clock.systemUTC();
        Instant instant = Instant.now();
        System.out.println(clock);
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        Thread.sleep(10);
        System.out.println(System.currentTimeMillis());
        Duration duration = Duration.ofSeconds(6000);
        System.out.println(duration.toMillis());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toHours());
        System.out.println(duration.toDays());

        Clock clock2 = Clock.offset(clock, duration);
        System.out.println(instant);
        var instant2 = instant.plusSeconds(6000);
        System.out.println(instant2);

        //LocalDate
        LocalDate localDate = LocalDate.of(2019,12,31);
        System.out.println(localDate);

        //localTime
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        localTime = LocalTime.of(22,59);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime2 = localDateTime.minusHours(1).plusSeconds(10);
        System.out.println(localDateTime2);
        var year = Year.now();
        System.out.println(year);
        year = year.plusYears(10);
        System.out.println(year);
    }
}
