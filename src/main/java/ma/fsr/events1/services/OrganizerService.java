package ma.fsr.events1.services;

import ma.fsr.events1.entities.Event;
import ma.fsr.events1.entities.Organizer;

import java.util.List;

public interface OrganizerService {

    Organizer createOrganizer(Organizer organizer);

    Organizer getOrganizerById(long organizerId);

    List<Organizer> getAllOrganizers();

    Organizer updateOrganizer(long organizerId, Organizer organizer);

    void deleteOrganizer(long organizerId);
}
