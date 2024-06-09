package ma.fsr.events1.services;

import lombok.AllArgsConstructor;
import ma.fsr.events1.entities.Event;
import ma.fsr.events1.entities.Organizer;
import ma.fsr.events1.repositories.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{
    private OrganizerRepository organizerRepository;

    @Override
    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    @Override
    public Organizer getOrganizerById(long organizerId) {
        Optional<Organizer> optionalOrganizer = organizerRepository.findById(organizerId);
        return optionalOrganizer.orElse(null);
    }

    @Override
    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    @Override
    public Organizer updateOrganizer(long organizerId, Organizer organizer) {

        Organizer existingOrganizer = this.getOrganizerById(organizerId);
        existingOrganizer.setName(organizer.getName());
        existingOrganizer.setWeb_page(organizer.getWeb_page());
        existingOrganizer.setContact(organizer.getContact());

        Organizer updatedOrganizer = organizerRepository.save(existingOrganizer);
        return updatedOrganizer;
    }

    @Override
    public void deleteOrganizer(long organizerId) {
        organizerRepository.deleteById(organizerId);

    }
}
