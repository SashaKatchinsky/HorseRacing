package by.epam.java.horse_racing.validation;

import by.epam.java.horse_racing.bean.Event;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.LocalTime;

public class BetValidationTestData {
    @DataProvider(name = "isTimeValidTestData")
    public static Object[][] isTimeValidTestData() {
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
        event5.setDate(LocalDate.now());
        event5.setTime(LocalTime.now());

        return new Object[][] {
                {event1 , false},
                {event2 , true},
                {event3 , true},
                {event4 , false},
                {event5 , false}
        };
    }

    @DataProvider(name = "isRidersValidTestData")
    public static Object[][] isRidersValidTestData() {
        int rider1Position_1 = 1;
        int rider2Position_1 = 4;
        int rider3Position_1 = 3;
        int rider4Position_1 = 2;

        int rider1Position_2 = 2;
        int rider2Position_2 = 2;
        int rider3Position_2 = 1;
        int rider4Position_2 = 4;

        int rider1Position_3 = 1;
        int rider2Position_3 = 2;
        int rider3Position_3 = 4;

        int rider1Position_4 = 1;
        int rider2Position_4 = 1;
        int rider3Position_4 = 1;
        int rider4Position_4 = 1;

        int rider1Position_5 = 1;
        int rider2Position_5 = 4;

        return new Object[][] {
                {rider1Position_1 , rider2Position_1 , rider3Position_1 , rider4Position_1 , 4 , true},
                {rider1Position_2 , rider2Position_2 , rider3Position_2 , rider4Position_2 , 4 , false},
                {rider1Position_3 , rider2Position_3 , rider3Position_3 , 0 , 3 , true},
                {rider1Position_4 , rider2Position_4 , rider3Position_4 ,  rider1Position_4 , 4 , false},
                {rider1Position_5 , rider2Position_5 , 0 , 0 , 2 , true}
        };
    }
}
