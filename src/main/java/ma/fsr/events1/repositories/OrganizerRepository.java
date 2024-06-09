package ma.fsr.events1.repositories;

import ma.fsr.events1.entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
