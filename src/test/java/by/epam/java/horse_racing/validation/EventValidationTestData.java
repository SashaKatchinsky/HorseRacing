package by.epam.java.horse_racing.validation;

import org.testng.annotations.DataProvider;

public class EventValidationTestData {
    @DataProvider(name = "isRidersValidTestData")
    public static Object[][] isRidersValidTestData() {
        int event1Id_1 = 233;
        int event2Id_1 = 454;
        int event3Id_1 = 123;
        int event4Id_1 = 999;

        int event1Id_2 = 443;
        int event2Id_2 = 443;
        int event3Id_2 = 666;
        int event4Id_2 = 555;

        int event1Id_3 = 111;
        int event2Id_3 = 111;
        int event3Id_3 = 111;
        int event4Id_3 = 111;

        int event1Id_4 = 454;
        int event2Id_4 = 123;
        int event3Id_4 = 879;
        int event4Id_4 = 333;

        int event1Id_5 = 132;
        int event2Id_5 = 123;
        int event3Id_5 = 123;
        int event4Id_5 = 444;

        return new Object[][] {
                {event1Id_1 , event2Id_1 , event3Id_1 , event4Id_1 , true},
                {event1Id_2 , event2Id_2 , event3Id_2 , event4Id_2 , false},
                {event1Id_3 , event2Id_3 , event3Id_3 , event4Id_3 , false},
                {event1Id_4 , event2Id_4 , event3Id_4 , event4Id_4 , true},
                {event1Id_5 , event2Id_5 , event3Id_5 , event4Id_5 , false}
        };
    }
}
