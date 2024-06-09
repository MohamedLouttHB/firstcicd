package ma.fsr.events1.services;

import ma.fsr.events1.entities.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event getEventById(long eventId);

    List<Event> getAllEvents();

    Event updateEvent(long eventId, Event event);

    void deleteEvent(long eventId);

}
