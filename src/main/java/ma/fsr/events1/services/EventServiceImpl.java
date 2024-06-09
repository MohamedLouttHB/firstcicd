package ma.fsr.events1.services;

import lombok.AllArgsConstructor;
import ma.fsr.events1.entities.Event;
import ma.fsr.events1.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class EventServiceImpl implements EventService{
    private EventRepository eventRepository;
    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event getEventById(long eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        return optionalEvent.orElse(null);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event updateEvent(long eventId, Event event) {
        Event existingEvent = this.getEventById(eventId);
        existingEvent.setTitle(event.getTitle());
        existingEvent.setAcronym(event.getAcronym());
        existingEvent.setVenue(event.getVenue());
        existingEvent.setCity(event.getCity());
        existingEvent.setFirst_day(event.getFirst_day());
        existingEvent.setLast_day(event.getLast_day());
        Event updatedEvent = eventRepository.save(existingEvent);
        return updatedEvent;
    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }
}
