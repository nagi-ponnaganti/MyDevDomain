/**
 * 
 */
package com.nagihome.datetime;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author nageswararao
 *
 */
public class DateTimeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime: " + localDateTime);

		Clock clock = Clock.systemDefaultZone();
		localDateTime = LocalDateTime.now(clock);
		System.out.println("Clock Datetime: " + localDateTime);

		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println("zoneId: " + zoneId);
		localDateTime = LocalDateTime.now(zoneId);
		System.out.println("zoneId Datetime: " + localDateTime);

		localDateTime = LocalDateTime.of(Year.now().getValue(), Month.MARCH.getValue(), DayOfWeek.THURSDAY.getValue(),
				1, 1, 1);
		System.out.println("created localdatetime: " + localDateTime);

		LocalDate localDate = LocalDate.now();
		System.out.println("LocalDate: " + localDate);

		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime: " + localTime);

		localDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println("Builded Datetime: " + localDateTime);

		localDate = LocalDate.ofEpochDay(150);
		System.out.println("Of Epoch Day: " + localDate);

		localDateTime = LocalDateTime.now().withDayOfYear(21).withMonth(Month.MAY.getValue())
				.withYear(Year.of(1985).getValue());
		System.out.println("past datetime: " + localDateTime);

		localDateTime = LocalDateTime.now().minusWeeks(1).plus(3, ChronoUnit.DAYS);
		System.out.println("minus datetime: " + localDateTime);

		System.out.println("actualLocalDate: " + localDate);
		LocalDate adjustedLocalDate = localDate.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("adjustedLocalDate: " + adjustedLocalDate);

		localDate = LocalDate.now();
		System.out.println("temporal adjustment: " + localDate.with(TemporalAdjusters.lastDayOfYear()));
		System.out.println("localDate: " + localDate);
		
	}

}
