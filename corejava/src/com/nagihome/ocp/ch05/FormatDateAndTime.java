package com.nagihome.ocp.ch05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatDateAndTime {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime localTime = LocalTime.of(16, 12, 44);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        System.out.println("LocalDate: " + localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("LocalTime: " + localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("LocalDateTime: " + localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));

        System.out.println("Short LocalDateTime: " + localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
        System.out.println("Medium LocalDateTime: " + localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

    }

}
