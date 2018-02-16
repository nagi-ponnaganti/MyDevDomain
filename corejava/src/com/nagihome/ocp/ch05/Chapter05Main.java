package com.nagihome.ocp.ch05;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class Chapter05Main {

    public static void main(String[] args) {

        System.out.println("LocalDate: " + LocalDate.now());
        System.out.println("LocalTime: " + LocalTime.now());
        System.out.println("LocalDateTime: " + LocalDateTime.now());
        System.out.println("ZonedDateTime: " + ZonedDateTime.now());

        ZoneId zoneId = ZoneId.of("US/Eastern");
        System.out.println("Current time in US: " + ZonedDateTime.of(LocalDateTime.now(), zoneId));

        ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.contains("Asia"))
                .limit(1)
                .forEach(System.out::println);

        doAnimalToyExchange(LocalDate.of(2018, 1, 1), LocalDate.of(2018, 3, 30), Period.ofMonths(1));

        Duration ofDays = Duration.ofDays(1);
        Duration ofHours = Duration.ofHours(2);
        Duration ofMins = Duration.ofMinutes(3);
        Duration ofSecs = Duration.ofSeconds(4);
        Duration ofMillliSecs = Duration.ofMillis(5);
        Duration ofNanoSecs = Duration.ofNanos(6);

        Duration.of(1, ChronoUnit.DAYS);
        Stream.of(ofDays, ofHours, ofMins, ofSecs, ofMillliSecs, ofNanoSecs).forEach(System.out::println);

    }

    private static void doAnimalToyExchange(LocalDate start, LocalDate end, Period period) {

        LocalDate upto = start;
        while (upto.isBefore(end)) {
            System.out.println("Do the Animal Enrichment upto: " + upto);
            upto = upto.plus(period);
        }
    }
}
