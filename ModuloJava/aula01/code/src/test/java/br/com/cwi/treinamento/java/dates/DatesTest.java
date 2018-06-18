package br.com.cwi.treinamento.java.dates;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class DatesTest {

    @Test
    public void localDateShouldStoreADateWithoutTime() {
        LocalDate now = LocalDate.now();

        System.out.println(now);
    }

    @Test
    public void shouldCreateAndPrintLocalDate() {
        LocalDate date = LocalDate.of(2018, Month.MAY, 6);

        System.out.println(date);
    }

    @Test
    public void shouldPrintPeriodBetweenTwoDates() {
        LocalDate now = LocalDate.now();
        LocalDate septemberEleven = LocalDate.of(2001, Month.SEPTEMBER, 11);

        Period period = Period.between(septemberEleven, now);

        System.out.printf("%s years, %s months and %s days", period.getYears(), period.getMonths(), period.getDays());
    }

    @Test
    public void shouldCreateAndPrintLocalTime() {
        LocalTime time = LocalTime.of(8, 0);

        System.out.println(time);
    }

    @Test
    public void shouldCalculateDiferenceBetweenTwoTimes() {
        LocalTime time = LocalTime.of(8, 0);
        LocalTime time2 = LocalTime.of(18, 0);

        long minutes = time.until(time2, ChronoUnit.MINUTES);

        assertEquals(600, minutes);
    }

    @Test
    public void shouldCreateAndPrintLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);
    }

    @Test
    public void shouldPrintHoursUntilWorldCup() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime worldCup2018Opening = LocalDateTime.of(2018, Month.JUNE, 14, 12, 0);

        long hoursUntilWorldCup = now.until(worldCup2018Opening, ChronoUnit.HOURS);

        System.out.println(hoursUntilWorldCup);
    }

    @Test
    public void shouldCalculateDurationOfFlight() {
        ZoneId saoPauloTimeZone = ZoneId.of("America/Sao_Paulo");
        ZoneId newYorkTimeZone = ZoneId.of("America/New_York");

        ZonedDateTime saoPauloDeparture = ZonedDateTime.of(LocalDateTime.of(2014, Month.APRIL, 4, 22, 00), saoPauloTimeZone);
        ZonedDateTime arrivalInNewYork = ZonedDateTime.of(LocalDateTime.of(2014, Month.APRIL, 5, 7, 00), newYorkTimeZone);

        Duration flightDuration = Duration.between(saoPauloDeparture, arrivalInNewYork);

        assertEquals(10, flightDuration.toHours());
    }

    @Test
    public void shouldFormatDate() {
        LocalDate now = LocalDate.of(2018, Month.MAY, 6);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = now.format(formatter);

        assertEquals("06/05/2018", formattedDate);
    }

    public void teste(){
        LocalDate.now();//data atual
        LocalTime.now();//horario atual
        LocalDateTime.now();//data com horario
        LocalDate.of(2018,1,10);
        LocalTime.of(15,44);
        LocalDateTime.of(2018,6,18,15,44);
    }


    @Test
    public void testDifferenceInYears(){
        LocalDate camilasBirth = LocalDate.of(1991,Month.SEPTEMBER,4);

        LocalDate pedrosBirth = LocalDate.of(1997,Month.JULY,5);

        Long years = camilasBirth.until(pedrosBirth,ChronoUnit.YEARS);

        assertEquals(5,years.intValue());
    }

    @Test
    public void testDifferenceInMonths(){
        LocalDate camilasBirth = LocalDate.of(1991,Month.SEPTEMBER,4);

        LocalDate pedrosBirth = LocalDate.of(1997,Month.JULY,5);

        Long months = camilasBirth.until(pedrosBirth,ChronoUnit.MONTHS);

        assertEquals(70,months.intValue());
    }


    @Test
    public void testDifferenceInDays(){
        LocalDate camilasBirth = LocalDate.of(1991,Month.SEPTEMBER,4);

        LocalDate pedrosBirth = LocalDate.of(1997,Month.JULY,5);

        Long days = camilasBirth.until(pedrosBirth,ChronoUnit.DAYS);

        assertEquals(2131,days.intValue());
    }
}
