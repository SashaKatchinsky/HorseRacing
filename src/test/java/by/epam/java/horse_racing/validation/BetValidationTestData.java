package by.epam.java.horse_racing.validation;

import by.epam.java.horse_racing.bean.Event;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.LocalTime;

public class BetValidationTestData {
    @DataProvider(name = "isTimeValidTest")
    public static Object[][] isTimeValidTest() {
        Event event1 = new Event();
        Event event2 = new Event();
        Event event3 = new Event();
        Event event4 = new Event();
        Event event5 = new Event();

        event1.setDate(LocalDate.of(LocalDate.now().getYear() - 1 , 12 , 21));
        event1.setTime(LocalTime.now());
        event2.setDate(LocalDate.of(LocalDate.now().getYear() + 1 , 12 , 21));
        event2.setTime(LocalTime.now());
        event3.setDate(LocalDate.of(LocalDate.now().getYear() + 10 , 12 , 21));
        event3.setTime(LocalTime.now());
        event4.setDate(LocalDate.of(LocalDate.now().getYear() - 10 , 12 , 21));
        event4.setTime(LocalTime.now());
        event4.setDate(LocalDate.now());
        event5.setTime(LocalTime.now());

        return new Object[][] {
                {event1 , false},
                {event2 , true},
                {event3 , true},
                {event4 , false},
                {event5 , false}
        };
    }
}
