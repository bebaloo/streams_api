package com.foxminded;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime l1 = LocalDateTime.parse("2018-05-24T12:14:12.054");
        LocalDateTime l2 = LocalDateTime.parse("2018-05-24T12:15:24.067");
        Duration duration = Duration.between(l1, l2);
             
        System.out.print(duration.toMinutes() +":"+ duration.toSeconds() % 60 +"."+ duration.toMillis() % 60000 * 0.001);
    }
}
