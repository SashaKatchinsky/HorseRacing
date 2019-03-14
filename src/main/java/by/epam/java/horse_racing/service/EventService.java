package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.bean.Bet;
import by.epam.java.horse_racing.bean.Event;
import by.epam.java.horse_racing.bean.Rider;
import by.epam.java.horse_racing.dao.BetDaoMySql;
import by.epam.java.horse_racing.dao.EventDaoMySql;
import by.epam.java.horse_racing.dao.RiderDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.service.exceptions.AddEventException;
import by.epam.java.horse_racing.service.exceptions.DeleteEventException;
import by.epam.java.horse_racing.service.exceptions.GetNearestEventException;
import by.epam.java.horse_racing.service.exceptions.UpdateEventException;
import by.epam.java.horse_racing.service.impl.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Event service.
 */
public class EventService implements Service {
    private static class IventServiceHolder {
        private final static EventService INSATNCE = new EventService();
    }

    private EventService() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static EventService getInstance() {
        return IventServiceHolder.INSATNCE;
    }

    /**
     * Gets played events.
     *
     * @param events the events
     * @return the played events
     */
    public List<Event> getPlayedEvents(List<Event> events) {
        List<Event> playedEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(LocalDate.now())) {
                if (event.getTime().compareTo(LocalTime.now()) <= 0) {
                    playedEvents.add(event);
                }
            } else {
                if (event.getDate().compareTo(LocalDate.now()) <= 0) {
                    playedEvents.add(event);
                }
            }
        }
        return playedEvents;
    }

    /**
     * Gets coming events.
     *
     * @param events the events
     * @return the coming events
     */
    public List<Event> getComingEvents(List<Event> events) {
        List<Event> comingEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(LocalDate.now())) {
                if (event.getTime().compareTo(LocalTime.now()) > 0) {
                    comingEvents.add(event);
                }
            } else {
                if (event.getDate().compareTo(LocalDate.now()) > 0) {
                    comingEvents.add(event);
                }
            }
        }
        return comingEvents;
    }

    /**
     * Sort events list by date, time and name.
     *
     * @param events the events
     * @return the list
     */
    public List<Event> sortEvents(List<Event> events) {
        events.sort((o1, o2) -> {
            if (o1.getDate().equals(o2.getDate()) && o1.getTime().equals(o2.getTime())) {
                return o2.getName().compareTo(o1.getName());
            } else {
                if (o1.getDate().equals(o2.getDate())) {
                    return o2.getTime().compareTo(o1.getTime());
                } else {
                    return o2.getDate().compareTo(o1.getDate());
                }
            }
        });
        return events;
    }

    /**
     * Add event with random coefficient generation.
     *
     * @param name     the name
     * @param date     the date
     * @param time     the time
     * @param rider1Id the rider 1 id
     * @param rider2Id the rider 2 id
     * @param rider3Id the rider 3 id
     * @param rider4Id the rider 4 id
     * @throws AddEventException the add event exception
     */
    public void addEventWithCoefGeneration(String name , LocalDate date , LocalTime time , int rider1Id , int rider2Id , int rider3Id , int rider4Id) throws AddEventException {
        try {
            List<Event> events = EventDaoMySql.getInstance().getAllEvents();
            Rider rider1 = RiderDaoMySql.getInstance().getRiderById(rider1Id);
            Rider rider2 = RiderDaoMySql.getInstance().getRiderById(rider2Id);
            Rider rider3 = RiderDaoMySql.getInstance().getRiderById(rider3Id);
            Rider rider4 = RiderDaoMySql.getInstance().getRiderById(rider4Id);
            int iventId;
            while (true) {
                boolean isIdExists = false;
                iventId = (int) (1000 * Math.random());
                for (Event event : events) {
                    if (event.getId() == iventId) {
                        isIdExists = true;
                        break;
                    }
                }
                if (!isIdExists) {
                    break;
                }
            }
            double R1P1 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R1P2 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R1P3 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R1P4 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R2P1 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R2P2 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R2P3 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R2P4 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R3P1 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R3P2 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R3P3 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R3P4 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R4P1 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R4P2 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R4P3 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            double R4P4 = (double) Math.round((10 * Math.random() + 0.01) * 100d) / 100d;
            Event event = new Event(iventId, name, date, time, rider1, rider2, rider3, rider4,
                    R1P1, R1P2, R1P3, R1P4, R2P1, R2P2, R2P3, R2P4, R3P1, R3P2, R3P3, R3P4,
                    R4P1, R4P2, R4P3, R4P4, 0, 0, 0, 0);
            EventDaoMySql.getInstance().insertEvent(event);
            BookmakerService.getInstance().setNewEventInserted(true);
        } catch (DaoException e) {
            throw new AddEventException(e);
        }
    }

    /**
     * Add event without random coefficient generation.
     *
     * @param name     the name
     * @param date     the date
     * @param time     the time
     * @param rider1Id the rider 1 id
     * @param rider2Id the rider 2 id
     * @param rider3Id the rider 3 id
     * @param rider4Id the rider 4 id
     * @param R1P1     the rider 1 position 1
     * @param R1P2     the rider 1 position 2
     * @param R1P3     the rider 1 position 3
     * @param R1P4     the rider 1 position 4
     * @param R2P1     the rider 2 position 1
     * @param R2P2     the rider 2 position 2
     * @param R2P3     the rider 2 position 3
     * @param R2P4     the rider 2 position 4
     * @param R3P1     the rider 3 position 1
     * @param R3P2     the rider 3 position 2
     * @param R3P3     the rider 3 position 3
     * @param R3P4     the rider 3 position 4
     * @param R4P1     the rider 4 position 1
     * @param R4P2     the rider 4 position 2
     * @param R4P3     the rider 4 position 3
     * @param R4P4     the rider 4 position 4
     * @throws AddEventException the add event exception
     */
    public void addEventWithoutCoefGeneration(String name , LocalDate date , LocalTime time , int rider1Id , int rider2Id , int rider3Id , int rider4Id ,
                                              double R1P1 , double R1P2 , double R1P3 , double R1P4 , double R2P1 , double R2P2 , double R2P3 , double R2P4 ,
                                              double R3P1 , double R3P2 , double R3P3 , double R3P4 , double R4P1 , double R4P2 , double R4P3 , double R4P4) throws AddEventException {
        try {
            List<Event> events = EventDaoMySql.getInstance().getAllEvents();
            Rider rider1 = RiderDaoMySql.getInstance().getRiderById(rider1Id);
            Rider rider2 = RiderDaoMySql.getInstance().getRiderById(rider2Id);
            Rider rider3 = RiderDaoMySql.getInstance().getRiderById(rider3Id);
            Rider rider4 = RiderDaoMySql.getInstance().getRiderById(rider4Id);
            int iventId;
            while (true) {
                boolean isIdExists = false;
                iventId = (int) (1000 * Math.random());
                for (Event event : events) {
                    if (event.getId() == iventId) {
                        isIdExists = true;
                        break;
                    }
                }
                if (!isIdExists) {
                    break;
                }
            }
            Event event = new Event(iventId, name, date, time, rider1, rider2, rider3, rider4,
                    R1P1, R1P2, R1P3, R1P4, R2P1, R2P2, R2P3, R2P4, R3P1, R3P2, R3P3, R3P4,
                    R4P1, R4P2, R4P3, R4P4, 0, 0, 0, 0);
            EventDaoMySql.getInstance().insertEvent(event);
            BookmakerService.getInstance().setNewEventInserted(true);
        } catch (DaoException e) {
            throw new AddEventException(e);
        }
    }

    /**
     * Gets nearest event in future.
     *
     * @return the nearest event
     * @throws GetNearestEventException the get nearest event exception
     */
    public synchronized Event getNearestEvent() throws GetNearestEventException {
        List<Event> events = null;
        try {
            events = EventDaoMySql.getInstance().getAllEvents();
        } catch (DaoException e) {
            throw new GetNearestEventException(e);
        }
        List<Event> comingEvents = new ArrayList<>();
        for (Event event : events) {
            if (LocalDateTime.of(event.getDate() , event.getTime()).compareTo(LocalDateTime.now()) >= 0) {
                comingEvents.add(event);
            }
        }
        if (comingEvents.size() != 0) {
            Event event = comingEvents.get(0);
            LocalDateTime min = LocalDateTime.of(comingEvents.get(0).getDate(), comingEvents.get(0).getTime());
            for (int i = 1; i < comingEvents.size(); i++) {
                if ((LocalDateTime.of(comingEvents.get(i).getDate() , comingEvents.get(i).getTime()).compareTo(min) < 0)) {
                    event = comingEvents.get(i);
                    min = LocalDateTime.of(comingEvents.get(i).getDate() , comingEvents.get(i).getTime());
                }
            }
            return event;
        } else {
            return null;
        }
    }

    /**
     * Update event.
     *
     * @param iventId  the ivent id
     * @param name     the name
     * @param date     the date
     * @param time     the time
     * @param rider1Id the rider 1 id
     * @param rider2Id the rider 2 id
     * @param rider3Id the rider 3 id
     * @param rider4Id the rider 4 id
     * @param rider1_1 the rider 1 1
     * @param rider1_2 the rider 1 2
     * @param rider1_3 the rider 1 3
     * @param rider1_4 the rider 1 4
     * @param rider2_1 the rider 2 1
     * @param rider2_2 the rider 2 2
     * @param rider2_3 the rider 2 3
     * @param rider2_4 the rider 2 4
     * @param rider3_1 the rider 3 1
     * @param rider3_2 the rider 3 2
     * @param rider3_3 the rider 3 3
     * @param rider3_4 the rider 3 4
     * @param rider4_1 the rider 4 1
     * @param rider4_2 the rider 4 2
     * @param rider4_3 the rider 4 3
     * @param rider4_4 the rider 4 4
     * @throws UpdateEventException the update event exception
     */
    public void updateEvent(int iventId , String name , LocalDate date , LocalTime time , int rider1Id , int rider2Id , int rider3Id , int rider4Id,
                            double rider1_1 , double rider1_2 , double rider1_3 , double rider1_4 , double rider2_1 , double rider2_2 , double rider2_3 , double rider2_4 ,
                            double rider3_1 , double rider3_2 , double rider3_3 , double rider3_4 , double rider4_1 , double rider4_2 , double rider4_3 , double rider4_4) throws UpdateEventException {
        try {
            Event event = EventDaoMySql.getInstance().getIventById(iventId);
            event.setName(name);
            event.setDate(date);
            event.setTime(time);
            event.setRider1(RiderDaoMySql.getInstance().getRiderById(rider1Id));
            event.setRider2(RiderDaoMySql.getInstance().getRiderById(rider2Id));
            event.setRider3(RiderDaoMySql.getInstance().getRiderById(rider3Id));
            event.setRider4(RiderDaoMySql.getInstance().getRiderById(rider4Id));
            if (!(rider1_1 == 0 || rider1_2 == 0 || rider1_3 == 0 || rider1_4 == 0 || rider2_1 == 0 || rider2_2 == 0 || rider2_3 == 0 || rider2_4 == 0
                    || rider3_1 == 0 || rider3_2 == 0 || rider3_3 == 0 || rider3_4 == 0 || rider4_1 == 0 || rider4_2 == 0 || rider4_3 == 0 || rider4_4 == 0)) {
                event.setRider1Position1Coefficient(rider1_1);
                event.setRider1Position2Coefficient(rider1_2);
                event.setRider1Position3Coefficient(rider1_3);
                event.setRider1Position4Coefficient(rider1_4);
                event.setRider2Position1Coefficient(rider2_1);
                event.setRider2Position2Coefficient(rider2_2);
                event.setRider2Position3Coefficient(rider2_3);
                event.setRider2Position4Coefficient(rider2_4);
                event.setRider3Position1Coefficient(rider3_1);
                event.setRider3Position2Coefficient(rider3_2);
                event.setRider3Position3Coefficient(rider3_3);
                event.setRider3Position4Coefficient(rider3_4);
                event.setRider4Position1Coefficient(rider4_1);
                event.setRider4Position2Coefficient(rider4_2);
                event.setRider4Position3Coefficient(rider4_3);
                event.setRider4Position4Coefficient(rider4_4);
            }
            EventDaoMySql.getInstance().updateEvent(iventId, event);
        } catch (DaoException e) {
            throw new UpdateEventException(e);
        }
    }

    /**
     * Delete event.
     *
     * @param eventId the event id
     * @throws DeleteEventException the delete event exception
     */
    public void deleteEvent(int eventId) throws DeleteEventException {
        try {
            List<Bet> betsWithCurrentEvent = BetDaoMySql.getInstance().getBetsWithCurrentIvent(eventId);
            for (Bet bet : betsWithCurrentEvent) {
                BetDaoMySql.getInstance().deleteBet(bet.getId());
            }
            EventDaoMySql.getInstance().deleteEvent(eventId);
        } catch (DaoException e) {
            throw new DeleteEventException(e);
        }
    }
}
