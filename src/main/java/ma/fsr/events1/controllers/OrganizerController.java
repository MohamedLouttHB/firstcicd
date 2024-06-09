package ma.fsr.events1.controllers;

import lombok.AllArgsConstructor;
import ma.fsr.events1.entities.Organizer;
import ma.fsr.events1.services.OrganizerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("api/organizers")
public class OrganizerController {
    private OrganizerService organizerService;

    @PostMapping
    public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer){
        Organizer savedOrganizer = organizerService.createOrganizer(organizer);
        return new ResponseEntity<>(savedOrganizer, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable("id") Long organizerId){
        Organizer organizer = organizerService.getOrganizerById(organizerId);
        return new ResponseEntity<>(organizer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Organizer>> getAllOrganizer(){
        List<Organizer> organizers = organizerService.getAllOrganizers();
        return new ResponseEntity<>(organizers, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Organizer> updateEvent(@PathVariable("id") Long organizerId, @RequestBody Organizer organizer){
        Organizer updatedOrganizer = organizerService.updateOrganizer(organizerId, organizer);
        return new ResponseEntity<>(updatedOrganizer, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long organizerId){
        organizerService.deleteOrganizer(organizerId);
        return new ResponseEntity<>("Organizer deleted Successfully !", HttpStatus.OK);
    }
}
