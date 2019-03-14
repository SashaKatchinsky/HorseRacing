package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.bean.Event;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EventServiceTest {

    @Test(dataProvider = "getPlayedEventsTestData" , dataProviderClass = EventServiceTestData.class)
    public void getPlayedEventsTest(List<Event> events , List<Event> expected) {
        //when
        List<Event> actual = EventService.getInstance().getPlayedEvents(events);
        //then
        Assert.assertEquals(actual , expected);
    }

    @Test(dataProvider = "getComingEventsTestData" , dataProviderClass = EventServiceTestData.class)
    public void getComingEventsTest(List<Event> events , List<Event> expected) {
        //when
        List<Event> actual = EventService.getInstance().getComingEvents(events);
        //then
        Assert.assertEquals(actual , expected);
    }

    @Test(dataProvider = "sortEventsTestData" , dataProviderClass = EventServiceTestData.class)
    public void sortEventsTest(List<Event> events , List<Event> expected) {
        //when
        List<Event> actual = EventService.getInstance().sortEvents(events);
        //then
        Assert.assertEquals(actual , expected);
    }
}
