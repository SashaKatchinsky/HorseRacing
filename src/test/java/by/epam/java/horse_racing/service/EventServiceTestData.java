package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.bean.Event;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventServiceTestData {

    @DataProvider(name = "getPlayedEventsTestData")
    public static Object[][] getPlayedEventsTestData() {
        List<Event> events = new ArrayList<>();
        List<Event> expected = new ArrayList<>();
        Event event0 = new Event();
        Event event1 = new Event();
        Event event2 = new Event();
        Event event3 = new Event();
        Event event4 = new Event();

        event0.setDate(LocalDate.of(LocalDate.now().getYear() - 1 , 12 , 12));
        event0.setTime(LocalTime.now());

        event1.setDate(LocalDate.now());
        event1.setTime(LocalTime.now());

        event2.setDate(LocalDate.of(LocalDate.now().getYear() + 1 , 11 , 12));
        event2.setTime(LocalTime.now());

        event3.setDate(LocalDate.of(LocalDate.now().getYear() - 10 , 12 , 12));
        event3.setTime(LocalTime.now());

        event4.setDate(LocalDate.of(LocalDate.now().getYear() + 10 , 12 , 12));
        event4.setTime(LocalTime.now());

        events.add(event0);
        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);

        expected.add(event0);
        expected.add(event1);
        expected.add(event3);

        return new Object[][] {
                {events , expected}
        };
    }

    @DataProvider(name = "getComingEventsTestData")
    public static Object[][] getComingEventsTestData() {
        List<Event> events = new ArrayList<>();
        List<Event> expected = new ArrayList<>();
        Event event0 = new Event();
        Event event1 = new Event();
        Event event2 = new Event();
        Event event3 = new Event();
        Event event4 = new Event();

        event0.setDate(LocalDate.of(LocalDate.now().getYear() - 1 , 12 , 12));
        event0.setTime(LocalTime.now());

        event1.setDate(LocalDate.now());
        event1.setTime(LocalTime.now());

        event2.setDate(LocalDate.of(LocalDate.now().getYear() + 1 , 11 , 12));
        event2.setTime(LocalTime.now());

        event3.setDate(LocalDate.of(LocalDate.now().getYear() - 10 , 12 , 12));
        event3.setTime(LocalTime.now());

        event4.setDate(LocalDate.of(LocalDate.now().getYear() + 10 , 12 , 12));
        event4.setTime(LocalTime.now());

        events.add(event0);
        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);

        expected.add(event2);
        expected.add(event4);

        return new Object[][] {
                {events , expected}
        };
    }

    @DataProvider(name = "sortEventsTestData")
    public static Object[][] sortEventsTestData() {
        List<Event> events = new ArrayList<>();
        List<Event> expected = new ArrayList<>();
        Event event0 = new Event();
        Event event1 = new Event();
        Event event2 = new Event();
        Event event3 = new Event();
        Event event4 = new Event();

        event0.setName("b");
        event0.setDate(LocalDate.of(1999 , 12 , 07));
        event0.setTime(LocalTime.of(12 , 12 , 12));

        event1.setName("a");
        event1.setDate(LocalDate.of(1999 , 12 , 07));
        event1.setTime(LocalTime.of(12 , 12 , 12));

        event2.setName("c");
        event2.setDate(LocalDate.of(1998 , 12 , 07));
        event2.setTime(LocalTime.of(12 , 12 , 12));

        event3.setName("d");
        event3.setDate(LocalDate.of(1999 , 12 , 07));
        event3.setTime(LocalTime.of(13 , 12 , 12));

        event4.setName("f");
        event4.setDate(LocalDate.of(2001 , 12 , 07));
        event4.setTime(LocalTime.of(13 , 12 , 12));

        events.add(event0);
        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);

        expected.add(event4);
        expected.add(event3);
        expected.add(event0);
        expected.add(event1);
        expected.add(event2);

        return new Object[][] {
                {events , expected}
        };
    }
}
