package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.bean.*;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BetServiceTestData {

    @DataProvider(name = "formBetsTestData")
    public static Object[][] formBetsTestData() {
        List<Bet> bets = new ArrayList<>();
        List<Bet> expected = new ArrayList<>();

        Bet bet0 = new Bet();
        Bet bet1 = new Bet();
        Bet bet2 = new Bet();
        Bet bet3 = new Bet();
        Bet bet4 = new Bet();

        User user = new User("a" , "a".toCharArray() , "a" , 1 , "1970-01-01" , Access.USER);

        bet0.setDate(LocalDate.of(1999 , 12 , 07));
        bet0.setTime(LocalTime.of(13 , 34 , 55));
        bet0.setUser(user);

        bet1.setDate(LocalDate.of(1999 , 12 , 07));
        bet1.setTime(LocalTime.of(14 , 15 , 50));
        bet1.setUser(user);

        bet2.setDate(LocalDate.of(2015 , 05 , 27));
        bet2.setTime(LocalTime.of(05 , 17 , 25));
        bet2.setUser(user);

        bet3.setDate(LocalDate.of(2017 , 02 , 13));
        bet3.setTime(LocalTime.of(03 , 10 , 55));
        bet3.setUser(user);

        bet4.setDate(LocalDate.of(1975 , 07 , 11));
        bet4.setTime(LocalTime.of(15 , 15 , 15));
        bet4.setUser(user);

        bets.add(bet0);
        bets.add(bet1);
        bets.add(bet2);
        bets.add(bet3);
        bets.add(bet4);

        expected.add(bet3);
        expected.add(bet2);
        expected.add(bet1);
        expected.add(bet0);
        expected.add(bet4);
        return new Object[][] {
                {bets , expected}
        };
    }

    @DataProvider(name = "getPlayedBetsTestData")
    public static Object[][] getPlayedBetsTestData() {
        List<Bet> bets = new ArrayList<>();
        List<Bet> expected = new ArrayList<>();

        Bet bet0 = new Bet();
        Bet bet1 = new Bet();
        Bet bet2 = new Bet();
        Bet bet3 = new Bet();
        Bet bet4 = new Bet();

        Event event0 = new Event();
        Event event1 = new Event();
        Event event2 = new Event();
        Event event3 = new Event();
        Event event4 = new Event();

        event0.setDate(LocalDate.of(LocalDate.now().getYear() - 1 , 03 , 05));
        event0.setTime(LocalTime.now());

        event1.setDate(LocalDate.of(LocalDate.now().getYear() + 1 , 12 , 07));
        event1.setTime(LocalTime.now());

        event2.setDate(LocalDate.of(LocalDate.now().getYear() - 10 , 12 , 12));
        event2.setTime(LocalTime.now());

        event3.setDate(LocalDate.of(LocalDate.now().getYear() + 95 , 04 , 19));
        event3.setTime(LocalTime.now());

        event4.setDate(LocalDate.now());
        event4.setTime(LocalTime.now());

        bet0.setEvent(event0);
        bet1.setEvent(event1);
        bet2.setEvent(event2);
        bet3.setEvent(event3);
        bet4.setEvent(event4);

        bets.add(bet0);
        bets.add(bet1);
        bets.add(bet2);
        bets.add(bet3);
        bets.add(bet4);

        expected.add(bet0);
        expected.add(bet2);
        expected.add(bet4);
        return new Object[][] {
                {bets , expected}
        };
    }

    @DataProvider(name = "getComingBetsTestData")
    public static Object[][] getComingBetsTestData() {
        List<Bet> bets = new ArrayList<>();
        List<Bet> expected = new ArrayList<>();

        Bet bet0 = new Bet();
        Bet bet1 = new Bet();
        Bet bet2 = new Bet();
        Bet bet3 = new Bet();
        Bet bet4 = new Bet();

        Event event0 = new Event();
        Event event1 = new Event();
        Event event2 = new Event();
        Event event3 = new Event();
        Event event4 = new Event();

        event0.setDate(LocalDate.of(LocalDate.now().getYear() - 1 , 03 , 05));
        event0.setTime(LocalTime.now());

        event1.setDate(LocalDate.of(LocalDate.now().getYear() + 1 , 12 , 07));
        event1.setTime(LocalTime.now());

        event2.setDate(LocalDate.of(LocalDate.now().getYear() - 10 , 12 , 12));
        event2.setTime(LocalTime.now());

        event3.setDate(LocalDate.of(LocalDate.now().getYear() + 95 , 04 , 19));
        event3.setTime(LocalTime.now());

        event4.setDate(LocalDate.now());
        event4.setTime(LocalTime.now());

        bet0.setEvent(event0);
        bet1.setEvent(event1);
        bet2.setEvent(event2);
        bet3.setEvent(event3);
        bet4.setEvent(event4);

        bets.add(bet0);
        bets.add(bet1);
        bets.add(bet2);
        bets.add(bet3);
        bets.add(bet4);

        expected.add(bet1);
        expected.add(bet3);
        return new Object[][] {
                {bets , expected}
        };
    }

    @DataProvider(name = "getCoefTypeByRiderPositionTestData")
    public static Object[][] getCoefTypeByRiderPositionTestData() {
        Event event = new Event();

        event.setRider1Position1Coefficient(2.3);
        event.setRider1Position2Coefficient(3.4);
        event.setRider1Position3Coefficient(1.2);
        event.setRider1Position4Coefficient(3.6);

        event.setRider2Position1Coefficient(5.5);
        event.setRider2Position2Coefficient(1.1);
        event.setRider2Position3Coefficient(1.9);
        event.setRider2Position4Coefficient(4.5);

        event.setRider3Position1Coefficient(9.9);
        event.setRider3Position2Coefficient(5.6);
        event.setRider3Position3Coefficient(2.2);
        event.setRider3Position4Coefficient(3.3);

        event.setRider4Position1Coefficient(7.7);
        event.setRider4Position2Coefficient(5.9);
        event.setRider4Position3Coefficient(8.1);
        event.setRider4Position4Coefficient(8.4);

        List<Object> result11 = new ArrayList<>();
        result11.add(event.getRider1Position1Coefficient());
        result11.add(BetType.FIRST_RIDER_1_PLACE.toString());

        List<Object> result12 = new ArrayList<>();
        result12.add(event.getRider1Position2Coefficient());
        result12.add(BetType.FIRST_RIDER_2_PLACE.toString());

        List<Object> result13 = new ArrayList<>();
        result13.add(event.getRider1Position3Coefficient());
        result13.add(BetType.FIRST_RIDER_3_PLACE.toString());

        List<Object> result14 = new ArrayList<>();
        result14.add(event.getRider1Position4Coefficient());
        result14.add(BetType.FIRST_RIDER_4_PLACE.toString());

        List<Object> result21 = new ArrayList<>();
        result21.add(event.getRider2Position1Coefficient());
        result21.add(BetType.SECOND_RIDER_1_PLACE.toString());

        List<Object> result22 = new ArrayList<>();
        result22.add(event.getRider2Position2Coefficient());
        result22.add(BetType.SECOND_RIDER_2_PLACE.toString());

        List<Object> result23 = new ArrayList<>();
        result23.add(event.getRider2Position3Coefficient());
        result23.add(BetType.SECOND_RIDER_3_PLACE.toString());

        List<Object> result24 = new ArrayList<>();
        result24.add(event.getRider2Position4Coefficient());
        result24.add(BetType.SECOND_RIDER_4_PLACE.toString());

        List<Object> result31 = new ArrayList<>();
        result31.add(event.getRider3Position1Coefficient());
        result31.add(BetType.THIRD_RIDER_1_PLACE.toString());

        List<Object> result32 = new ArrayList<>();
        result32.add(event.getRider3Position2Coefficient());
        result32.add(BetType.THIRD_RIDER_2_PLACE.toString());

        List<Object> result33 = new ArrayList<>();
        result33.add(event.getRider3Position3Coefficient());
        result33.add(BetType.THIRD_RIDER_3_PLACE.toString());

        List<Object> result34 = new ArrayList<>();
        result34.add(event.getRider3Position4Coefficient());
        result34.add(BetType.THIRD_RIDER_4_PLACE.toString());

        List<Object> result41 = new ArrayList<>();
        result41.add(event.getRider4Position1Coefficient());
        result41.add(BetType.FOURTH_RIDER_1_PLACE.toString());

        List<Object> result42 = new ArrayList<>();
        result42.add(event.getRider4Position2Coefficient());
        result42.add(BetType.FOURTH_RIDER_2_PLACE.toString());

        List<Object> result43 = new ArrayList<>();
        result43.add(event.getRider4Position3Coefficient());
        result43.add(BetType.FOURTH_RIDER_3_PLACE.toString());

        List<Object> result44 = new ArrayList<>();
        result44.add(event.getRider4Position4Coefficient());
        result44.add(BetType.FOURTH_RIDER_4_PLACE.toString());

        return new Object[][] {
                {event , 1 , 1 , result11},
                {event , 1 , 2 , result12},
                {event , 1 , 3 , result13},
                {event , 1 , 4 , result14},
                {event , 2 , 1 , result21},
                {event , 2 , 2 , result22},
                {event , 2 , 3 , result23},
                {event , 2 , 4 , result24},
                {event , 3 , 1 , result31},
                {event , 3 , 2 , result32},
                {event , 3 , 3 , result33},
                {event , 3 , 4 , result34},
                {event , 4 , 1 , result41},
                {event , 4 , 2 , result42},
                {event , 4 , 3 , result43},
                {event , 4 , 4 , result44}
        };
    }
}
