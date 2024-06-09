package ma.fsr.events1.controllers;

import lombok.AllArgsConstructor;
import ma.fsr.events1.entities.Event;
import ma.fsr.events1.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("api/events")
public class EventController {
    private EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        Event savedEvent = eventService.createEvent(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> getAEventById(@PathVariable("id") Long eventId){
        Event event = eventService.getEventById(eventId);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") Long eventId, @RequestBody Event event){
        Event updatedEvent = eventService.updateEvent(eventId, event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long eventId){
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>("Event deleted Successfully !", HttpStatus.OK);
    }
}
